package in.rahulit.fundoo.service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import in.rahulit.fundoo.dto.UserDTO;
import in.rahulit.fundoo.model.User;
import in.rahulit.fundoo.repository.IUserRepository;

@Service
public class UserServicesImplementation implements IUserServices {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IUserRepository userRepository;

	@Override
	public User register(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		System.out.println(user);
		user.setRegisteredDate(LocalDate.now());
		User save = userRepository.save(user);
		return save;
	}

}
