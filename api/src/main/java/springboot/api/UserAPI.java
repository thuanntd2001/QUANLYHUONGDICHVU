package springboot.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.dto.UserDTO;

@RestController
public class UserAPI {

	@GetMapping("/user")
	public String testAPI() {

		return "success";

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
