package springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.ChucVuDTO;
import springboot.entity.ChucVuEntity;
import springboot.repository.ChucVuRepository;

@RestController
public class LoaiBanAPI {
	@Autowired
	ChucVuRepository repo;


	@GetMapping("/chucvu")
	public List<ChucVuEntity> getChucVu() {

		 List<ChucVuEntity> list= repo.findAll();
		 for (ChucVuEntity item:list)
		 {
			item.setUserTB(null);
		 }
		 System.out.print(list.size());
		return list;

	}

	@PostMapping(value="/chucvu")
	public String create(@RequestBody ChucVuDTO model) {

		return "00";

	}
	
	@PutMapping(value="/chucvu")
	public String update(@RequestBody ChucVuDTO model) {

		return "00";

	}
	
	@DeleteMapping(value="/chucvu")
	public void delete(@RequestBody Long[] ids) {

		

	}
}
