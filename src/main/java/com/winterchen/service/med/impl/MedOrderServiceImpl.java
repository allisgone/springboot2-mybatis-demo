package com.winterchen.service.med.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.MedCustomerDao;
import com.winterchen.dao.MedOrderDao;
import com.winterchen.dao.MedSocreDao;
import com.winterchen.model.MedCustomerDomain;
import com.winterchen.model.MedOrderDomain;
import com.winterchen.model.MedSocreDomain;
import com.winterchen.service.med.MedOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "medOrderService")
public class MedOrderServiceImpl extends ServiceImpl<MedOrderDao, MedOrderDomain> implements MedOrderService {

    @Autowired
    private MedCustomerDao medCustomerDao;

    @Autowired
    private MedSocreDao medSocreDao;

    @Autowired
    private MedOrderDao medOrderDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MedSocreDomain addMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception {
        MedCustomerDomain currentUser = medCustomerDao.selectOne(new QueryWrapper<MedCustomerDomain>()
                .eq("id",medOrderDomain.getCustomerId()).eq("status", 1));
        if(Objects.isNull(currentUser)){
            throw new Exception("未找到用户");
        }
        Timestamp current = new Timestamp(System.currentTimeMillis());
        //保存订单
        medOrderDomain.setStatus(0);
        medOrderDomain.setCreateTime(current);
        medOrderDao.insert(medOrderDomain);

        MedSocreDomain medSocreDomain = new MedSocreDomain();
        //todo 可能这订单金额按照比率来搞分佣
        medSocreDomain.setSocre(medOrderDomain.getSocre());
        medSocreDomain.setCreateTime(current);
        medSocreDomain.setCustomerId(medOrderDomain.getCustomerId());
        medSocreDomain.setStatus(0);
        medSocreDomain.setOrderId(medOrderDomain.getId());
        medSocreDomain.setRemark("订单返佣");
        medSocreDao.insert(medSocreDomain);

        //todo 设置为系统参数
        int loopTimes =2;
        //设置关联的等级分成
        this.setParentSocre(medOrderDomain.getId(),medOrderDomain.getSocre(),currentUser.getParentId(),loopTimes);
        //设置代理人分成
        MedCustomerDomain root = medCustomerDao.selectOne(new QueryWrapper<MedCustomerDomain>().
                eq("id",currentUser.getRootId()).eq("user_type", 1)
                .eq("status", 1));
        if(Objects.nonNull(root)){
            if(currentUser.getGrade() <= root.getChildLev()) {
                MedSocreDomain rootMedSocreDomain = new MedSocreDomain();
                //代理商分佣
                rootMedSocreDomain.setSocre(root.getProxyRatio() * medOrderDomain.getSocre());
                rootMedSocreDomain.setCreateTime(current);
                rootMedSocreDomain.setCustomerId(root.getId());
                rootMedSocreDomain.setRemark("代理商分成");
                rootMedSocreDomain.setStatus(0);
                rootMedSocreDomain.setOrderId(medOrderDomain.getId());
                medSocreDao.insert(rootMedSocreDomain);
            }
        }
        return medSocreDomain;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean agreeMedCustomerSocre(Long orderId) throws Exception {
        MedOrderDomain exist = this.getById(orderId);
        if(Objects.isNull(exist)){
            throw new Exception("未找到记录");
        }
        if(exist.getStatus() != 0){
            throw new Exception("不是申请状态");
        }
        MedSocreDomain needUpdate = new MedSocreDomain();
        needUpdate.setStatus(1);
        medSocreDao.update(needUpdate,new UpdateWrapper<MedSocreDomain>().eq("order_id",orderId).eq("status",0));
        exist.setStatus(1);
        return medOrderDao.updateById(exist) == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MedSocreDomain reduceMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception {
        if(Objects.isNull(medOrderDomain) || medOrderDomain.getSocre() >= 0 ){
            throw new Exception("参数错误");
        }
        float sumCustomerSocre = medOrderDao.sumCustomerSocre(medOrderDomain.getCustomerId());
        if(sumCustomerSocre < (-medOrderDomain.getSocre())){
            throw new Exception("申请提取积分"+(-medOrderDomain.getSocre())+"超过实际积分"+sumCustomerSocre);
        }
        Timestamp current = new Timestamp(System.currentTimeMillis());
        medOrderDomain.setStatus(0);
        medOrderDomain.setCreateTime(current);
        this.save(medOrderDomain);
        MedSocreDomain medSocreDomain = new MedSocreDomain();
        //扣减为负数
        medSocreDomain.setSocre(medOrderDomain.getSocre());
        medSocreDomain.setCreateTime(current);
        medSocreDomain.setCustomerId(medOrderDomain.getId());
        medSocreDomain.setRemark("提取分成");
        //提取需要审核通过才有效
        medSocreDomain.setStatus(0);
        medSocreDomain.setOrderId(medOrderDomain.getId());
        medSocreDao.insert(medSocreDomain);
        return medSocreDomain;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MedOrderDomain reduceMedCustomerSocreConfirm(Long orderId) throws Exception {
        if(Objects.isNull(orderId) ){
            throw new Exception("参数错误");
        }
        MedOrderDomain exist = this.getById(orderId);
        if(Objects.isNull(exist)){
            throw new Exception("未找到记录");
        }
        if(exist.getStatus() != 2){
            throw new Exception("不是抵扣未确认申请");
        }
        float sumCustomerSocre = medOrderDao.sumCustomerSocre(exist.getCustomerId());
        if(sumCustomerSocre < (-exist.getSocre())){
            throw new Exception("申请提取积分"+(-exist.getSocre())+"超过实际积分"+sumCustomerSocre);
        }
        //改成确认申请
        exist.setStatus(0);
        this.updateById(exist);
        MedSocreDomain needUpdate = new MedSocreDomain();
        needUpdate.setStatus(0);
        medSocreDao.update(needUpdate,new UpdateWrapper<MedSocreDomain>().eq("order_id",exist.getId()).eq("status",2));
        return exist;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean rejectMedCustomerSocre(Long orderId) throws Exception {
        MedOrderDomain exist = this.getById(orderId);
        if(Objects.isNull(exist)){
            throw new Exception("未找到记录");
        }
        if(exist.getStatus() != 0){
            throw new Exception("不是申请状态");
        }
        //拒绝后就直接删除掉
        medSocreDao.delete(new QueryWrapper<MedSocreDomain>().eq("order_id", exist.getId()));
        return this.removeById(orderId);
    }

    private void setParentSocre(Long orderId,float socre,Long parentId,int loopTimes){
        if(loopTimes <= 0){
            return;
        }
        //上级
        MedCustomerDomain parent = medCustomerDao.selectById(parentId);
        if(Objects.isNull(parent)){
            return ;
        }
        //上级分佣
        socre *= parent.getRatio();
        //只有是有效用户才给分佣 否则不分佣并且继续到上级分佣
        if(parent.isStatus()) {
            MedSocreDomain parentMedSocreDomain = new MedSocreDomain();
            parentMedSocreDomain.setSocre(socre);
            parentMedSocreDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
            parentMedSocreDomain.setCustomerId(parent.getId());
            parentMedSocreDomain.setRemark("上级分佣");
            parentMedSocreDomain.setStatus(0);
            parentMedSocreDomain.setOrderId(orderId);
            medSocreDao.insert(parentMedSocreDomain);
        }
        //递归调用设置上级佣金
        this.setParentSocre(orderId, socre, parent.getParentId(),loopTimes--);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public float medCustomerScore(String userName) throws Exception {
        MedCustomerDomain exist = medCustomerDao.selectOne(new QueryWrapper<MedCustomerDomain>().eq("user_name", userName)
                .eq("status", 1));
        if (Objects.isNull(exist)) {
            throw new Exception("用户不存在");
        }
        float sumCustomerSocre = medOrderDao.sumCustomerSocre(exist.getId());
        exist.setSocre(sumCustomerSocre);
        //更新积分显示
        medCustomerDao.updateById(exist);
        return sumCustomerSocre;
    }

    @Override
    public IPage<MedSocreDomain> medCustomerScoreList(String userName,String type,int page, int limit) throws Exception{
        MedCustomerDomain exist = medCustomerDao.selectOne(new QueryWrapper<MedCustomerDomain>().eq("user_name", userName)
                .eq("status", 1));
        if (Objects.isNull(exist)) {
            throw new Exception("用户不存在");
        }
        switch (type){
            case "all":
                return medSocreDao.selectPage(new Page<>(page,limit),new QueryWrapper<MedSocreDomain>().eq("customer_id",exist.getId())
                        .orderByDesc("id"));
            case "unapply":
                return medSocreDao.selectPage(new Page<>(page,limit),new QueryWrapper<MedSocreDomain>().eq("customer_id",exist.getId())
                        .eq("status",0).gt("socre",0).orderByDesc("id"));
            case "apply":
                return medSocreDao.selectPage(new Page<>(page,limit),new QueryWrapper<MedSocreDomain>().eq("customer_id",exist.getId())
                        .eq("status",1).gt("socre",0).orderByDesc("id"));
            case "reduceUncheck":
                return medSocreDao.selectPage(new Page<>(page,limit),new QueryWrapper<MedSocreDomain>().eq("customer_id",exist.getId())
                        .eq("status",2).lt("socre",0).orderByDesc("id"));
            case "reduceUnapply":
                return medSocreDao.selectPage(new Page<>(page,limit),new QueryWrapper<MedSocreDomain>().eq("customer_id",exist.getId())
                        .eq("status",0).lt("socre",0).orderByDesc("id"));
            case "reduceApply":
                return medSocreDao.selectPage(new Page<>(page,limit),new QueryWrapper<MedSocreDomain>().eq("customer_id",exist.getId())
                        .eq("status",1).lt("socre",0).orderByDesc("id"));
            default:
                throw new Exception("未找到匹配类型");
        }

    }

    @Override
    public MedOrderDomain getByOrderId(Long id) {
        return this.getById(id);
    }
}
