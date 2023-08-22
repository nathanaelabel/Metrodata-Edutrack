package com.metrodata.controllers;

import com.metrodata.entities.Participant;
import com.metrodata.entities.models.ParticipantData;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("participant")
public class ParticipantController {

    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping
    public List<Participant> getParticipant() {
        return participantService.getAllParticipants();
    }

    @GetMapping("{id}")
    public Participant getParticipantById(Long id) {
        return participantService.getParticipantById(id);
    }

    @PostMapping
    public ResponseData<Participant> insertParticipant(ParticipantData participantData) {
        return participantService.insertParticipant(participantData);
    }

    @PostMapping("{id}")
    public Participant updateParticipant(long id, Participant participant) {
        return participantService.updateParticipant(id, participant);
    }

    @DeleteMapping("{id}")
    public Participant deleteParticipant(long id) {
        return participantService.deleteParticipant(id);
    }
}
