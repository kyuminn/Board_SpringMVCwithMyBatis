package board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import board.service.BoardService;
import board.vo.BoardVo;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService=boardService;
	}
	
	//Model : 컨트롤러에서 뷰로 전달해주는 정보를 담고 있는 객체, 매개변수에 선언해주면 DispatcherServlet이 알아서 생성해서 넣어줌
	@RequestMapping("/board/list")
	public String list(Model model) {
		model.addAttribute("boardList",boardService.list());
		return "/board/list";
	}
	
	@RequestMapping(value="/board/write",method=RequestMethod.GET)
	public String write(@ModelAttribute("vo")BoardVo vo) {
		return "/board/write";
	}
	
	@RequestMapping(value="/board/write",method=RequestMethod.POST)
	public String write(@Valid@ModelAttribute("vo")BoardVo vo, /*Errors errors*/ BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/board/write";
		}
//		new WriteValidator().validate(vo, errors);
//		if(errors.hasErrors()) {
//			return "/board/write";
//		}
		//try-catch문으로 감싸서 Exception 넣어야 하나..?
		boardService.write(vo);
		return "redirect:/board/list";
		// redirect를 쓰지 않고 그냥 /board/list를 쓰면  url이 변경되지 않아 중복된 글이 등록될 수 있다 (그냥 문자열만 반환하는 경우 jsp파일을 선택해서 forward, url은 그대로)
		// redirect를 써야 /board/list로  url이 변경된다 (redirect를 쓰면 다시 요청하라는 의미이기 때문에 url이 변경됌)
	}
	
	@RequestMapping("/board/detail/{seq}")
	public String read(@PathVariable("seq")int seq,Model model) {
		BoardVo vo = boardService.read(seq);
		model.addAttribute("vo",vo);
		return "/board/detail";
	}
	
	@RequestMapping(value="/board/edit/{seq}",method=RequestMethod.GET)
	public String edit(@PathVariable("seq")int seq,Model model) {
		BoardVo vo = boardService.read(seq);
		model.addAttribute("vo",vo);
		return "/board/edit";
	}
	
	@RequestMapping(value="/board/edit/{seq}",method=RequestMethod.POST)
	public String edit(@Valid@ModelAttribute("vo")BoardVo vo,@PathVariable("seq") int seq, BindingResult bindingResult, int password,Model model) {
		if(bindingResult.hasErrors()) {
			return "/board/edit";
		}else {
			BoardVo DBvalue = boardService.read(seq);
//			System.out.println(vo.getPassword());
//			System.out.println(password);
//			System.out.println(DBvalue.getPassword());
			if(DBvalue.getPassword()==password) {
				boardService.edit(vo);
				return "redirect:/board/list";
			}
		}
		model.addAttribute("msg","비밀번호가 일치하지 않습니다");
		return "/board/edit";
	}
}
