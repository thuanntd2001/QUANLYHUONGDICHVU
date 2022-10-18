package spring.controller.admin;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bean.Password;

@Controller

@RequestMapping(value = "/admin-home/")
public class AdminUser {


	@Autowired
	ServletContext session;
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request) {
		

		model.addAttribute("changePW", new Password());
		return "admin/user";
	}



	

	
}
