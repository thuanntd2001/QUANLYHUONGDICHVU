package spring.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller

@RequestMapping(value = "/admin-home/")
public class QLThucDon {


	// CONTROLLER
	@RequestMapping(value = "admin-qlthucdon", method = RequestMethod.GET)
	public <E> String showThucDon(HttpServletRequest request,ModelMap model){	


		return "admin/qlthucdon";
	}
	
	/*hiển thị form*/
	@RequestMapping(value="formThucDon", method = RequestMethod.GET) 
    public String index_formThucDon(ModelMap model) {
	
		
          return "admin/form/inputThucDon";
    }
	

}