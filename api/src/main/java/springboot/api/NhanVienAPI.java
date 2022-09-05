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
import springboot.entity.BanEntity;
import springboot.entity.NhanVienEntity;
import springboot.repository.BanRepository;
import springboot.repository.NhanVienRepository;

@RestController
public class NhanVienAPI {
	@Autowired
	NhanVienRepository repo;

	@GetMapping("/nhanvien")
	public List<NhanVienEntity> getNV() {
		 List<NhanVienEntity> list=repo.findAll();
		 System.out.print(list.size());
		return list;

	}

	@PostMapping(value="/nhanvien")
	public UserDTO createBan(@RequestBody UserDTO model) {

		return model;

	}
	
	@PutMapping(value="/nhanvien")
	public UserDTO updateBan(@RequestBody UserDTO model) {

		return model;

	}
	
	@DeleteMapping(value="/nhanvien")
	public void deleteNhanvien(@RequestBody Long[] ids) {

		

	}
}
