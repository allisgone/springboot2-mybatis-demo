package com.winterchen.service.med.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.MedCustomerDao;
import com.winterchen.dao.MedSmsCodeDao;
import com.winterchen.model.MedCustomerDomain;
import com.winterchen.model.MedSmsCodeDomain;
import com.winterchen.service.med.MedCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "medCustomerService")
public class MedCustomerServiceImpl  extends ServiceImpl<MedCustomerDao, MedCustomerDomain> implements MedCustomerService {

    @Autowired
    private MedCustomerDao medCustomerDao;
    @Autowired
    private MedSmsCodeDao medSmsCodeDao;

    @Override
    public List<Map> selectCustomerLev(Long userId){
        return medCustomerDao.selectCustomerLev(userId);
    }

    @Override
    public List<MedCustomerDomain> selectByUserType(Integer userType){

        return medCustomerDao.selectByUserType(userType);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MedCustomerDomain saveMedCustomer(MedCustomerDomain medCustomerDomain) throws Exception {
        //查询注册验证码
        MedSmsCodeDomain medSmsCodeDomain = medSmsCodeDao.selectOne(new QueryWrapper< MedSmsCodeDomain >().eq("phone", medCustomerDomain.getUserName())
                .eq("send_type", 2));
        if(Objects.isNull(medSmsCodeDomain)){
            throw new Exception("短信验证码失效或者不存在，请重新发送");
        }else if(!Objects.equals(medSmsCodeDomain.getSmsCode(),medCustomerDomain.getSmsCode())){
            throw new Exception("短信验证码不正确，请重新发送");
        }
        MedCustomerDomain parent = this.getOne(new QueryWrapper<MedCustomerDomain>().eq("id",medCustomerDomain.getParentId()).eq("status", 1));
        if(Objects.isNull(parent)){
            throw new Exception("未找到父级信息");
        }
        MedCustomerDomain exist = this.getOne(new QueryWrapper<MedCustomerDomain>().eq("user_name", medCustomerDomain.getUserName()));
        if(Objects.nonNull(exist)){
            throw new Exception("用户已存在");
        }
        //下一级
        medCustomerDomain.setGrade(parent.getGrade() + 1);
        //设置根节点 便于后续查询
        //自己是加盟商
        if(medCustomerDomain.getUserType() == 1){
            //设置为根节点id
            medCustomerDomain.setRootId(1L);
        }else{
            //自己是普通用户，上一级为加盟商
            if(parent.getUserType() == 1){
                medCustomerDomain.setRootId(parent.getId());
            }else{
                //否则直接复制上一级的rootId
                medCustomerDomain.setRootId(parent.getRootId());
            }
            //普通用户设置代理额外提成比率为0
            medCustomerDomain.setProxyRatio(0.0f);
            //普通用户下级写死为2
            medCustomerDomain.setChildLev(2);
        }
        medCustomerDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.save(medCustomerDomain);
        //清除短信验证码
        medSmsCodeDao.deleteById(medSmsCodeDomain.getId());
        return medCustomerDomain;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MedCustomerDomain loginMedCustomer(MedCustomerDomain medCustomerDomain) throws Exception {
        //查询注册验证码
        MedSmsCodeDomain medSmsCodeDomain = medSmsCodeDao.selectOne(new QueryWrapper< MedSmsCodeDomain >().eq("phone", medCustomerDomain.getUserName())
                .eq("send_type", 1));
        if(Objects.isNull(medSmsCodeDomain)){
            throw new Exception("短信验证码失效或者不存在，请重新发送");
        }else if(!Objects.equals(medSmsCodeDomain.getSmsCode(),medCustomerDomain.getSmsCode())){
            throw new Exception("短信验证码不正确，请重新发送");
        }
        MedCustomerDomain exist = this.getOne(new QueryWrapper<MedCustomerDomain>().eq("user_name", medCustomerDomain.getUserName())
        .eq("status", 1));
        if (Objects.isNull(exist)) {
            throw new Exception("用户不存在");
        }
        //清除短信验证码
        medSmsCodeDao.deleteById(medSmsCodeDomain.getId());
        return exist;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MedCustomerDomain medCustomerSet(MedCustomerDomain medCustomerDomain) throws Exception{
        MedCustomerDomain exist = this.getOne(new QueryWrapper<MedCustomerDomain>().eq("user_name", medCustomerDomain.getUserName())
                .eq("status", 1));
        if (Objects.isNull(exist)) {
            throw new Exception("用户不存在");
        }
        exist.setExtData(medCustomerDomain.getExtData());
        this.updateById(exist);
        return exist;
    }
}
