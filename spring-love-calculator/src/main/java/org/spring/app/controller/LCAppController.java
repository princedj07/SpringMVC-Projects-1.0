package org.spring.app.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.spring.app.model.UserInfoDto;
import org.spring.app.service.LCAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes({"userInfo", ""})
@SessionAttributes("userInfo")  // SessionAtt name should be Model object key. It wont work with @ModelAttribute
public class LCAppController {

	@Autowired
	private LCAppService lcAppService;
	
	@RequestMapping("/")
	public String showHomePage(Model model) {
		System.out.println("Home Page....");

//		public String showHomePage(@ModelAttribute("userInfo") UserInfoDto userInfoDto)
//		Model model
//		UserInfoDto userInfoDto = new UserInfoDto();
//		model.addAttribute("userInfo", userInfoDto);
		
//		Cookie[] cookies = servletRequest.getCookies();
//		for (Cookie temp : cookies) {
//			if("lcApp.userName".equals(temp.getName())) {
//				String userName = temp.getValue();
//				System.out.println("Username is-----: "+userName);
//				userInfoDto.setUserName(userName);
//			}
//		}
		
		model.addAttribute("userInfo", new UserInfoDto());
		
		return "home-page";
		
	}

	@GetMapping("/process-homepage")
	public String processHomePage(Model model, @Valid UserInfoDto userInfoDto, BindingResult bindingResult) {

//		@RequestParam("userName") String userName,@RequestParam("crushName") String crushName
//		public String processHomePage(@Valid @ModelAttribute("userInfo") UserInfoDto userInfoDto, Model model, BindingResult bindingResult) {
		
		
		model.addAttribute("userInfo", userInfoDto);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "userInfo", bindingResult);
		
		System.out.println(userInfoDto.isTermAndCondition());
		
		if(bindingResult.hasErrors()) {
			
			System.out.println("My Form has some Errors...");
			
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				System.out.println("Object Errors : "+ objectError);
			}
			
			return "home-page";
		}
 		
//		Create a cookie for the user name
//		Cookie cookie = new Cookie("lcApp.userName", userInfoDto.getUserName());
//		cookie.setMaxAge(60*60*24);
//		servletResponse.addCookie(cookie);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("userName", userInfoDto.getUserName());
//		session.setMaxInactiveInterval(120);
		
//		write a service which will calculate the love % between userName and crushName
		
		
		String calculateLove = lcAppService.calculateLove(userInfoDto.getUserName(), userInfoDto.getCrushName());
		userInfoDto.setResult(calculateLove);
		
		return "result-page";
	}
}
