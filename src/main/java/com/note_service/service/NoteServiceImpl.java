package com.note_service.service;

import com.note_service.model.Note;
import com.note_service.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public List<Note> getNotesByPatientId(String patientId) {
        return noteRepository.findByPatientId(patientId);
    }

    @Override
    public Note addNoteForPatient(String patientId, String contenu) {
        Note note = new Note();
        note.setPatientId(patientId);
        note.setContenu(contenu);
        note.setDate(LocalDateTime.now());
        return noteRepository.save(note);
    }
}
