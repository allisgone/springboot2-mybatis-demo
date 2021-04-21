package com.winterchen.service.med.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.MedCustomerDao;
import com.winterchen.dao.MedOrderDao;
import com.winterchen.dao.MedSocreDao;
import com.winterchen.model.MedCustomerDomain;
import com.winterchen.model.MedOrderDomain;
import com.winterchen.model.MedSocreDomain;
import com.winterchen.service.med.MedOrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "medOrderService")
@NoArgsConstructor
@AllArgsConstructor
public class MedOrderServiceImpl extends ServiceImpl<MedOrderDao, MedOrderDomain> implements MedOrderService {

    private MedCustomerDao medCustomerDao;

    private MedSocreDao medSocreDao;

    private MedOrderDao medOrderDao;


    @Transactional(rollbackFor = Exception.class)
    public MedSocreDomain addMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception {
        MedCustomerDomain currentUser = medCustomerDao.selectOne(new QueryWrapper<MedCustomerDomain>().eq("id",medOrderDomain.getCustomerId()).eq("status", 1));
        if(Objects.isNull(currentUser)){
            throw new Exception("未找到用户");
        }
        Timestamp current = new Timestamp(System.currentTimeMillis());
        //保存订单
        medOrderDomain.setStatus(0);
        medOrderDomain.setCreateTime(current);
        medOrderDao.insert(medOrderDomain);

        MedSocreDomain medSocreDomain = new MedSocreDomain();
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
        MedCustomerDomain root = medCustomerDao.selectOne(new QueryWrapper<MedCustomerDomain>().eq("id",currentUser.getRootId()).eq("user_type", 1).eq("status", 1));
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

    @Transactional(rollbackFor = Exception.class)
    public MedSocreDomain reduceMedCustomerSocre(MedOrderDomain medOrderDomain) throws Exception {
        if(Objects.isNull(medOrderDomain) || medOrderDomain.getSocre() < 0 ){
            throw new Exception("参数错误");
        }
        float sumCustomerSocre = medOrderDao.sumCustomerSocre(medOrderDomain.getCustomerId());
        if(sumCustomerSocre < medOrderDomain.getSocre()){
            throw new Exception("申请提取积分"+medOrderDomain.getSocre()+"超过实际积分"+sumCustomerSocre);
        }
        medOrderDomain.setStatus(0);
        this.save(medOrderDomain);
        MedSocreDomain medSocreDomain = new MedSocreDomain();
        //扣减为负数
        medSocreDomain.setSocre(-medOrderDomain.getSocre());
        medSocreDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
        medSocreDomain.setCustomerId(medOrderDomain.getId());
        medSocreDomain.setRemark("提取分成");
        //提取需要审核通过才有效
        medSocreDomain.setStatus(0);
        medSocreDomain.setOrderId(medOrderDomain.getId());
        medSocreDao.insert(medSocreDomain);
        return medSocreDomain;
    }

    private void setParentSocre(Long orderId,float socre,Long parentId,int loopTimes){
        if(loopTimes <= 0){
            return;
        }
        //上级
        MedCustomerDomain parent = medCustomerDao.selectOne(new QueryWrapper<MedCustomerDomain>().eq("id",parentId).eq("status", 1));
        if(Objects.isNull(parent)){
            return ;
        }
        MedSocreDomain parentMedSocreDomain = new MedSocreDomain();
        //上级分佣
        socre *= parent.getRatio();
        parentMedSocreDomain.setSocre(socre);
        parentMedSocreDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
        parentMedSocreDomain.setCustomerId(parent.getId());
        parentMedSocreDomain.setRemark("上级分佣");
        parentMedSocreDomain.setStatus(0);
        parentMedSocreDomain.setOrderId(orderId);
        medSocreDao.insert(parentMedSocreDomain);
        //递归调用设置上级佣金
        this.setParentSocre(orderId, socre, parent.getParentId(),loopTimes--);
    }

}
