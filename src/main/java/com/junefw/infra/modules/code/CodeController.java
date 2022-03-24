package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {


	@Autowired
	CodeServiceImpl service;
	

//	infrCodeGroup
	
	@RequestMapping(value = "/code/codeGroupList")
	public String codeGroupList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		
		System.out.println("vo.getThisPage(): " + vo.getThisPage());
		
		
		// count 가져올 것
		int count = service.selectOneCount(vo);
		
		vo.setParamsPaging(count);
		
		if(count != 0) {
			List<Code> list = service.selectList(vo);
			model.addAttribute("list", list);
		} else {
			// by pass
		}
		
		return "code/codeGroupList";
	}
	
	
	@RequestMapping(value = "/code/codeGroupForm")
	public String codeGroupForm(@ModelAttribute("vo") CodeVo vo) throws Exception {

		return "code/codeGroupForm";
	}
	
	
	@RequestMapping(value = "/code/codeGroupInst")
	public String codeGroupInst(Code dto, CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {
		
		System.out.println("dto.getIfcgSeq(): " + dto.getIfcgSeq());	// null
		
		service.insert(dto);

		System.out.println("dto.getIfcgSeq(): " + dto.getIfcgSeq());	// 26

		redirectAttributes.addAttribute("ifcgSeq", dto.getIfcgSeq());	// get
		redirectAttributes.addAttribute("thisPage", vo.getThisPage());	// get
		redirectAttributes.addAttribute("shOption", vo.getShOption());	// get
		redirectAttributes.addAttribute("shValue", vo.getShValue());	// get
		
		return "redirect:/code/codeGroupView";
		
//		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo);

	}
	

	public String makeQueryString(CodeVo vo) {
		String tmp = "&thisPage=" + vo.getThisPage() 
					+ "&shOption=" + vo.getShOption() 
					+ "&shValue=" + vo.getShValue(); 
		return tmp;
	}
	
	
	@RequestMapping(value = "/code/codeGroupView")
	public String codeGroupView(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		System.out.println("#####################################");
		System.out.println("vo.getShOption(): " + vo.getShOption());
		System.out.println("vo.getShValue(): " + vo.getShValue());
		System.out.println("vo.getThisPage(): " + vo.getThisPage());
		System.out.println("vo.getIfcgSeq(): " + vo.getIfcgSeq());
		
		System.out.println("#####################################");
		
		// 디비까지 가서 한 건의 데이터 값을 가지고 온다, VO
		Code rt = service.selectOne(vo);
		
		// 가지고 온값을 jsp로 념겨준다
		model.addAttribute("item", rt);

		return "code/codeGroupView";
	}
	
	
	@RequestMapping(value = "/code/codeGroupForm2")
	public String codeGroupForm2(CodeVo vo, Model model) throws Exception {
		
		// 한건의 데이터를 가져와야겠죠
		Code rt = service.selectOne(vo);
		
		model.addAttribute("rt", rt);
		
		return "code/codeGroupForm2";
	}

		
	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(Code dto, CodeVo vo) throws Exception {
	
		// 수정 프로세스 실행
		service.update(dto);
		
		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo);
	}
	
	
	@RequestMapping(value = "/code/codeGroupDele")
	public String codeGroupDele(CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {
		
		service.delete(vo);
		
	   redirectAttributes.addAttribute("thisPage", vo.getThisPage());	
	   redirectAttributes.addAttribute("shOption", vo.getShOption());	
	   redirectAttributes.addAttribute("shValue", vo.getShValue());	
		
		return "redirect:/code/codeGroupList";
	}
	



//	infrCode
	
	
	@RequestMapping(value = "/code/codeList")
	public String codeList(CodeVo vo, Model model) throws Exception {
		
		List<Code> list = service.selectListCode(vo);
		model.addAttribute("list", list);
		
		List<Code> listCodeGroup = service.selectList(vo);
		model.addAttribute("listCodeGroup", listCodeGroup);
		
		return "code/codeList";
	}
	
	
	@RequestMapping(value = "/code/codeForm")
	public String codeForm(Model model) throws Exception {

//		List<Code> list = service.selectListCode();
		
//		model.addAttribute("list", list);
		
		return "code/codeForm";
	}
	
	
	@RequestMapping(value = "/code/codeInst")
	public String codeInst(Code dto) throws Exception {
		
		service.insertCode(dto);

		return "";
	}
	
	
	@RequestMapping(value = "/code/codeView")
	public String codeView(CodeVo vo, Model model) throws Exception {
		
		Code rt = service.selectOneCode(vo);
		
		model.addAttribute("item", rt);

		return "code/codeView";
	}
	
	
	@RequestMapping(value = "/code/codeForm2")
	public String codeForm2(CodeVo vo, Model model) throws Exception {
		
		Code rt = service.selectOneCode(vo);
		
		model.addAttribute("item", rt);
		
		return "code/codeForm2";
	}

		
	@RequestMapping(value = "/code/codeUpdt")
	public String codeUpdt(Code dto) throws Exception {
	
		service.updateCode(dto);
		
		return "";
	}
	
}
