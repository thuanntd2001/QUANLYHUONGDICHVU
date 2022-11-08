package spring.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bean.BanHoaDonModel;
import spring.bean.Collector;
import spring.dto.BanDTO;
import spring.dto.ChiPhiDTO;
import spring.dto.ChiTietHDDTO;
import spring.dto.LoaiBanDTO;
import spring.dto.NhanVienDTO;




@Controller

@RequestMapping(value = "/admin-home/")
public class QLBan {

	//show trang quan li ban
	@Autowired
	ServletContext application;

	@RequestMapping(value = "admin-qlban", method = RequestMethod.GET)
	public <E> String showQLB(HttpServletRequest request,ModelMap model){	
		
		List<BanDTO> list=null;
		try {
			list = Collector.getListAll("/ban",BanDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("list", list);
		

		//model.addAttribute("bans", list);
		return "admin/qlban";
	}
	
	@RequestMapping(value="formBan", method = RequestMethod.GET) 
    public String formBan(ModelMap model, HttpServletRequest request,@ModelAttribute("b") BanDTO b) {
		model.addAttribute("loaibans",getLoaiBans());	
          return "admin/form/inputBan1";
    }
	
	public List<LoaiBanDTO> getLoaiBans(){
		List<LoaiBanDTO> list=null;
		try {
			list = Collector.getListAll("/loaiban",LoaiBanDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<String> checkInfo(BanDTO b ) {

		List<String> listError = new ArrayList<>();

		if (b.getSoGhe()==null) {
			listError.add("chưa nhập số ghế");
		}
		
		
		return listError;
		

	}
	
	public Integer InsertBan (BanDTO b) {
		String flag = Collector.postMess("/ban", b);
		System.out.println(flag);
		if (flag.equals("00")) {
			return 1;
		} else
			return 0;
	}
	
	//thêm bàn xổ combobox
	@RequestMapping(value = "formBan",params = "Insert", method = RequestMethod.POST )
	public <E> String add_BAN(HttpServletRequest request, ModelMap model /*,@ModelAttribute("lb") LoaiBanEntity lb*/ ) {
		BanDTO ban = new BanDTO();
		String id = request.getParameter("loaiBan"); 
		int id1=1;//mặc định là bàn thường
		id1 = Integer.parseInt(id);
		
		String a = request.getParameter("soGhe");
		
		int soghe = Integer.parseInt(a);
		
		ban.setSoGhe(soghe);
		ban.setTinhTrang(0);
		ban.setLoaiBan((long)id1);
		List<String> listError = checkInfo(ban);
		Integer temp1 = this.InsertBan(ban);
		if(temp1 != 0) {
		    model.addAttribute("message","Thêm thành công");
			
		}else {
			model.addAttribute("message","Thêm thất bại! "+listError);
		}
		
		return "admin/qlban";
	}
 

}