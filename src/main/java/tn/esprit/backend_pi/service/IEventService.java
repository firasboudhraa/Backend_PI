package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.Event;

import java.util.List;

public interface IEventService {
    public List<Event> retrieveAllEvents();
    public Event retrieveEvent(Long eventId);
    public Event addEvent(Event e);
    public void removeEvent(Long eventId);
    public Event modifyEvent(Event event);
}
