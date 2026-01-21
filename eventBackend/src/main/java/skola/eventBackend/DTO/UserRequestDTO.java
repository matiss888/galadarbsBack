package skola.eventBackend.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank(message = "Username can't be empty")
    @Size(min = 3, max = 20, message = "Username must be atleast 3 letters long and max letters are 20.")
    private String name;

    @NotBlank(message = "Password can't be empty")
    @Size(min = 8, max = 100, message = "Password must be atleast 8 symbols long and max symbols are 100.")
    private String password;
}
