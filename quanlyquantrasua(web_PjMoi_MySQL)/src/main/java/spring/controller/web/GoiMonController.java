package spring.controller.web;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.quancafehighland.utils.HttpUtil;

import spring.config.restConfig.RestClient;
import spring.dto.ThucDonDTO;




@Controller
public class GoiMonController {
	RestClient rc= new RestClient();



	     
	@Autowired
	ServletContext application;
	@Autowired
	ServletContext session;
	

	@RequestMapping(value = "goi-mon", method = RequestMethod.GET)
	public String createList(ModelMap model) {


		return "web/pay";
	}//day la comment

	

}
