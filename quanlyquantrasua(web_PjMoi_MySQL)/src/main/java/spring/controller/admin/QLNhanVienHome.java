package spring.controller.admin;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping(value = "/admin-home/" )
public class QLNhanVienHome {
	

	// CONTROLLER
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public <E> String index(HttpServletRequest request,ModelMap model){	

		return "admin/QLNV";
	}
	
	/*hiển thị form*/
	@RequestMapping(value="form", method = RequestMethod.GET) 
    public String index_form(ModelMap model) {

          return "admin/form/inputNV";
    }
	
	
	
	
	 @InitBinder
	    public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        sdf.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    }
}
