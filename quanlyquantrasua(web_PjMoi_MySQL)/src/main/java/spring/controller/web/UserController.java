package spring.controller.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

	@Autowired
	ServletContext session;
	
	public String hashPass(String matKhau) {
		String hashpw = DigestUtils.md5Hex(matKhau);
		return hashpw;
	}
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request) {

		return "web/user";
	}


}