package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 登录拦截器
 * @author wsz
 * @date 2018年1月28日
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{

	/**
	 * 前置拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		//不拦截登录动作的url
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
