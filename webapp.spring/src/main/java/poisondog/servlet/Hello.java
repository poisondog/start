package poisondog.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Hello {
//	@RequestMapping("hello")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam("user") String user, Model model) {
		model.addAttribute("user", user);
		return "hello_view";
	}
}
