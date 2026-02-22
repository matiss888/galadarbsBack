package skola.eventBackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final BCryptPasswordEncoder passwordEncoder;

    public List<User> getVisiUseri() {
        return userRepository.findAll();
    }

    public UserResponseDTO createUser(UserRequestDTO userReq) {
        User user = new User();
        user.setName(userReq.getName());
        user.setPassword(passwordEncoder.encode(userReq.getPassword()));
        User savedInDb = userRepository.save(user);
        return new UserResponseDTO(savedInDb.getId(), savedInDb.getName());
    }

    public Optional<User> parbauditUser(LoginRequestDTO dto) {
        Optional<User> user = userRepository.findByName(dto.getName());
        if (user.isPresent() && passwordEncoder.matches(dto.getPassword(), user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }
}
