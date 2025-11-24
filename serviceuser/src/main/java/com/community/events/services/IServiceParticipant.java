package com.community.events.services;
import com.community.events.entities.Participant;
import java.util.List;
public interface IServiceParticipant {
    Participant create(Participant participant);
    Participant get(Long id);
    List<Participant> all();
    Participant update(Participant participant);
    void delete(Long id);
}
