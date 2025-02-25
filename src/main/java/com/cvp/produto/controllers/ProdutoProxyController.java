package com.cvp.produto.controllers;

import com.cvp.produto.client.ProdutoClient;
import com.cvp.produto.entities.Produto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto/externo")
@AllArgsConstructor
public class ProdutoProxyController {

    private final ProdutoClient produtoClient;

    @Operation(summary = "Busca um produto pelo ID", description = "Retorna o produto com base no ID informado")
    @ApiResponse(responseCode = "200", description = "Produto encontrado")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable @Validated Long id) {
        Produto produto = produtoClient.buscarPorId(id);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }
}
