package com.bentao.api_produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bentao.api_produtos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);//procura o usário pelo nome
    List<Usuario> findByNomeContaining(String parteDoNome);
}
