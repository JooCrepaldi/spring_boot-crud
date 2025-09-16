package com.bentao.api_produtos.repository;

import java.util.List; // Corrigido: "List" com "L" maiúsculo
import org.springframework.data.jpa.repository.JpaRepository; // Corrigido: ponto no lugar da vírgula

import com.bentao.api_produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);
    List<Produto> findByNomeContaining(String parteDoNome);
}