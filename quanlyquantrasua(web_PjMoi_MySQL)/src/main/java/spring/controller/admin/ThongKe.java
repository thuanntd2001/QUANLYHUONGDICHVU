package spring.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping(value = "/admin-home/")
public class ThongKe {

	
	
	
	@RequestMapping(value = "thong-ke" , method = RequestMethod.GET)
	public <E> String thongKe(ModelMap model,HttpServletRequest request) {
		

		return "admin/thongke";
	}
	

}