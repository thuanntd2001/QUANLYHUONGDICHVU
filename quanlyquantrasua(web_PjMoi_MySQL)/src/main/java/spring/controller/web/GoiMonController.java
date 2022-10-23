package spring.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.bean.BanHoaDonModel;
import spring.bean.Collector;
import spring.dto.BanDTO;
import spring.dto.LoaiThucUongDTO;
import spring.dto.ThucDonDTO;

@Controller
public class GoiMonController {

	@Autowired
	ServletContext application;
	@Autowired
	ServletContext session;

	@RequestMapping(value = "goi-mon", method = RequestMethod.GET)
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
		List<BanDTO> listBan = (List<BanDTO>) application.getAttribute("listBan");
		List<LoaiThucUongDTO> loaiTUs = (List<LoaiThucUongDTO>) application.getAttribute("loaiTUs");
		List<ThucDonDTO> thucDons = (List<ThucDonDTO>) application.getAttribute("thucDons");

		model.addAttribute("bans", listBan);
		model.addAttribute("loaiTUs", loaiTUs);
		model.addAttribute("thucDons", thucDons);

		return "web/pay";
	}

}
