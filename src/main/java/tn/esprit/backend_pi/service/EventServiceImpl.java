package tn.esprit.backend_pi.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend_pi.entity.Event;
import tn.esprit.backend_pi.repository.EventRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements IEventService{
    @Autowired
    EventRepository EventRepository;
    public List<Event> retrieveAllEvents() {
        return EventRepository.findAll();
    }
    public Event retrieveEvent(Long eventId) {
        return EventRepository.findById(eventId).get();
    }
    public Event addEvent(Event e) {
        return EventRepository.save(e);
    }
    public void removeEvent(Long eventId) {
        EventRepository.deleteById(eventId);
    }
    public Event modifyEvent(Event event) {
        return EventRepository.save(event);

    }
}
