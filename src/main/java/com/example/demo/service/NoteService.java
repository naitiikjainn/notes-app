package com.example.demo.service;

import com.example.demo.entity.note;
import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<note> getAllNotes() {
        return noteRepository.findAll();
    }

    public note createNote(note note) {
        return noteRepository.save(note);
    }

    public note updateNote(Long id, note updatedNote) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setTitle(updatedNote.getTitle());
                    note.setContent(updatedNote.getContent());
                    return noteRepository.save(note);
                })
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}