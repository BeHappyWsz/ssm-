package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import common.Result;
import service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
//	private static final String MODELPATH= "/";
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	/**
	 * 使用RowBounds模拟分页
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/page")
	public Result page() {
		return userService.getPage();
	}
	
}
