package skola.eventBackend.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import jakarta.annotation.Nonnull;
import skola.eventBackend.DTO.EventRequestDTO;
import skola.eventBackend.DTO.EventResponseDTO;
import skola.eventBackend.model.Event;

@Component
public class EventMapper {

    @Nonnull
    public EventResponseDTO eventResponse(@Nonnull Event event) {
        return new EventResponseDTO(
                event.getId(),
                event.getNosaukums(),
                event.getApraksts(),
                event.getDatums(),
                event.getLaiks(),
                event.getVieta(),
                event.getMaxDalibnieki(),
                event.getPasreizejaisDalibniekuSkaits(),
                event.getCreatedBy());
    }

    @Nonnull
    public Event DTOtoEntity(@Nonnull EventRequestDTO eventReq) {
        Event eventUzDb = new Event();
        eventUzDb.setNosaukums(eventReq.getNosaukums());
        eventUzDb.setApraksts(eventReq.getApraksts());
        eventUzDb.setDatums(eventReq.getDatums());
        eventUzDb.setLaiks(eventReq.getLaiks());
        eventUzDb.setVieta(eventReq.getVieta());
        eventUzDb.setMaxDalibnieki(eventReq.getMaxDalibnieki());
        eventUzDb.setPasreizejaisDalibniekuSkaits(new ArrayList<>());
        eventUzDb.setCreatedBy(eventReq.getCreatedBy());
        return eventUzDb;
    }

}
