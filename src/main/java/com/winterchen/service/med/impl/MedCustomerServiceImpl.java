package com.winterchen.service.med.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winterchen.dao.MedCustomerDao;
import com.winterchen.model.MedCustomerDomain;
import com.winterchen.service.med.MedCustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class MedCustomerServiceImpl  extends ServiceImpl<MedCustomerDao, MedCustomerDomain> implements MedCustomerService {

    private MedCustomerDao medCustomerDao;

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
        MedCustomerDomain parent = this.getOne(new QueryWrapper<MedCustomerDomain>().eq("id",medCustomerDomain.getParentId()).eq("status", 1));
        if(Objects.isNull(parent)){
            throw new Exception("未找到父级信息");
        }
        MedCustomerDomain exist = this.getOne(new QueryWrapper<MedCustomerDomain>().eq("user_name", medCustomerDomain.getUserName()));
        if(Objects.isNull(exist)){
            throw new Exception("用户已存在");
        }
        //下一级
        medCustomerDomain.setGrade(parent.getGrade() + 1);
        //设置根节点 便于后续查询
        if(Objects.isNull(medCustomerDomain.getRootId())){
            medCustomerDomain.setRootId(parent.getRootId());
        }
        if(medCustomerDomain.getUserType() == 0){
            medCustomerDomain.setProxyRatio(0.0f);
        }
        medCustomerDomain.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.save(medCustomerDomain);
        return medCustomerDomain;
    }

}
