package in.rahulit.fundoo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import in.rahulit.fundoo.dto.UserDTO;
import in.rahulit.fundoo.exception.RegistrationException;
import in.rahulit.fundoo.model.User;
import in.rahulit.fundoo.repository.IUserRepository;
import in.rahulit.fundoo.response.Response;
import in.rahulit.fundoo.utility.StatusHelper;

@Service
public class UserServicesImplementation implements IUserServices {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IUserRepository userRepository;

	@Override
	public Response register(UserDTO userDTO) {
		Response response = null;

		Optional<User> avaiability = userRepository.findByEmail(userDTO.getEmail());
		if (avaiability.isPresent()) {
			throw new RegistrationException("User exist", 1);
		}

		User user = modelMapper.map(userDTO, User.class);
		System.out.println(user);
		user.setRegisteredDate(LocalDate.now());
		User saveResponse = userRepository.save(user);
		
		if (saveResponse == null) {
			throw new RegistrationException("Data is not saved in database", -2);
		}
		response = StatusHelper.statusInfo("status.register.success", 200);
		return response;
	}

}
