package com.loja.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.loja.compras.domain.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

    public String valorReais(Produto produto) {
        return "R$ " + produto.getValor();
    }
}
