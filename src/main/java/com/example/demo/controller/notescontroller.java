package com.example.demo.controller;


import com.example.demo.entity.note;
import com.example.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class notescontroller {

    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public List<note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("/post")
    public note createNote(@RequestBody note note) {
        return noteService.createNote(note);
    }

    @PutMapping("/{id}")
    public note updateNote(@PathVariable Long id, @RequestBody note updatedNote) {
        return noteService.updateNote(id, updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
