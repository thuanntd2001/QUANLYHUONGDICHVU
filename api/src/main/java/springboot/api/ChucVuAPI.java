package springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.UserDTO;
import springboot.entity.ChucVuEntity;
import springboot.entity.UserTBEntity;
import springboot.repository.ChucVuRepository;

@RestController
public class ChucVuAPI {
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
	public UserDTO createChucVu(@RequestBody UserDTO model) {

		return model;

	}
	
	@PutMapping(value="/chucvu")
	public UserDTO updateChucVu(@RequestBody UserDTO model) {

		return model;

	}
	
	@DeleteMapping(value="/chucvu")
	public void deleteChucVu(@RequestBody Long[] ids) {

		

	}
}
