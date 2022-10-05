package springboot.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.ChiTietHDDTO;
import springboot.dto.HoaDonDTO;
import springboot.entity.ChiTietHDEntity;
import springboot.input.ObjDelLong;
import springboot.repository.ChiTietHDRepository;
import springboot.repository.NhanVienRepository;

@RestController
public class ChiTietHDAPI {
	@Autowired
	ChiTietHDRepository repo;
	@Autowired
	NhanVienRepository nvrepo;

	@GetMapping("/chitiethd")
	public List<ChiTietHDDTO> getUser( HttpServletRequest request) {
		String idhd = request.getParameter("idhd");
		long id;
		int i=0;
		List<ChiTietHDDTO> cts = new ArrayList<ChiTietHDDTO>();
		if (idhd == null)
			return null;
		else {
			try {
				id = Long.parseLong(idhd);
			} catch (Exception e) {
				return null;
			}
			List<ChiTietHDEntity> list = repo.findByHoaDonId(id);
			for (ChiTietHDEntity item : list) {
				ChiTietHDDTO e= new ChiTietHDDTO();
				e.setId(item.getId());
				e.setMaHD(item.getHoaDon().getId());
				e.setMaSP(item.getThucDon().getId());
				e.setSoLuong(item.getSoLuong());
				e.setTongTien(item.getTongTien());
				i+=1;
				cts.add(e);
			}
			System.out.print(list.size());
			return cts;

		}

	}

	@PostMapping(value = "/chitiethd")
	public String create(@RequestBody ChiTietHDDTO model) {

		ChiTietHDEntity save = new ChiTietHDEntity();
		ChiTietHDEntity check = null;
		try {

			check = repo.save(save);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(model.getId());

			return "01";
		}
		if (check == null) {

			return "02";
		}
		return "00";
	}

	@PutMapping(value = "/chitiethd")
	public String update(@RequestBody ChiTietHDDTO model) {

		Optional<ChiTietHDEntity> option = repo.findById(model.getId());
		if (option.isEmpty()) {

			System.out.print("ko tồn tại");
			return "404";
		}

		else {
			System.out.print("tồn tại");
			ChiTietHDEntity save = option.get();
			ChiTietHDEntity check = null;
			try {

				check = repo.save(save);
			} catch (Exception e) {
				e.printStackTrace();
				return "01";
			}

			if (check == null) {
				return "02";
			}
			return "00";
		}

	}

	@DeleteMapping(value = "/chitiethd")
	public String delete(@RequestBody ObjDelLong ids) {
		Optional<ChiTietHDEntity> option = repo.findById(ids.getId());
		if (option.isEmpty()) {

			System.out.print("ko tồn tại");
			return "404";
		} else {
			System.out.print("tồn tại");

			try {

				repo.deleteById(ids.getId());
			} catch (Exception e) {
				e.printStackTrace();
				return "02";
			}

			return "00";
		}
	}
}
