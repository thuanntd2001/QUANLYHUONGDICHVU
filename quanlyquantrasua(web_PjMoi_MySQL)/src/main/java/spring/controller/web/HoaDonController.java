package spring.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import spring.bean.Collector;
import spring.config.restConfig.RestClient;
import spring.dto.HoaDonDTO;



@Controller
public class HoaDonController {

	Collector<HoaDonDTO> colector=new Collector<HoaDonDTO>();
	@RequestMapping(value = "hoa-don" , method = RequestMethod.GET)
	public <E> String showMenu(ModelMap model,HttpServletRequest request) {

		List<HoaDonDTO> list =colector.getListAll("/hoadon");
		
		model.addAttribute("list", list);
		
        
		return "web/bill";
	}
	
	@RequestMapping(value = "hoa-don", params="btnsearch")
	public <E> String showMen2u(ModelMap model,HttpServletRequest request) {
		
		
		


	
		return "web/bill";
	}
	
	@RequestMapping(value = "hoa-don/{id}.htm", params = "linkView")
	public <E> String xemChiTietHD(HttpServletRequest request, ModelMap model,
			@PathVariable("id") Long id) {

		
		/*List<ChiTietHDEntity> chiTietHD = this.getChiTietHD(id);
		model.addAttribute("chiTietHD", chiTietHD);*/
		int tong=0;

		model.addAttribute("tongTien",tong);
		model.addAttribute("idhd",id);
		return "web/bill2";
	}

	
	



}