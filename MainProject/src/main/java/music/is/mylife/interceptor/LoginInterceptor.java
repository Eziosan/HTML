package music.is.mylife.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		
//		HttpSession session = request.getSession();
//		Members members = (Members)session.getAttribute("members");
//		logger.debug("LoginInterceptor 실행");
//		
//		
//		if(members == null) {
//			response.sendRedirect(request.getContextPath() + "/");
//			return false;
//		}
//		
//		return super.preHandle(request, response, handler);
//	}

	//나중에 추가 appServlet에
//	<beans:bean id="LoginInterceptor" class="music.is.mylife.interceptor.LoginInterceptor"></beans:bean>
//	
//	<mvc:interceptors>
//		<mvc:interceptor>
//			<mvc:mapping path="/song/*"/>
//			
//			<beans:ref bean="LoginInterceptor"/>
//		</mvc:interceptor>
//	</mvc:interceptors>
}
