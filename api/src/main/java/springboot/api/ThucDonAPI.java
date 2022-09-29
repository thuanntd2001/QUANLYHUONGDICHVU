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

import springboot.dto.ThucDonDTO;
import springboot.entity.ThucDonEntity;
import springboot.repository.LoaiThucUongRepository;
import springboot.repository.ThucDonRepository;

@RestController
public class ThucDonAPI {
	@Autowired
	ThucDonRepository repo;
	@Autowired
	LoaiThucUongRepository lturepo;
	@GetMapping("/thucdon")
	public List<ThucDonEntity> getThucDon() {

		List<ThucDonEntity> list = repo.findAll();
		for (ThucDonEntity item : list) {
			item.setChiTietHD(null);
			item.setLoaiThucUong(null);
		}
		System.out.print(list.size());
		return list;

	}

	@PostMapping(value = "/thucdon")
	public String create(@RequestBody ThucDonDTO model) {

		ThucDonEntity save = new ThucDonEntity();
		ThucDonEntity check = null;
		try {
			save.setTen(model.getTen());
			save.setGia(model.getGia());
			save.setLoaiThucUong(lturepo.getOne(model.getLoai()));
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

	@PutMapping(value = "/thucdon")
	public String update(@RequestBody ThucDonDTO model) {

		Optional<ThucDonEntity> option = repo.findById(model.getid());
		if (option.isEmpty()) {

			System.out.print("ko tồn tại");
			return "404";
		}

		else {
			System.out.print("tồn tại");
			ThucDonEntity save = option.get();
			ThucDonEntity check = null;
			try {
				save.setTen(model.getTen());
				save.setGia(model.getGia());
				save.setLoaiThucUong(lturepo.getOne(model.getLoai()));
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

	@DeleteMapping(value = "/thucdon")
	public String delete(@RequestBody String ids) {

		Optional<ThucDonEntity> option = repo.findById(ids);
		if (option.isEmpty()) {

			System.out.print("ko tồn tại");
			return "404";
		} else {
			System.out.print("tồn tại");

			try {

				repo.deleteById(ids);
			} catch (Exception e) {
				e.printStackTrace();
				return "02";
			}

			return "00";
		}
	}
}
