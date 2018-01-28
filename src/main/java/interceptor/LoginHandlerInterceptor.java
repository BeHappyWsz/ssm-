package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * ��¼������
 * @author wsz
 * @date 2018��1��28��
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{

	/**
	 * ǰ������
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		//�����ص�¼������url
		if(request.getRequestURI().endsWith("login") || request.getSession().getAttribute("username") != null) {
			return true;
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
