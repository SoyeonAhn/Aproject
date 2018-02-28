package com.recruit.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recruit.domain.PUserVO;
import com.recruit.service.PUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/personal/*")
public class PersonalController {
	//p194 앞 뒤로
	private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);
	
	@Inject
	private PUserService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//개인정보관리
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexGET(PUserVO vo1, Model model)throws Exception {
		logger.info("index GET, 개인정보 확인");
		PUserVO vo = new PUserVO();
		vo.setId("jin");//이거는 로그인해서 id받아오도록 로그인 완성되면 합치면서 수정
		logger.info(vo.toString());
		service.selectPUser(vo.getId());
		model.addAttribute(service.selectPUser(vo.getId()));
		return "personal/P_index";
	}
	//개인정보수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String indexPOST(PUserVO vo, Model model)throws Exception {
		//수정하는 페이지
		//vo.setId("jin");
		//model.addAttribute(service.selectPUser(vo.getId()));
		return "personal/P_modify";
	}
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String indexPOST(PUserVO vo, Model model, RedirectAttributes rttr)throws Exception {
		logger.info("index POST, 개인정보 수정");
		logger.info(vo.toString());
		service.updatePUser(vo);
		//model.addAttribute("result", "success");
		rttr.addFlashAttribute("result", "success");
		return "redirect:/personal/index"; //redirect는 controller
	}
	//이력서 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET(PUserVO puser, Model model) throws Exception {
		return "personal/P_write";
	}
	//이력서 관리
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageGET(PUserVO puser, Model model) throws Exception {
		return "personal/P_manage";
	}
	//추천채용공고
	@RequestMapping(value = "/recom", method = RequestMethod.GET)
	public String recomGET(PUserVO puser, Model model) throws Exception {
		return "personal/P_recom";
	}
	//관심채용공고
	@RequestMapping(value = "/favor", method = RequestMethod.GET)
	public String favorGET(PUserVO puser, Model model) throws Exception {
		return "personal/P_favor";
	}
	//지원현황리스트
	@RequestMapping(value = "/applied", method = RequestMethod.GET)
	public String appliedGET(PUserVO puser, Model model) throws Exception {
		return "personal/P_applied"; 
	}
	
}	
