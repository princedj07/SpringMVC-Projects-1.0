package org.spring.app.controller;

import org.spring.app.model.EmailDTO;
import org.spring.app.model.UserInfoDto;
import org.spring.app.service.LCAppEmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class EmailController {

	@Autowired
	private LCAppEmailServiceImpl lcAppEmailServiceImpl;  
	
	@RequestMapping("/sendEmail")
	public String sendEmail(Model model) {

//		@CookieValue(name = "lcApp.userName") String userName,
		
		System.out.println("EmailController.sendEmail()------->>>>>>>");
		model.addAttribute("emailDTO", new EmailDTO());
//		model.addAttribute("userName", userName);
		
		return "send-email-page";
	}

	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("userInfo") UserInfoDto userInfoDto ,@ModelAttribute("emailDTO") EmailDTO emailDTO) {

		System.out.println("EmailController.processEmail()-------->>>>>>");
		
//		String userName = (String) httpSession.getAttribute("userName");
//		String modifiedName = "Mr. " + userName;
//		model.addAttribute("userName", modifiedName);
		
		
		lcAppEmailServiceImpl.sendEmail(userInfoDto.getUserName(), emailDTO.getUserEmail(), userInfoDto.getResult());
		
		return "process-email-page";
	}

}
