package com.api.mscatalog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ProdutoModel {

    @Id
    private String codigo;
    private String name;
    private String description;
    private boolean active;
//    private String category_ids;

}
