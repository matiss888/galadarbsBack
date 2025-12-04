package skola.eventBackend.Controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import skola.eventBackend.model.User;
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
    public ResponseEntity<?> parbauditUser(@RequestBody User user) {
        Optional<User> irUsers = userService.parbauditUser(user);
        if (irUsers.isPresent()) {
            System.out.println(irUsers.get());
            return ResponseEntity.ok(irUsers.get());
        } else {
            return ResponseEntity.status(401).body("Wrong username or pw");
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        User jaunsUser = userService.createUser(user);
        return new ResponseEntity<User>(jaunsUser, HttpStatus.OK);
    }

    // @PostMapping("/home/pievienotUser")
    // public UserDTO pievienotUseri(@RequestBody UserDTO user) {
    // return userService.saglabatUseriUzEvent(user);
    // }

    // public ResponseEntity<User> pievienotUseriEventam(@PathVariable Long id) {
    // User jaunsDalibnieks = userService.pievienotDalibnieku(id);
    // return new ResponseEntity<>(jaunsDalibnieks, HttpStatus.OK);
    // }

}
