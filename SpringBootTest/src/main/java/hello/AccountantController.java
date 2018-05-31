package hello;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Scope("request")
public class AccountantController {

	@Autowired
	private ExpensesService expService;
	
	@RequestMapping("/accountant")
	public String listExpensesAsJSON(Model model, HttpServletRequest request ){
		
		List<Month> months = expService.getExpensesJSON();
		model.addAttribute("months", months);
		return "accountent";
	}
}
