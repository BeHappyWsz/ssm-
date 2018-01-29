package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import common.Result;
import service.UserService;
/**
 * ��¼����
 * @author wsz
 * @date 2018��1��28��
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	/**
	 * ��¼����
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
			//��¼�ɹ�
			request.getSession().setAttribute("username", username);
			model.setViewName("redirect:index");//�ض���:�����url�ı�
			return model;
		}else {
			//��¼ʧ��
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return null;//���ֱ�ӷ���model,������,����null����
		}
	}
	
	/**
	 * �˳���¼
	 * 1.sessionʧЧ
	 * 2.��ת��¼ҳ��
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
