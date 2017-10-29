package io.vilya.phthonus.module.pms.service;

import java.util.List;

import io.vilya.phthonus.module.pms.model.Password;

/**
 * @author iamaprin
 * @time 2017年10月29日 下午1:31:31
 */
public interface IPasswordService {

	/**
	 * @param id
	 * @return
	 */
	Password getById(Integer id);

	/**
	 * @return
	 */
	List<Password> listByParms();

}
