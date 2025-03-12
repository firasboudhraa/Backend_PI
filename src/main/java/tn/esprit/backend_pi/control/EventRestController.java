package tn.esprit.backend_pi.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.Event;
import tn.esprit.backend_pi.service.IEventService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EventRestController {
    @Autowired
    IEventService eventService;
    // http://localhost:8089/Backend/event/retrieve-all-events
    @GetMapping("/retrieve-all-events")
    public List<Event> getevents() {
        List<Event> listevents = eventService.retrieveAllEvents();
        return listevents;
    }
    // http://localhost:8089/Backend/event/retrieve-event/1
    @GetMapping("/retrieve-event/{event-id}")
    public Event retrieveevent(@PathVariable("event-id") Long eId) {
        Event event = eventService.retrieveEvent(eId);
        return event;
    }
    // http://localhost:8089/Backend/event/add-event
    @PostMapping("/add-event")
    public Event addevent(@RequestBody Event e) {
        Event event = eventService.addEvent(e);
        return event;
    }
    // http://localhost:8089/Backend/event/remove-event/{event-id}
    @DeleteMapping("/remove-event/{event-id}")
    public void removeevent(@PathVariable("event-id") Long eId) {
        eventService.removeEvent(eId);
    }
    // http://localhost:8089/Backend/event/modify-event
    @PutMapping("/modify-event")
    public Event modifyevent(@RequestBody Event e) {
        Event event = eventService.modifyEvent(e);
        return event;
    }

}