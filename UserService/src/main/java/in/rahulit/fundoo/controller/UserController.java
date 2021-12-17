package in.rahulit.fundoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.rahulit.fundoo.dto.UserDTO;
import in.rahulit.fundoo.model.User;
import in.rahulit.fundoo.service.IUserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private IUserServices userServices;
	
	@PostMapping("/register")
	public User register(@RequestBody UserDTO userDTO) {
		return userServices.register(userDTO);
	}

}
