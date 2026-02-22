package skola.eventBackend.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import skola.eventBackend.DTO.EventRequestDTO;
import skola.eventBackend.DTO.EventResponseDTO;
import skola.eventBackend.mapper.EventMapper;
import skola.eventBackend.model.Event;
import skola.eventBackend.repository.EventRepository;

@Service
@AllArgsConstructor

public class EventServices {

    @Autowired
    private final EventRepository eventRepository;
    @Autowired
    private final EventMapper eventMapper;

    public EventResponseDTO postEvent(EventRequestDTO eventReq) {
        Event eventDTOtoEnt = Objects.requireNonNull(eventMapper.DTOtoEntity(eventReq));
        Event saveThisEvent = eventRepository.save(eventDTOtoEnt);
        return eventMapper.eventResponse(saveThisEvent);
    }

    public List<EventResponseDTO> dabutVisusEventus() {
        return eventRepository.findAll()
                .stream()
                .map(eventMapper::eventResponse)
                .toList();
    }

    public void izdzestEventu(Long id) {
        eventRepository.deleteById(Objects.requireNonNull(id, "ID can't be null"));
    }

    public EventResponseDTO pievienotUseri(Long eventId, Long userId) {
        Event meklejuEventu = eventRepository.findById(Objects.requireNonNull(eventId, "Event ID can't be null"))
                .orElseThrow(() -> new RuntimeException("There is no event with this id"));
        if (!meklejuEventu.getPasreizejaisDalibniekuSkaits().contains(userId)) {
            meklejuEventu.getPasreizejaisDalibniekuSkaits().add(userId);
        }
        Event savedEvent = eventRepository.save(meklejuEventu);
        // meklejuEventu.setPasreizejaisDalibniekuSkaits(istaisEvent.getCurrentParticipants());
        return eventMapper.eventResponse(savedEvent);
    }

    public Event izdzestUseriNoEvent(Long eventid, Long userid) {
        Event labotsEvent = eventRepository.findById(Objects.requireNonNull(eventid))
                .orElseThrow(() -> new RuntimeException("Nav events ar šo id"));
        System.out.println(labotsEvent);
        labotsEvent.getPasreizejaisDalibniekuSkaits().remove(userid);
        System.out.println(labotsEvent);
        return eventRepository.save(labotsEvent);
    }
}
