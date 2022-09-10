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
		 for (NhanVienEntity item:list)
		 {
			 item.setDatBan(null);
			 item.setChiPhi(null);
			 item.setHoadon(null);
			 item.setUserTB(null);
		 }
		 System.out.print(list.size());
		return list;

	}

	@PostMapping(value="/nhanvien")
	public UserDTO createNV(@RequestBody UserDTO model) {

		return model;

	}
	
	@PutMapping(value="/nhanvien")
	public UserDTO updateNV(@RequestBody UserDTO model) {

		return model;

	}
	
	@DeleteMapping(value="/nhanvien")
	public void deleteNV(@RequestBody Long[] ids) {

		

	}
}
