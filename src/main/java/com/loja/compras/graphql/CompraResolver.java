package com.loja.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.loja.compras.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public String status(Compra compra) {
        return compra.getStatus();
    }

    public Cliente cliente(Compra compra) {
        return clienteService.findById(compra.getCliente().getId());
    }

    public Produto produto(Compra compra) {
        return produtoService.findById(compra.getProduto().getId());
    }
}
