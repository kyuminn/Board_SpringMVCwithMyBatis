package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.service.MemberService;
import member.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@RequestMapping(value="/member/regist", method=RequestMethod.GET)
	public String regist(@ModelAttribute("vo")MemberVo vo){ //model.addAttribute("vo",new MemberVo()) 대신 어노테이션으로 작성
		return "/member/regist";
	}
	
	@RequestMapping(value="/member/regist",method=RequestMethod.POST)
	public String regist(@ModelAttribute("vo")MemberVo vo, Errors errors) {
		memberService.regist(vo);
		return "/member/login";
	}
}
