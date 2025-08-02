package org.example.controllers;

import org.example.documents.Operation;
import org.example.documents.dto.OperationDTO;
import org.example.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OperationController implements CRUDController<Operation, OperationDTO>{
    @Autowired
    private OperationService service;

    @Override
    @PostMapping()
    public ResponseEntity<Operation> create(@RequestBody OperationDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    @PutMapping()
    public ResponseEntity<Operation> update(@PathVariable String id, @RequestBody OperationDTO dto) {
        Operation o = new Operation(dto);
        o.setId(id);

        return ResponseEntity.ok(service.change(o));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Operation>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping
    public ResponseEntity<Optional<Operation>> findById(@PathVariable String id) {
        return ResponseEntity.ok(service.findByID(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
}
