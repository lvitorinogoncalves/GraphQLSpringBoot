package com.loja.compras.domain;

import com.loja.compras.graphql.dto.CompraResumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query("select c from Compra c where c.cliente.id = :clienteId")
    List<Compra> findAllByCliente(@Param("clienteId") Long clienteId);

    @Query("select new com.loja.compras.graphql.dto.CompraResumo(compra.id, cliente.nome, produto.nome, compra.quantidade)" +
            " from Compra compra inner join" +
            "      compra.cliente cliente inner join" +
            "      compra.produto produto")
    List<CompraResumo> findAllComprasRelatorio();
}