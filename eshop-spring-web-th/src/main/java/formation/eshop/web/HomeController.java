package formation.eshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(path = "/accueil", method = RequestMethod.GET)
	public String accueil(Model model, @RequestParam("prenom") String prenom,
			@RequestParam(required = false, defaultValue = "0") int age) {

		model.addAttribute("prenom", prenom);
		model.addAttribute("age", age);

		return "accueil";

	}

}
