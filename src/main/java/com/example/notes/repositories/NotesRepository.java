package com.example.notes.repositories;

import com.example.notes.models.tables.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface NotesRepository extends CrudRepository<Note, UUID> {

}
