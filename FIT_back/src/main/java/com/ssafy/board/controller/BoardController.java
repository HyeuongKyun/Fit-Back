package com.ssafy.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.board.model.dto.Video;
import com.ssafy.board.model.service.UserService;
import com.ssafy.board.model.service.VideoService;

@Controller
public class BoardController {
	
	private VideoService vs;
	private UserService us;
	
//	@Autowired
//	private ReviewService reviewService;
//	@Autowired
//	private VideoService videoService;
	
	
	
	
//	@RequestMapping("리뷰어쩌고")
//	public String aGetProductList(Model model,@RequestParam(value="videoId",required=false)String videoId,@RequestParam(value="userId",required=false)String userId) {
//		Map<String,String>map = new HashMap<String,String>();
//		map.put("videoId", videoId);
//		map.put("userId", userId);
//		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("productList", productService.getCurrentProductList(map));
//		return "admin/product/productList";
//	}
//	
	
	
//	
	
	
	@RequestMapping("/")	
	public String showIndex() {
		return "redirect:list";
	}
	
	@RequestMapping("")
	public String list(Model model) {
		List<Video> list = vs.getAllVideoList();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
//	
//	@RequestMapping("login")
//	public String login(String userId, String password) {
//		if(us.login(userId, password)) {
//			return "/board/list";
//		}
//		return "/board/loginform";
//	}
////	
//	@RequestMapping("writeform")
//	public String writeform() {
//		return "/board/writeform";
//	}
//	
//	@RequestMapping("write")
//	public String write(Board board) {
//		System.out.println("등록전 : "+board);
//		boardService.writeBoard(board);
//		System.out.println("등록후 : "+board);
////		return "redirect:list";  //키값을 몰라서 상세화면으로 사실 보낼수가 없었어... 
//		return "redirect:detail?id="+board.getId();
//	}
//	
////	@RequestMapping( value = "detail", method = RequestMethod.GET)
////	@GetMapping("detail")
//	@RequestMapping("detail")
//	public String detail(Model model, int id) {
//		Board board = boardService.readBoard(id);
//		model.addAttribute("board", board);
//		return "/board/detail";
//	}
//	
//	@RequestMapping("delete")
//	public String delete(int id) {
//		boardService.removeBoard(id);
//		return "redirect:list";
//	}
//	
//	@RequestMapping("updateform")
//	public String updateform(Model model, int id) {
//		model.addAttribute("board", boardService.getBoard(id));
//		return "/board/updateform";
//	}
//	
//	@RequestMapping("update")
//	public String update(Board board) {
//		boardService.modifyBoard(board);
//		return "redirect:detail?id=" + board.getId();
//	}
//	
//	//검색기능있다.
//	
//	@RequestMapping("search")
//	public String search(Model model, SearchCondition condition) {
//		List<Board> list = boardService.search(condition);
//		model.addAttribute("list", list);
//		return "/board/list";
//	}
//	
	
	
}
