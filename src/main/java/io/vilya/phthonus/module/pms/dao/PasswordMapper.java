package io.vilya.phthonus.module.pms.dao;

import java.util.List;

import io.vilya.phthonus.module.pms.model.Password;

public interface PasswordMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Password record);

    int insertSelective(Password record);

    Password selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Password record);

    int updateByPrimaryKey(Password record);
    
    List<Password> listByParms();
}