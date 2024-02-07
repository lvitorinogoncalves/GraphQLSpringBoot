package com.loja.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente cliente(Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> clientes() {
        return clienteService.findAll();
    }

    public Cliente saveCliente(ClienteInput clienteInput) {
//        Cliente cliente = new Cliente();
//        cliente.setId(clienteInput.getId());
//        cliente.setNome(clienteInput.getNome());
//        cliente.setEmail(clienteInput.getEmail());

        ModelMapper m = new ModelMapper();
        Cliente cliente = m.map(clienteInput, Cliente.class);

        return clienteService.save(cliente);
    }

    public Boolean deleteCliente(Long id) {
         return clienteService.deleteById(id);
    }
}
