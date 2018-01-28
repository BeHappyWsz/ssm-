package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * 登录控制
 * @author wsz
 * @date 2018年1月28日
 */
@Controller
public class LoginController {

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
		if("1".equals(username) || "1".equals(password)) {
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

}
