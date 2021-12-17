package in.rahulit.fundoo.service;

import org.springframework.stereotype.Service;

import in.rahulit.fundoo.dto.UserDTO;
import in.rahulit.fundoo.model.User;

@Service
public interface IUserServices {
	
	public User register(UserDTO userDTO);

}
