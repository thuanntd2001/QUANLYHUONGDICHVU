package spring.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quancafehighland.utils.SessionUtil;

import spring.bean.BanHoaDonModel;
import spring.bean.Collector;
import spring.dto.BanDTO;
import spring.dto.ChiTietHDDTO;
import spring.dto.HoaDonDTO;
import spring.dto.LoaiThucUongDTO;
import spring.dto.LoginDTO;
import spring.dto.ThucDonDTO;

@Controller
public class ThanhToanController {

	@Autowired
	ServletContext application;
	@Autowired
	ServletContext session;

	@RequestMapping(value = "thanh-toan", method = RequestMethod.GET)
	public String createList(ModelMap model) throws IOException {
		// kt co list ban tong he thong ko co thi tao list nay2 set ra view

		if (application.getAttribute("listBan") == null) {

			List<BanDTO> listBan = Collector.getListAll("/ban", BanDTO.class);
			application.setAttribute("loaiTUs", Collector.getListAll("/loaithucuong", LoaiThucUongDTO.class));

			application.setAttribute("thucDons", Collector.getListAll("/thucdon", ThucDonDTO.class));

			application.setAttribute("listBan", listBan);
			List<BanHoaDonModel> listBHD = new ArrayList<BanHoaDonModel>();
			List<Long> listIdsBan = new ArrayList<Long>();

			@SuppressWarnings("unchecked")
			List<BanDTO> list = (List<BanDTO>) application.getAttribute("listBan");

			for (BanDTO ban : list) {
				listBHD.add(new BanHoaDonModel(ban.getId()));
				listIdsBan.add(ban.getId());
				/*
				 * System.out.println("ban so" + (ban.getId()));
				 */ }
			application.setAttribute("banHoaDons", listBHD);
			application.setAttribute("banids", listIdsBan);

		}
		@SuppressWarnings("unchecked")
		List<BanDTO> listBan = (List<BanDTO>) application.getAttribute("listBan");
		@SuppressWarnings("unchecked")
		List<LoaiThucUongDTO> loaiTUs = (List<LoaiThucUongDTO>) application.getAttribute("loaiTUs");
		@SuppressWarnings("unchecked")
		List<ThucDonDTO> thucDons = (List<ThucDonDTO>) application.getAttribute("thucDons");

		model.addAttribute("bans", listBan);
		model.addAttribute("loaiTUs", loaiTUs);
		model.addAttribute("thucDons", thucDons);

		return "web/thanhtoan";
	}

	@RequestMapping(value = "thanh-toan", method = RequestMethod.POST, params = "xem")
	public String view(ModelMap model, HttpServletRequest request) {

		@SuppressWarnings("unchecked")
		List<BanDTO> listBan = (List<BanDTO>) application.getAttribute("listBan");
		@SuppressWarnings("unchecked")
		List<ThucDonDTO> thucDons = (List<ThucDonDTO>) application.getAttribute("thucDons");

		@SuppressWarnings("unchecked")
		List<BanHoaDonModel> listBHD = (List<BanHoaDonModel>) application.getAttribute("banHoaDons");

		// lay data tu form
		long ban = Long.parseLong(request.getParameter("Ban"));

		session.setAttribute("idBanHT", ban);
		// set view
		model.addAttribute("bans", listBan);
		if (Long.valueOf(ban) != null) {
			BanHoaDonModel BHD = listBHD.get((int) BanHoaDonModel.findBanHD(ban, listBHD));
			for (ChiTietHDDTO item : BHD.getCthds()) {
				if (item.getThucDon() == null) {
					item.setThucDon(BanHoaDonModel.findTDDTO(item.getMaSP(), thucDons));
				}
			}
			model.addAttribute("banHD", BHD);
			model.addAttribute("tongtien", BanHoaDonModel.tinhTong(BHD.getCthds()));
		}
		return "web/thanhtoan";

	}

	@RequestMapping(value = "thanh-toan", method = RequestMethod.POST, params = "thanhtoan")
	public String pay(ModelMap model, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<BanDTO> listBan = (List<BanDTO>) application.getAttribute("listBan");


		@SuppressWarnings("unchecked")
		List<BanHoaDonModel> listBHD = (List<BanHoaDonModel>) application.getAttribute("banHoaDons");

		// lay data tu form
		long ban = Long.parseLong(request.getParameter("Ban"));

		// set view
		model.addAttribute("bans", listBan);

		// tim ban có id hien tai trong ds banhd hien tai
		BanHoaDonModel banHD = listBHD.get((int) BanHoaDonModel.findBanHD(ban, listBHD));
		HoaDonDTO HD = banHD.getHoaDon();
		if (HD != null) {
			HD.setCthds(banHD.getCthds());
			HD.setBan(ban);
			HD.setNgayThucHien(new java.util.Date());
			LoginDTO nv = (LoginDTO) SessionUtil.getInstance().getValue(request, "USERMODEL");

			HD.setNvThucHien(nv.getMaNV());

			String flag = Collector.postMess("/hoadon", HD);

			if (flag == "0") {
				banHD.setHoaDon(null);
				banHD.setCthds(new ArrayList<ChiTietHDDTO>());
				listBan.get((int) BanHoaDonModel.findBan(ban, listBan)).setTinhTrang(0);
				model.addAttribute("message", "Thanh toán thành công");
			} else
				model.addAttribute("message", "Thanh toán thất bại");

		}

		return "web/thanhtoan";

	}

	@RequestMapping(value = "thanh-toan", method = RequestMethod.POST, params = "print")
	public String print(ModelMap model, HttpServletRequest request) {

		return "web/inhoadon";

	}

	@RequestMapping(value = "thanh-toan", method = RequestMethod.POST, params = "xoa")
	public String xoa(ModelMap model, HttpServletRequest request) {

		return "redirect:thanh-toan.htm";

	}

}
