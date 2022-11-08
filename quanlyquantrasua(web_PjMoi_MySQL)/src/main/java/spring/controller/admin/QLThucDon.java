package spring.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bean.Collector;
import spring.dto.HoaDonDTO;
import spring.dto.LoaiThucUongDTO;
import spring.dto.ThucDonDTO;

@Controller

@RequestMapping(value = "/admin-home/")
public class QLThucDon {

	// CONTROLLER
	@RequestMapping(value = "admin-qlthucdon", method = RequestMethod.GET)
	public <E> String showThucDon(HttpServletRequest request, ModelMap model) {

		List<ThucDonDTO> list = null;
		try {
			list = Collector.getListAll("/thucdon", ThucDonDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("list", list);
		return "admin/qlthucdon";
	}

	/* hiển thị form */
	@RequestMapping(value = "formThucDon", method = RequestMethod.GET)
	public String index_formThucDon(ModelMap model) {
		model.addAttribute("td", new ThucDonDTO());

		model.addAttribute("loaithucuongs", getLoaiThucUongs());

		return "admin/form/inputThucDon";
	}

	public List<LoaiThucUongDTO> getLoaiThucUongs() {
		List<LoaiThucUongDTO> list = null;
		try {
			list = Collector.getListAll("/loaithucuong", LoaiThucUongDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<ThucDonDTO> getThucDons() {
		List<ThucDonDTO> list = null;
		try {
			list = Collector.getListAll("/thucdon", ThucDonDTO.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<String> checkInfo(ThucDonDTO td) {
		List<String> listError = new ArrayList<>();

		if (td.getGia() == 0) {
			listError.add("chưa nhập giá thành");
		}
		if (td.getid().trim().equals("")) {
			listError.add("chưa nhập ID");
		}

		return listError;

	}

	public Integer insertThucDon(ThucDonDTO td) {
		String flag = Collector.postMess("/thucdon", td);
		System.out.println(flag);
		if (flag.equals("00")) {
			return 1;
		} else
			return 0;
	}

	public boolean CheckIDThucDon(String IDthucDon) {
		List<ThucDonDTO> list = getThucDons();
		int n = list.size();
		String user;
		for (int i = 0; i < n; i++) {
			user = list.get(i).getid();
			if (user.equals(IDthucDon)) {
				return true;
			}
		}
		return false;
	}

//thêm 
	@RequestMapping(value = "formThucDon", params = "Insert", method = RequestMethod.POST)
	public <E> String addThucDon(HttpServletRequest request, ModelMap model, @ModelAttribute("td") ThucDonDTO td) {
		String error = "";
		Integer temp = 0;
		if (CheckIDThucDon(td.getid())) {
			error = "ID thực đơn đã tồn tại!!!";
		} else {
			String idLoaiTU = request.getParameter("loaithucuong");
			String tmp = request.getParameter("gia");
			Integer giaTD = Integer.parseInt(tmp);
			String tenTD = request.getParameter("ten");

			td.setLoaiThucUong(idLoaiTU);
			td.setGia(giaTD);
			td.setTen(tenTD);
			temp = this.insertThucDon(td);
		}
		if (temp != 0) {
			model.addAttribute("message", "Thêm thành công");

		} else {
			model.addAttribute("message", "Thêm thất bại " + error);
		}

		return "admin/qlthucdon";
	}

}