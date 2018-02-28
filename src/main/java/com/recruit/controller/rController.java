package com.recruit.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.zerock.domain.BoardVO;
import com.recruit.domain.CinfoVO;
//import org.zerock.service.BoardService;

@Controller
@RequestMapping("/rpjt/*")
public class rController {

	private static final Logger logger = LoggerFactory.getLogger(rController.class);

	@Inject
//	private BoardService service;
	
	public CinfoVO makeCinfo(){
		CinfoVO cinfo = new CinfoVO();
		cinfo.setId("id"); // String id;
		cinfo.setCname("동국제약㈜"); // String cname;
		cinfo.setImg(1); // int img;
		cinfo.setHomepage("http://www.dkpharm.co.kr"); // String homepage;
		cinfo.setIntro("1968년 10월 15일에 설립된 완제 의약품 제조업 업종의 의약품(인사돌,복합마데카솔,오라메디,포폴주사),주사제(Prefilled syringe system) 제조,도매,수입 사업을 하는 코스닥기업이며, 자본금은 222억 3,000만원 매출액은 3,044억 815만원 사원수는 813명입니다."); // String intro;
		cinfo.setCeo("오흥주"); // String ceo;
		cinfo.setCtype("완제 의약품 제조업"); // String ctype;
		cinfo.setForm("코스닥, 1000대기업, 중견기업, 외부감사법인, 수출입 기업, 법인사업체"); // String form;
		cinfo.setEstablish("1968년 10월 15일"); // String establish;
		cinfo.setNumemp("813"); // String numemp;
		cinfo.setSales("3,044억 815만원"); // String sales;
		cinfo.setTel("02-2191-9800"); // String tel;
		cinfo.setFax("02-566-8542"); // String fax;
		cinfo.setSns("https://www.instagram.com/exia0710/"); // private String sns;
		cinfo.setLocation("서울 강남구 대치3동 997-8 동국빌딩"); // String location;
		return cinfo;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexGET(CinfoVO cinfo, Model model) throws Exception {
		cinfo = makeCinfo();
		System.out.print(cinfo);
		model.addAttribute(cinfo);
		return "rpjt/C_index";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(CinfoVO cinfo, Model model) throws Exception {
		cinfo = makeCinfo();
		model.addAttribute(cinfo);
		return "rpjt/C_modify";
	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET(CinfoVO cinfo, Model model) throws Exception {
		cinfo = makeCinfo();
		model.addAttribute(cinfo);
		return "rpjt/C_write";
	}

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageGET(CinfoVO cinfo, Model model) throws Exception {
		return "rpjt/C_manage";
	}

	@RequestMapping(value = "/recom", method = RequestMethod.GET)
	public String recomGET(CinfoVO cinfo, Model model) throws Exception {
		return "rpjt/C_recom";
	}

	@RequestMapping(value = "/favor", method = RequestMethod.GET)
	public String favorGET(CinfoVO cinfo, Model model) throws Exception {
		return "rpjt/C_favor";
	}
}
