package spring.controller.admin;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping(value = "/admin-home/")
public class QLTaiKhoan {



	
	// CONTROLLER
	@RequestMapping(value = "admin-taikhoan", method = RequestMethod.GET)
	public <E> String index_TaiKhoan(HttpServletRequest request, ModelMap model) {

		return "admin/qltaikhoan";
	}

	

	
}