package com.recruit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.recruit.domain.PUserVO;
import com.recruit.domain.ResumeVO;
import com.recruit.service.CRecruitService;
import com.recruit.service.PUserService;
import com.recruit.service.ResumeService;
import com.recruit.util.MediaUtils;
import com.recruit.util.UploadFileUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/personal/*")
public class PersonalController {
	// p194 앞 뒤로
	private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);

	@Inject
	private PUserService service;

	@Inject
	private CRecruitService Cservice;
	
	@Inject
	private ResumeService Rservice;
	
	// 개인정보관리
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexGET(Model model) throws Exception {
		// public String indexGET(@RequestParam("id") String id, Model
		// model)throws Exception {
		logger.info("index GET, 개인정보 확인");

		PUserVO PUser = new PUserVO();
		PUser.setId("jin3");// 이거는 로그인해서 id받아오도록 로그인 완성되면 합치면서 수정
		// logger.info(vo.toString());
		// service.selectPUser(vo.getId());
		model.addAttribute(service.selectPUser(PUser.getId()));

		// service.updatePUser(vo.getId());
		return "personal/P_index";
	}

	// 개인정보수정
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String indexPOST(@RequestParam("id") String id, Model model) throws Exception {
		// 수정하는 페이지
		logger.info("index에서 넘겨받은 id" + id);
		logger.info(service.selectPUser(id).toString());
		model.addAttribute("PUserVO", service.selectPUser(id));
		return "personal/P_modify";
	}

	// 수정한거 db로 전달하는 페이지
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String indexPOST(PUserVO PUser, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("index POST, 개인정보 수정");
		logger.info(PUser.toString());
		service.updatePUser(PUser);
		model.addAttribute("result", "success");
		rttr.addFlashAttribute("result", "success");
		
		return "redirect:/personal/index"; // redirect는 controller
	}

	// 이력서 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET(PUserVO puser, Model model) throws Exception {
		System.out.println("왜안돼1");
		System.out.println(puser.toString());
		return "personal/P_write";
	}
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(ResumeVO resume,Model model) throws Exception {
		System.out.println("왜안돼");
		System.out.println(resume.toString());
		int bno = resume.getBno();
		
		System.out.println("bno"+bno);
		
		Rservice.createROne(resume);
		return "redirect:/personal/detail?bno="+bno+""; // redirect는 controller
	}
	
	//이력서 하나 읽기
	   @RequestMapping(value = "/detail", method = RequestMethod.GET)
	   public String modifyGET(int bno, Model model) throws Exception {
		   
		   PUserVO PUser = new PUserVO();
		   PUser.setId("jin3");// 이거는 로그인해서 id받아오도록 로그인 완성되면 합치면서 수정\
		   
		   model.addAttribute("PUserVO",service.selectPUser(PUser.getId()));
		   
		   model.addAttribute("ResumeVO",Rservice.readROne(bno));

	      return "personal/P_detail";
	   }
	   
    // 선택한 이력서 수정하는 페이지
	@RequestMapping(value = "/Rmodify", method = RequestMethod.GET)
	public String RmodifyPOST(Integer bno, Model model) throws Exception {
		// 수정하는 페이지
		model.addAttribute("PUserVO", service.selectPUser("jin3"));
		model.addAttribute("ResumeVO", Rservice.readROne(bno));
		System.out.println("get bno" + bno);
		return "personal/P_Rmodify";
	}

	// 수정한 이력서 db로 전달하는 페이지
	@RequestMapping(value = "/Rmodify", method = RequestMethod.POST)
	public String RmodifyPOST(ResumeVO resume, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("index POST, 개인정보 수정");
		//logger.info(PUser.toString());
		
		System.out.println(resume.toString());
		
		int bno = resume.getBno();
		
		System.out.println("bno"+bno);
		
		Rservice.updateROne(resume);
		
		model.addAttribute("result", "success");
		//rttr.addFlashAttribute("result", "success");
		rttr.addFlashAttribute("bno", "success");
		return "redirect:/personal/detail?bno="+bno+""; // redirect는 controller
	}

	// 이력서 관리 (리스트)
	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageGET(Model model) throws Exception {
		
		String id = "jin3";
		model.addAttribute("ResumeVOList",Rservice.selectRList(id));
		model.addAttribute("PUserVO",service.selectPUser(id));
		
		//System.out.println(Rservice.selectRList(id));
		//System.out.println(Rservice.selectRList(id).toString());
		
		return "personal/P_manage";
	}
	
	@RequestMapping(value = "/Rremove", method = RequestMethod.POST)
	public String RremovePOST(Integer bno, String id, Model model, RedirectAttributes rttr) throws Exception {
	//	System.out.println("여기");
	//	System.out.println(bno);
		Rservice.deleteROne(bno);
	//	model.addAttribute(service.selectPUser(id));
		//rttr.addFlashAttribute("result", "success");
		return "redirect:/personal/manage";
	}

	// 추천채용공고
	@RequestMapping(value = "/recom", method = RequestMethod.GET)
	public String recomGET(@RequestParam("id") String id, Model model) throws Exception {
		
		model.addAttribute("PUserVO",service.selectPUser(id));
		return "personal/P_recom";
	}

	// 관심채용공고
	@RequestMapping(value = "/favor", method = RequestMethod.GET)
	public String favorGET(@RequestParam("id") String id, Model model)throws Exception {
		//public String favorGET(HttpServletRequest request, Model model)throws Exception {
		//String id = request.getParameter("id");
		logger.info("favor GET, 관심채용공고 확인");
		System.out.println(id);
		model.addAttribute("CRecruitVOList",Cservice.selectCRList(id));
		model.addAttribute("PUserVO",service.selectPUser(id));
	//	model.addAttribute(Cservice.selectCRList(id));
		//System.out.println(Cservice.selectCRList(id).toString());
		return "personal/P_favor";
	}
	// 지원현황리스트
	
	@RequestMapping(value = "/applied", method = RequestMethod.GET) public
	String appliedGET(@RequestParam("id") String id, Model model) throws Exception {
		//	private CRecruitService Cservice;
		model.addAttribute("CRecruitVOList",Cservice.selectAPList(id));
		
		model.addAttribute("PUserVO",service.selectPUser(id));
		
		return	"personal/P_applied"; 
	 }
	//////IMG UPLOAD/////////////img upload/////////////////////////////////////////////////////////////
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax(){
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST,
	produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file)throws Exception{
	
		logger.info("originalName : " + file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contetnType: " + file.getContentType());
		
		return new ResponseEntity<>(
				UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value = "/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName)throws Exception{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		logger.info("FILE NAME : " + fileName);
		
		try{
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + fileName);
			
			if(mType!=null){
				headers.setContentType(mType);
			}else{
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition",  "attachment; filename=\""+new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally{
			in.close();
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){
		
		System.out.println(fileName);
		System.out.println("deleteFile POST");
		
		logger.info("delete file : " + fileName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType = MediaUtils.getMediaType(formatName);
		
		if(mType!=null){
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front+end).replace('/',  File.separatorChar)).delete();
		}
		
		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

}