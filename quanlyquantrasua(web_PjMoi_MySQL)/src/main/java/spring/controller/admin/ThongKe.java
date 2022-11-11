package spring.controller.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bean.Collector;
import spring.dto.DateDTO;
import spring.dto.HoaDonDTO;
import spring.dto.ThongKeDTO;




@Controller
@RequestMapping(value = "/admin-home/")
public class ThongKe {

	
	
	
	@RequestMapping(value = "thong-ke" , method = RequestMethod.GET)
	public <E> String thongKe(ModelMap model,HttpServletRequest request) {
		
		DateDTO date= new DateDTO();
		Calendar calendar = Calendar.getInstance();
		date.setNgay(calendar.get(Calendar.DAY_OF_MONTH));
		date.setThang(calendar.get(Calendar.MONTH)+1);
		date.setNam(calendar.get(Calendar.YEAR));
		
		ThongKeDTO thongKe= Collector.postObj("/thongke", date, ThongKeDTO.class);
		ThongKeDTO thongKeList= Collector.postObj("/thongke?flaglist=true", date, ThongKeDTO.class);
		
		List<Integer> s = new ArrayList<Integer>();
		List<HoaDonDTO> b = thongKeList.getHoaDons();
		for(HoaDonDTO hd:b){
			s.add(hd.getTongTien());
		}
		model.addAttribute("timeradio", "day");
		model.addAttribute("day", date.getNgay());
		model.addAttribute("month", date.getThang());
		model.addAttribute("year", date.getNam());
		model.addAttribute("soHoaDon", thongKe.getSoHoaDon());
		model.addAttribute("doanhThu", thongKe.getDoanhThu());
		model.addAttribute("chiPhi", thongKe.getChiPhi());
		model.addAttribute("loiNhuan",thongKe.getLoiNhuan());
		

		model.addAttribute("hoaDon", b);
		model.addAttribute("bangChiPhi", thongKeList.getChiPhis());	
		model.addAttribute("tongHD", s);
		return "admin/thongke";
	}
	

}