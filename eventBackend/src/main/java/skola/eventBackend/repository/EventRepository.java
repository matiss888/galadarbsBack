package skola.eventBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import skola.eventBackend.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
