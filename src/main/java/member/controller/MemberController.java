package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.vo.MemberVo;

@Controller
public class MemberController {
	
	@RequestMapping(value="/member/regist", method=RequestMethod.GET)
	public String regist(@ModelAttribute("vo")MemberVo vo){ //model.addAttribute("vo",new MemberVo()) 대신 어노테이션으로 작성
		return "/member/regist";
	}
}
