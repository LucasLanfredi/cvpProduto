package com.cvp.produto.controllers;

import com.cvp.produto.dto.ProdutoDTO;
import com.cvp.produto.entities.Produto;
import com.cvp.produto.repositories.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ProdutoControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProdutoRepository produtoRepository;

    @BeforeEach
    public void setUp() {
        produtoRepository.deleteAll();
    }

    @Test
    public void testCreateProduto() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Produto Teste");
        produtoDTO.setPreco(BigDecimal.TEN);

        // Envia o POST para criar o produto
        ResponseEntity<Produto> response = restTemplate
                .postForEntity("/api/produto/interno", produtoDTO, Produto.class);

        // Verifica se o produto foi criado com sucesso
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getBody().getId() > 0);
    }

    @Test
    public void testGetAllProdutos() {
        ProdutoDTO produtoDTO1 = new ProdutoDTO();
        produtoDTO1.setNome("Produto 1");
        produtoDTO1.setPreco(BigDecimal.TEN);

        ProdutoDTO produtoDTO2 = new ProdutoDTO();
        produtoDTO2.setNome("Produto 2");
        produtoDTO2.setPreco(BigDecimal.ONE);

        // Cria dois produtos no banco de dados
        restTemplate.postForEntity("/api/produto/interno", produtoDTO1, Produto.class);
        restTemplate.postForEntity("/api/produto/interno", produtoDTO2, Produto.class);

        // Envia GET para listar os produtos
        ResponseEntity<List> response = restTemplate
                .getForEntity("/api/produto/interno", List.class);

        // Verifica se os produtos foram retornados
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().size() > 0);
    }

    @Test
    public void testGetProdutoById() {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome("Produto Teste");
        produtoDTO.setPreco(BigDecimal.TEN);

        // Cria o produto
        Produto produtoCriado = restTemplate
                .postForObject("/api/produto/interno", produtoDTO, Produto.class);

        // Envia GET para buscar o produto pelo ID
        ResponseEntity<Produto> response = restTemplate
                .getForEntity("/api/produto/interno/" + produtoCriado.getId(), Produto.class);

        // Verifica se o produto foi encontrado
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(produtoCriado.getId(), response.getBody().getId());
    }

    @Test
    public void testGetProdutoByIdNotFound() {
        // Envia GET para buscar um produto com um ID inexistente
        ResponseEntity<Produto> response = restTemplate
                .getForEntity("/api/produto/interno/99999", Produto.class);

        // Verifica se a resposta é 404
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
