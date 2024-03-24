package com.example.notes.controllers;

import com.example.notes.models.dtos.NotesDTO;
import com.example.notes.models.tables.Note;
import com.example.notes.services.NotesService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Log4j2
@Validated
@RequestMapping("/v1")
public class NotesController {
    @Autowired
    private NotesService notesService;

    @PostMapping("/notes")
    String postNotes(@RequestBody NotesDTO notesDTO) {
        return notesService.postNote(notesDTO);
    }

    @GetMapping(value = "/notes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody List<Note> getAllNotes() {
        return StreamSupport.stream(notesService.getRepository().findAll().spliterator(),false).collect(Collectors.toList());
    }

    @GetMapping(value = "/notes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody Note getNotesById(@RequestParam String id) {
        return notesService.getNotesById(id);
    }

    @PutMapping(value = "/notes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody Note updateNotesById(@RequestParam String id, @RequestBody NotesDTO notesDTO) {
        return notesService.updateNote(id,notesDTO);
    }

    @DeleteMapping("/notes/{id}")
    void deleteNotesById(@RequestParam String id) {
        notesService.getRepository().deleteById(UUID.fromString(id));
    }
}
