package com.api.mscatalog.controller;

import com.api.mscatalog.model.ProdutoModel;
import com.api.mscatalog.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel> obterTodos(){
        return this.produtoService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public ProdutoModel obterPorCodigo(@PathVariable String codigo){
        return this.produtoService.obterPorCodigo(codigo);
    }

    @PostMapping
    public ProdutoModel criar(@RequestBody ProdutoModel produtoModel) {
        return this.produtoService.criar(produtoModel);

    }

}
