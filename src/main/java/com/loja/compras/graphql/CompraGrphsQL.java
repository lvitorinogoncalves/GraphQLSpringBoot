package com.loja.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.loja.compras.domain.ClienteService;
import com.loja.compras.domain.Compra;
import com.loja.compras.domain.CompraService;
import com.loja.compras.domain.ProdutoService;
import com.loja.compras.graphql.dto.CompraResumo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompraGrphsQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService compraService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;
    public Compra compra(Long id) {
        return compraService.findById(id);
    }

    public List<Compra> getCompras(int page, int size) {
        return compraService.findAll(PageRequest.of(page, size, Sort.by("quantidade").descending()));
    }

    public List<CompraResumo> getComprasRelatorio() {
        return compraService.findAllComprasRelatorio();
    }

    public Compra saveCompra(CompraInput compraInput) {
        ModelMapper modelMapper = new ModelMapper();
        Compra compra = modelMapper.map(compraInput, Compra.class);

        compra.setData(new Date());
        compra.setCliente(clienteService.findById(compraInput.getClienteId()));
        compra.setProduto(produtoService.findById(compraInput.getProdutoId()));

        return compraService.save(compra);
    }

    public Boolean deleteCompra(Long id) {
        return compraService.deleteById(id);
    }
}