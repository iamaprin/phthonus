package io.vilya.phthonus.module.pms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.vilya.phthonus.module.pms.dao.PasswordMapper;
import io.vilya.phthonus.module.pms.model.Password;
import io.vilya.phthonus.module.pms.service.IPasswordService;

/**
 * @author iamaprin
 * @time 2017年10月29日 下午1:32:00
 */
@Service
public class PasswordServiceImpl implements IPasswordService {

	@Autowired
	private PasswordMapper passwordMapper;
	
	@Override
	public Password getById(Integer id) {
		return passwordMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Password> listByParms() {
		return passwordMapper.listByParms();
	}
	
	
	
	
	
	
	
	
	
	
	
}
