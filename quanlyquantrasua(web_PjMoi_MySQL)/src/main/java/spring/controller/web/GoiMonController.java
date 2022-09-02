package spring.controller.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class GoiMonController {

	@Autowired
	ServletContext application;
	@Autowired
	ServletContext session;

	@RequestMapping(value = "goi-mon", method = RequestMethod.GET)
	public String createList(ModelMap model) {
		

		return "web/pay";
	}//day la comment

	

}
