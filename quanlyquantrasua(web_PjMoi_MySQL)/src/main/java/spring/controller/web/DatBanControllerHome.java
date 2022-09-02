package spring.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



//@Transactional
@Controller
public class DatBanControllerHome {

//	@Autowired
//	SessionFactory factory;

	// CONTROLLER
	@RequestMapping(value = "trang-chu", method = RequestMethod.GET)
	public <E> String datban(HttpServletRequest request, ModelMap model) {


		// model.addAttribute("bans", list);
		return "web/datban";
	}

	@RequestMapping(value = "trang-chu", params = "btnsearch", method = RequestMethod.POST)
	public <E> String searchBan1(HttpServletRequest request, ModelMap model) {


		return "web/datban";
	}

	@RequestMapping(value = "dat-ban/{id}.htm", params = "linkView")
	public <E> String xemDatBan(HttpServletRequest request, ModelMap model, @PathVariable("id") Long id) {
		// page
		



		model.addAttribute("id", id);
		return "web/datban2";
	}

	@RequestMapping(value = "dat-ban/{id}.htm", params = "btnsearch", method=RequestMethod.POST)
	public <E> String searchDatBan(HttpServletRequest request, ModelMap model, @PathVariable("id") Long id) {

		model.addAttribute("id", id);
		return "web/datban2";
	}
	
	


	public boolean checknum(String str) {

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9')
				return false;
		}
		return true;
	}
}