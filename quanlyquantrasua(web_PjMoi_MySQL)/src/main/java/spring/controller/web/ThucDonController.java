package spring.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class ThucDonController {


	@RequestMapping(value = "thuc-don", method = RequestMethod.GET)
	public <E> String showMenu(ModelMap model, HttpServletRequest request) {
		
	
		return "web/menu";
	}

	@RequestMapping(value = "thuc-don", params="btnsearch")
	public <E> String showMenu2(ModelMap model, HttpServletRequest request) {
		
	
		return "web/menu";
	}
	

	
}