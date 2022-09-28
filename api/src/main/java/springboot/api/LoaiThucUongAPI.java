package springboot.api;

import java.util.List;

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

		 List<LoaiThucUongEntity> list= repo.findAll();
		 for (LoaiThucUongEntity item:list)
		 {
			item.setThucDon(null);
		 }
		 System.out.print(list.size());
		return list;

	}

	@PostMapping(value="/loaithucuong")
	public String create(@RequestBody LoaiThucUongDTO model) {

		return "00";

	}
	
	@PutMapping(value="/loaithucuong")
	public String update(@RequestBody LoaiThucUongDTO model) {

		return "00";

	}
	
	@DeleteMapping(value="/loaithucuong")
	public void delete(@RequestBody Long[] ids) {

		

	}
}
