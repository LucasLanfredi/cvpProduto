package com.cvp.produto.client;

import com.cvp.produto.entities.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produto-client", url = "${produto.service.url}")
public interface ProdutoClient {

    @GetMapping("/api/produto/interno/{id}")
    Produto buscarPorId(@PathVariable Long id);
}
