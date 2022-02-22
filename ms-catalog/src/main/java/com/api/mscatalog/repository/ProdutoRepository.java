package com.api.mscatalog.repository;

import com.api.mscatalog.model.ProdutoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<ProdutoModel, String> {

}
