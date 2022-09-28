package springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.ThucDonDTO;
import springboot.entity.ThucDonEntity;
import springboot.repository.ThucDonRepository;

@RestController
public class ThucDonAPI {
	@Autowired
	ThucDonRepository repo;


	@GetMapping("/thucdon")
	public List<ThucDonEntity> getThucDon() {

		 List<ThucDonEntity> list= repo.findAll();
		 for (ThucDonEntity item:list)
		 {
			item.setChiTietHD(null);
			item.setLoaiThucUong(null);
		 }
		 System.out.print(list.size());
		return list;

	}

	@PostMapping(value="/thucdon")
	public String create(@RequestBody ThucDonDTO model) {

		return "00";

	}
	
	@PutMapping(value="/thucdon")
	public String update(@RequestBody ThucDonDTO model) {

		return "00";

	}
	
	@DeleteMapping(value="/thucdon")
	public void delete(@RequestBody Long[] ids) {

		

	}
}
