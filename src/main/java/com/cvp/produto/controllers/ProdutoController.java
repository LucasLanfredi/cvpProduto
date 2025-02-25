package com.cvp.produto.controllers;

import com.cvp.produto.dto.ProdutoDTO;
import com.cvp.produto.entities.Produto;
import com.cvp.produto.services.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/produto/interno")
@Tag(name = "Produto API", description = "APIs para gerenciar produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @Operation(summary = "Cria um novo produto", description = "Insere um produto no banco de dados")
    @ApiResponse(responseCode = "201", description = "Produto criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @PostMapping
    public ResponseEntity<Produto> createProduto(@Validated @RequestBody ProdutoDTO produtoDTO) {
        final Produto produtoCriado = produtoService.salvar(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }

    @Operation(summary = "Lista todos os produtos", description = "Retorna todos os produtos cadastrados")
    @ApiResponse(responseCode = "200", description = "Produtos listados com sucesso")
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        final List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @Operation(summary = "Busca um produto pelo ID", description = "Retorna o produto com base no ID informado")
    @ApiResponse(responseCode = "200", description = "Produto encontrado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable @Validated Long id) {
        Produto produto = produtoService.buscarPorId(id);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

}
