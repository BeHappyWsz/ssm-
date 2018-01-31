package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import common.Result;
import service.UserService;
/**
 * 登录控制
 * @author wsz
 * @date 2018年1月28日
 */
@Controller
public class LoginController {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserService userService;
	
	/**
	 * 登录操作
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,String username,String password) throws ServletException, IOException {
		ModelAndView model = new ModelAndView();
		Result login = userService.login(username,password);
		if(login.getSuccess()) {
			//登录成功
			request.getSession().setAttribute("username", username);
			model.setViewName("redirect:index");//重定向:浏览器url改变
			return model;
		}else {
			//登录失败
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return null;//如果直接返回model,报错误,返回null即可
		}
	}
	
	/**
	 * 退出登录
	 * 1.session失效
	 * 2.跳转登录页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * 使用JdbcTemplate
	 * @return
	 */
	@ResponseBody
	@RequestMapping("template")
	public Result template(){
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from  t_user");
		return new Result(true,"",list);
	}
}
