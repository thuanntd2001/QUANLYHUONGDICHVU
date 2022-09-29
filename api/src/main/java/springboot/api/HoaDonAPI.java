package springboot.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.HoaDonDTO;
import springboot.entity.HoaDonEntity;
import springboot.repository.HoaDonRepository;

@RestController
public class HoaDonAPI {
	@Autowired
	HoaDonRepository repo;

	@GetMapping("/hoadon")
	public List<HoaDonEntity> getHoaDon() {

		List<HoaDonEntity> list = repo.findAll();
		for (HoaDonEntity item : list) {
			item.setBan(null);
			item.setChiTietHD(null);
			item.setHdnv(null);
		}
		System.out.print(list.size());
		return list;

	}

	@PostMapping(value = "/hoadon")
	public String create(@RequestBody HoaDonDTO model) {

		return "00";

	}

	@PutMapping(value = "/hoadon")
	public String update(@RequestBody HoaDonDTO model) {

		return "00";

	}

	@DeleteMapping(value = "/hoadon")
	public String delete(@RequestBody Long ids) {
		Optional<HoaDonEntity> option = repo.findById(ids);
		if (option.isEmpty()) {

			System.out.print("ko tồn tại");
			return "404";
		} else {
			System.out.print("tồn tại");
			HoaDonEntity save = option.get();

			try {
				save.setTinhTrang(0);
				repo.save(save);
			} catch (Exception e) {
				e.printStackTrace();
				return "02";
			}

			return "00";
		}
	}

}
