package skola.eventBackend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import skola.eventBackend.model.Event;
import skola.eventBackend.repository.EventRepository;

@Service
@AllArgsConstructor

public class EventServices {

    private final EventRepository eventRepository;

    public Event postEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> dabutVisusEventus() {
        return eventRepository.findAll();
    }

    public void izdzestEventu(Long id) {
        eventRepository.deleteById(id);
    }

}
