package spring.controller.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ThanhToanController {

	@Autowired
	ServletContext application;
	@Autowired
	ServletContext session;

	@RequestMapping(value = "thanh-toan", method = RequestMethod.GET)
	public String createList(ModelMap model) {


		return "web/thanhtoan";
	}

	@RequestMapping(value = "thanh-toan", method = RequestMethod.POST, params="xem")
	public String view(ModelMap model, HttpServletRequest request) {

		return "web/thanhtoan";

	}
	@RequestMapping(value = "thanh-toan", method = RequestMethod.POST, params="thanhtoan")
	public String pay(ModelMap model, HttpServletRequest request) {

		
		return "web/thanhtoan";

	}
	
	
	@RequestMapping(value = "thanh-toan", method = RequestMethod.POST, params="print")
	public String print(ModelMap model, HttpServletRequest request) {

		return "web/inhoadon";

	}
	
	
	
	@RequestMapping(value = "thanh-toan", method = RequestMethod.POST, params="xoa")
	public String xoa(ModelMap model, HttpServletRequest request) {

		return "redirect:thanh-toan.htm";
		
	}




}
