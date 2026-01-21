package skola.eventBackend.Controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import skola.eventBackend.DTO.LoginRequestDTO;
import skola.eventBackend.DTO.UserRequestDTO;
import skola.eventBackend.model.User;
import skola.eventBackend.DTO.UserResponseDTO;
import skola.eventBackend.services.UserService;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> parbauditUser(
            @Valid @RequestBody LoginRequestDTO dto) {
        Optional<User> irUsers = userService.parbauditUser(dto);
        if (irUsers.isPresent()) {
            User user = irUsers.get();
            skola.eventBackend.DTO.UserResponseDTO response = new UserResponseDTO(user.getId(), user.getName());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Incorrect username or passwords");
        }
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponseDTO> postUser(@RequestBody @Valid UserRequestDTO userReq) {
        return new ResponseEntity<UserResponseDTO>(userService.createUser(userReq), HttpStatus.OK);
    }
}
