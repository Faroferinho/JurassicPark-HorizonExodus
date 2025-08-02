package org.example.documents;

import lombok.Getter;
import lombok.Setter;
import org.example.documents.dto.OperationDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter @Setter
public class Operation {
    private String id;
    private String name;
    private String description;
    private int worker;

    public Operation(){

    }

    public Operation(String id, String name, String description, int worker){
        this.id = id;
        this.name = name;
        this.description = description;
        this.worker = worker;
    }

    public Operation(OperationDTO dto){
        name = dto.getName();
        description = dto.getDescription();
        worker = dto.getWorker();
    }
}
