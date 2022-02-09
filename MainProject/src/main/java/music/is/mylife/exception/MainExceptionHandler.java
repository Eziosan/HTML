package music.is.mylife.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MainExceptionHandler {
	
//	//모든 예외 처리
	@ExceptionHandler(Exception.class)
	//404 에러 처리
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String errorHandler_404(Model model) {
		
		model.addAttribute("errorMsg", "404 error");
		
		return "/error";
	}
//	
//	//런타임 에러 처리
//	@ExceptionHandler(RuntimeException.class)
//	//500 에러 처리
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	public String errorHandler_500(Model model) {
//		model.addAttribute("errorMsg", "500 error");
//		return "/error";
//	}
	
}
