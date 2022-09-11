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
import springboot.repository.BanRepository;

@RestController
public class BanAPI {
	@Autowired
	BanRepository banrepo;

	@GetMapping("/ban")
	public List<BanEntity> getBan() {
		 List<BanEntity> list=banrepo.findAll();
		 for (BanEntity item:list)
		 {
			 item.setDatBan(null);
			 item.setHoaDon(null);
			 item.setLoaiBan(null);
		 }
		 System.out.print(list.size());
		return list;
	}

	@PostMapping(value="/ban")
	public UserDTO createBan(@RequestBody UserDTO model) {

		return model;

	}
	
	@PutMapping(value="/ban")
	public UserDTO updateBan(@RequestBody UserDTO model) {

		return model;

	}
	
	@DeleteMapping(value="/ban")
	public void deleteBan(@RequestBody Long[] ids) {

		

	}
}
