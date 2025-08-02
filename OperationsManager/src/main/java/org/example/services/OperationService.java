package org.example.services;

import org.example.documents.Operation;
import org.example.documents.dto.OperationDTO;
import org.example.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService implements CRUDServices<Operation, OperationDTO>{
    @Autowired
    protected OperationRepository repository;

    @Override
    public Operation save(OperationDTO dto) {
        return repository.save(new Operation(dto));
    }

    @Override
    public Operation change(Operation operation) {
        return repository.save(operation);
    }

    @Override
    public List<Operation> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Operation> findByID(String id) {
        return repository.findById(id);
    }

    @Override
    public void deleteByID(String id) {
        repository.deleteById(id);
    }
}
