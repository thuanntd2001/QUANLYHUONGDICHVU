package spring.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bean.BanHoaDonModel;
import spring.bean.Collector;
import spring.dto.ChiPhiDTO;
import spring.dto.ChiTietHDDTO;
import spring.dto.NhanVienDTO;


@Controller

@RequestMapping(value = "/admin-home/")
public class QLNhapHang {

	// show trang quan li nhap hang


	@RequestMapping(value = "admin-nhaphang", method = RequestMethod.GET)
	public <E> String showQLNH(HttpServletRequest request, ModelMap model) {
		
		List<ChiPhiDTO> list=null;
		try {
			list = Collector.getListAll("/chiphi",ChiPhiDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("list", list);
		
		return "admin/qlnhaphang";
	}

	/* hiển thị form */
	@RequestMapping(value = "formNhapHang", method = RequestMethod.GET)
	public String index_formNhapHang(ModelMap model) {
		model.addAttribute("nh", new ChiPhiDTO());
		return "admin/form/inputNhapHang";
	}

	public List<String> checkInfo(ChiPhiDTO cp ) {

		List<String> listError = new ArrayList<>();
		
		return listError;
		

	}

	public Integer insert_NhapHang(ChiPhiDTO nv) {
		String flag = Collector.postMess("/chiphi", nv);
		System.out.println(flag);
		if (flag.equals("00")) {
			return 1;
		} else
			return 0;

	}
	
	/* thêm đơn nhập hàng */
	@RequestMapping(value = "formNhapHang", params = "Insert", method = RequestMethod.POST)
	public <E> String add_DonNhapHang(HttpServletRequest request, ModelMap model,
			@ModelAttribute("nh") ChiPhiDTO nh) {

		
		nh.setNvTao((long)1);;
		
		nh.setNgayNhap(new Date());
		
		List<String> listError = checkInfo(nh);
		Integer temp = this.insert_NhapHang(nh);

		if (temp != 0) {
			model.addAttribute("message", "Thêm thành công");

			nh.setTenChiPhi(null);
			nh.setGhiChu(null);
			nh.setGiaDonVi(0);
			nh.setLoai(null);
			nh.setNhaCungCap(null);
			nh.setSoLuong(0);

		} else {
			model.addAttribute("message", "Thêm thất bại! "+listError);
		}
		
		return "admin/qlnhaphang";
	}

	
}