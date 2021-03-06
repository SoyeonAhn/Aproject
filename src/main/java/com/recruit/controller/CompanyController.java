package com.recruit.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recruit.domain.BoardVO;
//import org.zerock.domain.BoardVO;
import com.recruit.domain.CInfoVO;
import com.recruit.domain.RecruitVO;
import com.recruit.service.BoardService;
import com.recruit.service.CompanyAjaxService;
import com.recruit.service.CompanyService;

@Controller
@RequestMapping("/rpjt/*")
public class CompanyController {

	@Inject
	private BoardService boardservice;

	@Inject
	private CompanyService service;

	@Inject
	private CompanyAjaxService jobService;

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@RequestMapping(value = "/C_modify", method = RequestMethod.GET)
	public void modifyGET(String id, Model model) throws Exception {

		model.addAttribute(service.CompanyInfoRead(id));
	}

	@RequestMapping(value = "/C_modify", method = RequestMethod.POST)
	public String modifyPOST(CInfoVO CInfo, RedirectAttributes rttr) throws Exception {

		logger.info("mod post............");

		service.CompanyInfoModify(CInfo);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/rpjt/C_index?id=" + CInfo.getId();
	}

	@RequestMapping(value = "/C_manage", method = RequestMethod.GET)
	public void manage(String id, Model model) throws Exception {

		model.addAttribute("recruitList", service.RecruitList(id));

	}

	@RequestMapping(value = "/C_detail", method = RequestMethod.GET)
	public String detail(Model model) throws Exception {

		return "rpjt/C_detail";
	}

	@RequestMapping(value = "/C_write", method = RequestMethod.GET)
	public void writeGET(String id, Model model) throws Exception {

		model.addAttribute(service.CompanyInfoRead(id));

		model.addAttribute("jobgroupList", jobService.jobgroupList());
		model.addAttribute("codeList", service.CodeList());
		model.addAttribute("regionList", service.RegionList());

	}

	@RequestMapping(value = "/C_write", method = RequestMethod.POST)
	public String writePOST(HttpServletRequest request) throws Exception {

		RecruitVO Recruit = new RecruitVO();

		Recruit.setTitle(request.getParameter("title")); // 타이틀

		Recruit.setCid(request.getParameter("cid")); // 아이디

		String jobGroup1 = request.getParameter("jobgroupid");
		int jobgroup = Integer.parseInt(jobGroup1);
		Recruit.setJobgroupid(jobgroup); // 모집직종

		Recruit.setRgbid(request.getParameter("rgbid")); // 근무지(시/도)

		String rgsid1 = request.getParameter("rgsid");
		int rgsid = Integer.parseInt(rgsid1);
		Recruit.setRgsid(rgsid); // 근무지

		Recruit.setJobdesc(request.getParameter("jobdesc")); // 담당업무

		String recruitnum1 = request.getParameter("recruitnum");
		int recruitnum = Integer.parseInt(recruitnum1);
		Recruit.setRecruitnum(recruitnum); // 모집인원

		String employstatusid1 = request.getParameter("employstatusid");
		int employstatusid = Integer.parseInt(employstatusid1);
		Recruit.setEmploystatusid(employstatusid); // 근무형태

		String salaryid1 = request.getParameter("salaryid");
		int salaryid = Integer.parseInt(salaryid1);
		Recruit.setSalaryid(salaryid); // 급여사항

		String edu1 = request.getParameter("edu");
		int edu = Integer.parseInt(edu1);
		Recruit.setEdu(edu); // 학력
		// System.out.println(edu);
		String exp1 = request.getParameter("exp");
		int exp = Integer.parseInt(exp1);
		Recruit.setExp(exp); // 경력
		// System.out.println(exp);
		Recruit.setAdddesc(request.getParameter("adddesc")); // 상세모집내용
		// System.out.println(request.getParameter("adddesc"));
		service.RecruitWrite(Recruit); // 채용공고등록

		return "redirect:/rpjt/C_index?id=" + request.getParameter("cid");
	}

	@RequestMapping(value = "/C_index", method = RequestMethod.GET)
	public void read(@RequestParam("id") String id, Model model) throws Exception {

		model.addAttribute(service.CompanyInfoRead(id));
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) throws Exception {

		return "rpjt/C_test";
	}

	@RequestMapping(value = "/C_recruitInfo/23", method = RequestMethod.GET)
	public void readRecruit(@PathVariable("id") int id, Model model) throws Exception {

		id = 23;
		model.addAttribute(service.RecruitInfoRead(id));
	}

	@RequestMapping(value = "/joinperson", method = RequestMethod.POST)
	public String joinPost(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("regist post ...........");
		logger.info(board.toString());
		System.out.println("1");
		boardservice.regist(board);
		System.out.println("2");

		rttr.addFlashAttribute("msg", "success");
		return "redirect:/rpjt/index";
	}
}