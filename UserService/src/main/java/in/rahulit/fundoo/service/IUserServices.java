package in.rahulit.fundoo.service;

import org.springframework.stereotype.Service;

import in.rahulit.fundoo.dto.UserDTO;
import in.rahulit.fundoo.model.User;
import in.rahulit.fundoo.response.Response;

@Service
public interface IUserServices {
	
	public Response register(UserDTO userDTO);

}
