package springboot.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.DateDTO;
import springboot.dto.ThongKeDTO;
import springboot.repository.ChiPhiRepository;
import springboot.repository.HoaDonRepository;

@RestController
public class ThongKeAPI {
	@Autowired
	ChiPhiRepository cprepo;
	@Autowired
	HoaDonRepository hdrepo;

	@PostMapping(value = "/thongke")
	public ThongKeDTO thongKe(HttpServletRequest request,@RequestBody DateDTO model) {
		String flaglist = request.getParameter("flaglist");

		ThongKeDTO e = new ThongKeDTO();
		if (flaglist != null) {
			if (model.getNgay()==-1) {
				if (model.getThang() == -1)
				{
					e.setChiPhis(cprepo.getChiPhiNam(model.getNam()));
					e.setHoaDons(hdrepo.getHoaDonNam(model.getNam()));
				} else {
					e.setChiPhis(cprepo.getChiPhiThang(model.getNam(),model.getThang()));
					e.setHoaDons(hdrepo.getHoaDonThang(model.getNam(),model.getThang()));
				}
			} else {
				e.setChiPhis(cprepo.getChiPhiNgay(model.getNam(),model.getThang(),model.getNgay()));
				e.setHoaDons(hdrepo.getHoaDonNgay(model.getNam(),model.getThang(),model.getNgay()));
			}
		}

		return e;
	}
}
