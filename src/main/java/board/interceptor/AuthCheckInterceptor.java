package board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import member.vo.MemberVo;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			MemberVo vo = (MemberVo)session.getAttribute("authInfo");
			if(vo!=null) {
				return true; // true 반환 시 Controller 동작
			}
		}
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
	}



}
