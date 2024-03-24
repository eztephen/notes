package com.example.notes.services;

import com.example.notes.models.dtos.NotesDTO;
import com.example.notes.models.tables.Note;
import com.example.notes.repositories.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public NotesRepository getRepository(){
        return notesRepository;
    }
    public String postNote(NotesDTO notesDTO) {
        return getRepository().save(Note.builder().title(notesDTO.getTitle())
                .body(notesDTO.getBody())
                .build()).getId().toString();
    }

    public Note getNotesById(String id) {

        Optional<Note> note = getRepository().findById(UUID.fromString(id));

        if(note.isPresent()){
            return note.get();
        } else {
            throw new NullPointerException("Note does not exist!");
        }

    }

    public Note updateNote(String id, NotesDTO notesDTO) {

        Optional<Note> note = getRepository().findById(UUID.fromString(id));
        if(note.isPresent()){
             note.get().setTitle(notesDTO.getTitle());
             note.get().setBody(notesDTO.getBody());

             return getRepository().save(note.get());
        } else {
            throw new NullPointerException("Note does not exist!");
        }
    }
}
