package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.service.MemberService;
import member.validator.LoginValidator;
import member.validator.RegistValidator;
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
		new RegistValidator().validate(vo, errors);
		if(errors.hasErrors()) {
			return "/member/regist";
		}
		memberService.regist(vo);
		return "/member/login";
	}
	
	@RequestMapping(value="/member/login",method=RequestMethod.GET)
	public String login(@ModelAttribute("vo")MemberVo vo) {
		return "/member/login";
	}
	
	@RequestMapping(value="/member/login",method=RequestMethod.POST)
	public String login(@ModelAttribute("vo")MemberVo vo,Errors errors) {
		new LoginValidator().validate(vo, errors);
		if(errors.hasErrors()) {
			return "/member/login";
		}else {
			if(!memberService.authenticate(vo.getEmail()).equals(vo.getPassword())) {
				errors.reject("unMatching"); // 글로벌 에러 코드 표시할때는 reject method 이용
				return "/member/login";
			}
		}
		return "redirect:/board/list";
	}
}
