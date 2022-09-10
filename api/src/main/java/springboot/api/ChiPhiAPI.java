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

import springboot.entity.ChiPhiEntity;
import springboot.repository.ChiPhiRepository;

@RestController
public class ChiPhiAPI {
	@Autowired
	ChiPhiRepository repo;


	@GetMapping("/chiphi")
	public List<ChiPhiEntity> getUser() {

		 List<ChiPhiEntity> list= repo.findAll();
		 for (ChiPhiEntity item:list)
		 {
			 item.setCpnv(null);
			
		 }
		 System.out.print(list.size());
		return list;

	}

	@PostMapping(value="/chiphi")
	public UserDTO createUser(@RequestBody UserDTO model) {

		return model;

	}
	
	@PutMapping(value="/chiphi")
	public UserDTO updateUser(@RequestBody UserDTO model) {

		return model;

	}
	
	@DeleteMapping(value="/chiphi")
	public void deleteUser(@RequestBody Long[] ids) {

		

	}
}
