package com.loja.compras.graphql;

import lombok.Data;

@Data
public class ClienteInput {

    private Long id;
    private String nome;
    private String email;

}