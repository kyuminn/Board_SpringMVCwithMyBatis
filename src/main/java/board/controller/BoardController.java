package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.service.BoardService;
import board.validator.WriteValidator;
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
	
	@RequestMapping(value="board/write",method=RequestMethod.GET)
	public String write(@ModelAttribute("vo")BoardVo vo) {
		return "/board/write";
	}
	
	@RequestMapping(value="board/write",method=RequestMethod.POST)
	public String write(@ModelAttribute("vo")BoardVo vo, Errors errors) {
		new WriteValidator().validate(vo, errors);
		if(errors.hasErrors()) {
			return "/board/write";
		}
		//try-catch문으로 감싸서 Exception 넣어야 하나..?
		boardService.write(vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/detail/{seq}")
	public String read(@PathVariable("seq")int seq,Model model) {
		BoardVo vo = boardService.read(seq);
		model.addAttribute("vo",vo);
		return "/board/detail";
	}
}
