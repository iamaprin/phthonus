package io.vilya.phthonus.module.pms.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author iamaprin
 * @time 2017年10月14日 下午5:19:21
 */
@Controller
@RequestMapping("/pms/view/main")
public class MainController {

	@RequestMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/html/view/main/index.html");
		return mv;
	}
	
}
