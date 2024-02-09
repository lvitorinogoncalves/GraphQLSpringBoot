package com.loja.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.loja.compras.domain.Cliente;
import com.loja.compras.domain.Compra;
import com.loja.compras.domain.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private CompraService compraService;
    public List<Compra> compras(Cliente cliente) {
        return compraService.findAllByCliente(cliente);
    }
}
