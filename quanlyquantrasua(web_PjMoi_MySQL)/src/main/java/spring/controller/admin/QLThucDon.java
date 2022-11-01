package spring.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bean.Collector;
import spring.dto.HoaDonDTO;
import spring.dto.ThucDonDTO;


@Controller

@RequestMapping(value = "/admin-home/")
public class QLThucDon {


	// CONTROLLER
	@RequestMapping(value = "admin-qlthucdon", method = RequestMethod.GET)
	public <E> String showThucDon(HttpServletRequest request,ModelMap model){	

		List<ThucDonDTO> list=null;
		try {
			list = Collector.getListAll("/thucdon",ThucDonDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("list", list);
		return "admin/qlthucdon";
	}
	
	/*hiển thị form*/
	@RequestMapping(value="formThucDon", method = RequestMethod.GET) 
    public String index_formThucDon(ModelMap model) {
	
		
          return "admin/form/inputThucDon";
    }
	

}