package com.example.demo.repository;

import com.example.demo.entity.note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<note, Long> {
}
