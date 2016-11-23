package com.quixada.sme.sape.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	//slf4j
	//private static Logger loger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value ={ "/","/home"})
	public String index(HttpServletRequest request){
		return "home";
	}
	
	@RequestMapping(value = "/login",  method = { RequestMethod.GET, RequestMethod.POST })
	public String login(HttpServletRequest request, Model model){
		return "login";
	}
	
	@RequestMapping(value ={ "/403"})
	public String acessoNegado(HttpServletRequest request){
		return "403";
	}

	@RequestMapping(value ={ "/sobre"})
	public String aboutSape(HttpServletRequest request){
		return "sobre";
	}

	// Error page
//	  @RequestMapping("/error.html")
//	  public String error(HttpServletRequest request, Model model) {
//	    model.addAttribute("errorCode", request.getAttribute("javax.servlet.error.status_code"));
//	    Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
//	    String errorMessage = null;
//	    if (throwable != null) {
//	      errorMessage = throwable.getMessage();
//	    }
//	    model.addAttribute("errorMessage", errorMessage);
//	    return "error.html";
//	  }

}
