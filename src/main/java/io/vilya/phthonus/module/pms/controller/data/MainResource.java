package io.vilya.phthonus.module.pms.controller.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.vilya.phthonus.module.pms.model.Password;
import io.vilya.phthonus.module.pms.service.IPasswordService;

/**
 * @author iamaprin
 * @time 2017年10月14日 下午5:19:01
 */
@RestController
@RequestMapping("/pms/data/main")
public class MainResource {

	@Autowired
	private IPasswordService passwordService;
	
	@RequestMapping(path="", method={RequestMethod.GET})
	public List<Password> list() {
		return passwordService.listByParms();
	}

	
	
	
	
	
	
	
	
	
	
}
