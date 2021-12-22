package board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import member.vo.MemberVo;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{
//HandlerInterceptor interface를 직접 구현하면 인터페이스에 정의된 모든 메서드를 구현해야 함
//특정 인터페이스의 특정 메서드만 사용하고 싶으면 그 인터페이스를 구현하고 있는 Adapter class를 이용하면 된다
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
