package skola.eventBackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import skola.eventBackend.DTO.LoginRequestDTO;
import skola.eventBackend.DTO.UserRequestDTO;
import skola.eventBackend.DTO.UserResponseDTO;
import skola.eventBackend.model.User;
import skola.eventBackend.repository.UserRepository;

@Service
@AllArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public List<User> getVisiUseri() {
        return userRepository.findAll();
    }

    public UserResponseDTO createUser(UserRequestDTO userReq) {
        User user = new User();
        user.setName(userReq.getName());
        user.setPassword(userReq.getPassword());
        User savedInDb = userRepository.save(user);
        return new UserResponseDTO(savedInDb.getId(), savedInDb.getName());
    }

    public Optional<User> parbauditUser(LoginRequestDTO dto) {
        return userRepository.findByNameAndPassword(dto.getName(), dto.getPassword());
    }
}
