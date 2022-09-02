package spring.controller.admin;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller

@RequestMapping(value = "/admin-home/")
public class QLBan {

	//show trang quan li ban
	@Autowired
	ServletContext application;

	@RequestMapping(value = "admin-qlban", method = RequestMethod.GET)
	public <E> String showQLB(HttpServletRequest request,ModelMap model){	
		


		//model.addAttribute("bans", list);
		return "admin/qlban";
	}
	
	
	
 

}