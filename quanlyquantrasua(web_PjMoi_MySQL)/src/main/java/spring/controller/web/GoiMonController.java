package spring.controller.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import spring.dto.ThucDonDTO;




@Controller
public class GoiMonController {

	@Autowired
	WebClient webClient;
	     
	@Autowired
	ServletContext application;
	@Autowired
	ServletContext session;
	
//	Mono<ThucDonDTO> customer = webClient.get()
//		     .uri("/thucdon")
//		     .retrieve()
//		     .bodyToMono(ThucDonDTO.class);

	@RequestMapping(value = "goi-mon", method = RequestMethod.GET)
	public String createList(ModelMap model) {
		

		return "web/pay";
	}//day la comment

	

}
