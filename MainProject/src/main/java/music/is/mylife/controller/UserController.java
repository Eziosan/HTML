package music.is.mylife.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import music.is.mylife.vo.Song;

@RequestMapping("user")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(String name, String email, String password, Model model) {
		logger.debug("name : {}", name);
		logger.debug("email : {}", email);
		logger.debug("password : {}", password);
		
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		
		return "redirect:/";
	}
}
