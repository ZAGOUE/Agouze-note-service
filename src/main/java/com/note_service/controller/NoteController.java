package com.note_service.controller;

import com.note_service.model.Note;
import com.note_service.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    // GET /notes/patient/{patientId}
    @GetMapping("/patient/{patientId}")
    public List<Note> getNotesByPatientId(@PathVariable String patientId) {
        return noteService.getNotesByPatientId(patientId);
    }

    // POST /notes/patient/{patientId}
    @PostMapping("/patient/{patientId}")
    public Note addNoteForPatient(
            @PathVariable String patientId,
            @RequestBody Map<String, String> body
    ) {
        String contenu = body.get("contenu");
        return noteService.addNoteForPatient(patientId, contenu);
    }
}
