package skola.eventBackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import skola.eventBackend.model.User;
import skola.eventBackend.repository.UserRepository;

@Service
@AllArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    public List<User> getVisiUseri() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> parbauditUser(User user) {
        return userRepository.findByNameAndPassword(user.getName(), user.getPassword());
    }

}
