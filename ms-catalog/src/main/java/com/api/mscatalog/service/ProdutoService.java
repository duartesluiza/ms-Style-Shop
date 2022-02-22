package com.api.mscatalog.service;

import com.api.mscatalog.model.ProdutoModel;

import java.util.List;

public interface ProdutoService {

    public List<ProdutoModel> obterTodos();

    public ProdutoModel obterPorCodigo(String codigo);

    public ProdutoModel criar(ProdutoModel produtoModel);


}
