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

import lombok.AllArgsConstructor;
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
    public ResponseEntity<Event> postEvent(@RequestBody Event event) {
        Event jaunsEvent = eventServices.postEvent(event);
        return new ResponseEntity<Event>(jaunsEvent, HttpStatus.OK);
    }

    @GetMapping("/home/visieventi")
    public ResponseEntity<List<Event>> dabutVisusEventus() {
        List<Event> allEvents = eventServices.dabutVisusEventus();
        return new ResponseEntity<List<Event>>(allEvents, HttpStatus.OK);
    }

    @DeleteMapping("/home/event/{id}")
    public ResponseEntity<?> izdzestEventu(@PathVariable Long id) {
        eventServices.izdzestEventu(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/home/{id}")
    public ResponseEntity<Event> pievienotUseri(@PathVariable Long id, @RequestBody Event event) {
        Event apdeitotsEvent = eventServices.pievienotUseri(id, event);
        return new ResponseEntity<Event>(apdeitotsEvent, HttpStatus.OK);
    }

    @DeleteMapping("/home/event/{eventid}/{id}")
    public ResponseEntity<?> izdzestUseriNoEvent(@PathVariable Long eventid, @PathVariable Long id) {
        Event labotsEvents = eventServices.izdzestUseriNoEvent(eventid, id);
        return new ResponseEntity<Event>(labotsEvents, HttpStatus.OK);
    }

}
