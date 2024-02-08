package com.loja.compras.graphql;

import lombok.Data;

@Data
public class ProdutoInput {

    private Long id;
    private String nome;
    private Float valor;
}
