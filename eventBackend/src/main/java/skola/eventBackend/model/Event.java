package skola.eventBackend.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nosaukums;
    String apraksts;
    String datums;
    String laiks;
    String vieta;
    @ElementCollection
    List<Long> pasreizejaisDalibniekuSkaits;
    int maxDalibnieki;
    Long createdBy;
}
