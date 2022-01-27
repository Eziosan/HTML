package music.is.mylife.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "mainPage";
	}
	@RequestMapping(value = "popUp", method = RequestMethod.POST, produces = "application/json")
	public String popUp() {
		System.out.println("컨트롤러 무사히 실행");
		
		return "jsp 무사히 귀환";
	}
	@RequestMapping(value = "newPage", method = RequestMethod.GET)
	public String newPage() {
		
		return "newPage";
	}
	
}
