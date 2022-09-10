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

import springboot.entity.UserTBEntity;
import springboot.repository.UserTBRepository;

@RestController
public class UserAPI {
	@Autowired
	UserTBRepository repo;


	@GetMapping("/user")
	public List<UserTBEntity> getUser() {

		 List<UserTBEntity> list= repo.findAll();
		 for (UserTBEntity item:list)
		 {
			 item.setUsernv(null);
			item.setChucVu(null);
			 
		 }
		 System.out.print(list.size());
		return list;

	}

	@PostMapping(value="/user")
	public UserDTO createUser(@RequestBody UserDTO model) {

		return model;

	}
	
	@PutMapping(value="/user")
	public UserDTO updateUser(@RequestBody UserDTO model) {

		return model;

	}
	
	@DeleteMapping(value="/user")
	public void deleteUser(@RequestBody Long[] ids) {

		

	}
}
