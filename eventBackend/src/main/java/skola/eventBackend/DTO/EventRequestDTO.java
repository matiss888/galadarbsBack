package skola.eventBackend.DTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EventRequestDTO {

    @NotBlank(message = "Event has to have a name")
    @Size(min = 3, max = 50)
    String nosaukums;

    String apraksts;

    @NotNull(message = "Date is necessary")
    @FutureOrPresent(message = "Event can't be hosted in past")
    String datums;

    @NotNull(message = "Time of the event is necessary")
    String laiks;

    @NotBlank(message = "Location must be pointed")
    String vieta;

    @Min(value = 1, message = "Event has to have atleast one participant")
    int maxDalibnieki;

}
