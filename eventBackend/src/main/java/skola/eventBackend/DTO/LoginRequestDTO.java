package skola.eventBackend.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "Username is necessary")
    private String name;

    @NotBlank(message = "Password is necessary")
    private String password;

}
