package com.bentao.api_produtos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bentao.api_produtos.model.Produto;
import com.bentao.api_produtos.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoRepository repository;//'final' é igual a imutável - constante
    
    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    }

@PostMapping
public Produto criar(@RequestBody Produto produto){
    return repository.save(produto); //salva o novo produto no repositório
}
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return repository.save(produto); // Salva o produto no banco de dados
    }

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll(); // Retorna todos os produtos
    }

@GetMapping("/{id}")
public Produto buscar (@PathVariable Long id) {
    return repository.findById(id).orElse(null);
}
    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) { // Corrigido: "Produtos" para "Produto"
        return repository.findById(id).orElse(null); // Retorna o produto ou null se não encontrado
    }

    @PutMapping("/{id}") // Corrigido: "/id" para "/{id}"
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto novoProduto) {
        return repository.findById(id).map(produto -> {
            produto.setNome(novoProduto.getNome());
            produto.setPreco(novoProduto.getPreco());
            return repository.save(produto); // Atualiza o produto no banco de dados
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id); // Exclui o produto pelo ID
    }
}
}