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

import springboot.dto.LoaiThucUongDTO;
import springboot.entity.LoaiThucUongEntity;
import springboot.repository.LoaiThucUongRepository;

@RestController
public class LoaiThucUongAPI {
	@Autowired
	LoaiThucUongRepository repo;

	@GetMapping("/loaithucuong")
	public List<LoaiThucUongEntity> getLoaiThucUong() {

		List<LoaiThucUongEntity> list = repo.findAll();
		for (LoaiThucUongEntity item : list) {
			item.setThucDon(null);
		}
		System.out.print(list.size());
		return list;

	}

	@PostMapping(value = "/loaithucuong")
	public String create(@RequestBody LoaiThucUongDTO model) {

		LoaiThucUongEntity save = new LoaiThucUongEntity();
		LoaiThucUongEntity check = null;
		try {
			save.setDonVi(model.getDonVi());
			save.setTenLoai(model.getTenLoai());

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

	@PutMapping(value = "/loaithucuong")
	public String update(@RequestBody LoaiThucUongDTO model) {

		Optional<LoaiThucUongEntity> option = repo.findById(model.getid());
		if (option.isEmpty()) {

			System.out.print("ko tồn tại");
			return "404";
		}

		else {
			System.out.print("tồn tại");
			LoaiThucUongEntity save = option.get();
			LoaiThucUongEntity check = null;
			try {
				save.setDonVi(model.getDonVi());

				save.setTenLoai(model.getTenLoai());
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

	@DeleteMapping(value = "/loaithucuong")
	public void delete(@RequestBody Long[] ids) {

	}
}
