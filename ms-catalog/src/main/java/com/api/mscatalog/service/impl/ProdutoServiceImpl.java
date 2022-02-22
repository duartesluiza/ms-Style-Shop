package com.api.mscatalog.service.impl;

import com.api.mscatalog.model.ProdutoModel;
import com.api.mscatalog.repository.ProdutoRepository;
import com.api.mscatalog.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<ProdutoModel> obterTodos() {
        return this.produtoRepository.findAll();
    }

    @Override
    public ProdutoModel obterPorCodigo(String codigo) {
        return this.produtoRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Produto não existe."));
    }

    @Override
    public ProdutoModel criar(ProdutoModel produtoModel) {
        return this.produtoRepository.save(produtoModel);
    }
}
