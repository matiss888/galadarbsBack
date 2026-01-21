package skola.eventBackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO {

    private Long id;

    private String nosaukums;

    private String apraksts;

    private String datums;

    private String laiks;

    private String vieta;

    private int maxDalibnieki;

    private int currentParticipants;

}
