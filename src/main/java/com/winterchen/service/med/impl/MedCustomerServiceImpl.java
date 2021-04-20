package com.winterchen.service.med.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.MedCustomerDao;
import com.winterchen.dao.MedSocreDao;
import com.winterchen.model.MedCustomerDomain;
import com.winterchen.model.MedSocreDomain;
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
    private MedSocreDao medSocreDao;

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
    public MedCustomerDomain saveMedCustomer(MedCustomerDomain medCustomerDomain){
        MedCustomerDomain parent = this.getOne(new QueryWrapper<MedCustomerDomain>().eq("id",medCustomerDomain.getParentId()).eq("status", 1));
        if(Objects.isNull(parent)){
            return null;
        }
        //下一级
        medCustomerDomain.setGrade(parent.getGrade() + 1);
        medCustomerDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.save(medCustomerDomain);
        return medCustomerDomain;
    }

    @Transactional(rollbackFor = Exception.class)
    public MedCustomerDomain updateMedCustomerSocre(MedCustomerDomain medCustomerDomain){
        MedSocreDomain medSocreDomain = new MedSocreDomain();
        medSocreDomain.setSocre(medCustomerDomain.getSocre());
        medSocreDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
        medSocreDomain.setCustomerId(medCustomerDomain.getId());
        medSocreDao.insert(medSocreDomain);

        this.setParentSocre(medCustomerDomain,2);
        return medCustomerDomain;
    }

    private void setParentSocre(MedCustomerDomain medCustomerDomain, int loopTimes){
        if(loopTimes <= 0){
            return;
        }
        //上级
        MedCustomerDomain parent = this.getOne(new QueryWrapper<MedCustomerDomain>().eq("id",medCustomerDomain.getParentId()).eq("status", 1));
        if(Objects.isNull(parent)){
            return ;
        }
        MedSocreDomain parentMedSocreDomain = new MedSocreDomain();
        //上级分佣
        parentMedSocreDomain.setSocre(parent.getRatio() * medCustomerDomain.getSocre());
        parentMedSocreDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
        parentMedSocreDomain.setCustomerId(medCustomerDomain.getId());
        medSocreDao.insert(parentMedSocreDomain);
        medCustomerDomain.setParentId(parent.getParentId());
        //递归调用设置上级佣金
        this.setParentSocre(medCustomerDomain,loopTimes--);
    }

}
