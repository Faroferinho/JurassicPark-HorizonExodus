package org.example.repositories;

import org.example.documents.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends MongoRepository<Operation, String> {
}
