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

    public Event pievienotUseri(Long id, Event istaisEvent) {
        Event meklejuEventu = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nav events ar šo id"));
        meklejuEventu.setPasreizejaisDalibniekuSkaits(istaisEvent.getPasreizejaisDalibniekuSkaits());
        System.out.println(meklejuEventu);
        System.out.println(istaisEvent);
        return eventRepository.save(meklejuEventu);
    }

    public Event izdzestUseriNoEvent(Long eventid, Long userid) {
        Event labotsEvent = eventRepository.findById(eventid)
                .orElseThrow(() -> new RuntimeException("Nav events ar šo id"));
        System.out.println(labotsEvent);
        labotsEvent.getPasreizejaisDalibniekuSkaits().remove(userid);
        System.out.println(labotsEvent);
        return eventRepository.save(labotsEvent);
    }
}
