package com.cvp.produto.services;

import com.cvp.produto.dto.ProdutoDTO;
import com.cvp.produto.entities.Produto;
import com.cvp.produto.repositories.ProdutoRepository;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto salvar(@NotNull final ProdutoDTO produtoDTO) {
        final Produto produto = Produto.builder().nome(produtoDTO.getNome()).preco(produtoDTO.getPreco()).build();
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}