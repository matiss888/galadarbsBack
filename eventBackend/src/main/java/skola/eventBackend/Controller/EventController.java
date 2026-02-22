package skola.eventBackend.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import skola.eventBackend.DTO.EventRequestDTO;
import skola.eventBackend.DTO.EventResponseDTO;
import skola.eventBackend.model.Event;
import skola.eventBackend.services.EventServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping
@CrossOrigin(value = "http://localhost:4200")
@AllArgsConstructor

public class EventController {

    private final EventServices eventServices;

    @PostMapping("/home")
    public ResponseEntity<EventResponseDTO> postEvent(@RequestBody @Valid EventRequestDTO event) {
        EventResponseDTO jaunsEvent = eventServices.postEvent(event);
        return new ResponseEntity<EventResponseDTO>(jaunsEvent, HttpStatus.OK);
    }

    @GetMapping("/home/visieventi")
    public ResponseEntity<List<EventResponseDTO>> dabutVisusEventus() {
        List<EventResponseDTO> allEvents = eventServices.dabutVisusEventus();
        return new ResponseEntity<>(allEvents, HttpStatus.OK);
    }

    @DeleteMapping("/home/event/{id}")
    public ResponseEntity<?> izdzestEventu(@PathVariable Long id) {
        eventServices.izdzestEventu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/home/{id}")
    public ResponseEntity<EventResponseDTO> pievienotUseri(@PathVariable Long eventId, @PathVariable Long userId) {
        // Event apdeitotsEvent = eventServices.pievienotUseri(eventId, userId);
        EventResponseDTO dtoToAddUser = eventServices.pievienotUseri(eventId, userId);
        return new ResponseEntity<>(dtoToAddUser, HttpStatus.OK);
    }

    @DeleteMapping("/home/event/{eventid}/{id}")
    public ResponseEntity<?> izdzestUseriNoEvent(@PathVariable Long eventid, @PathVariable Long id) {
        Event labotsEvents = eventServices.izdzestUseriNoEvent(eventid, id);
        return new ResponseEntity<Event>(labotsEvents, HttpStatus.OK);
    }

}
