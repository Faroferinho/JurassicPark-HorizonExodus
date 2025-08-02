package org.example.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CRUDController<Document, DocumentDTO> {
    ResponseEntity<Document> create(String Authorization, DocumentDTO dto);

    ResponseEntity<Document> update(String Authorization, String id, DocumentDTO dto);

    ResponseEntity<List<Document>> findAll(String Authorization);

    ResponseEntity<Optional<Document>> findById(String Authorization, String id);

    ResponseEntity<Void> deleteById(String Authorization, String id);
}
