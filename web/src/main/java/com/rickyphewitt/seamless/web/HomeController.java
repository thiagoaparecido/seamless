package com.rickyphewitt.seamless.web;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rickyphewitt.seamless.services.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	@RequestMapping("/home")
	String music(Model model, HttpServletResponse response) throws InterruptedException, ExecutionException {
		return homeService.home(model, response);
	}
}
