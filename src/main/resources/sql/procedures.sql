CREATE OR REPLACE PACKAGE produto_package AS
    -- Função para calcular o preço com desconto
    FUNCTION calcular_preco_com_desconto(p_produto_id IN NUMBER, p_desconto IN NUMBER) RETURN NUMBER;

    -- Procedure para adicionar um novo produto
    PROCEDURE adicionar_produto(p_nome IN VARCHAR2, p_preco IN NUMBER);

    -- Procedure para atualizar preço de um produto
    PROCEDURE atualizar_preco_produto(p_produto_id IN NUMBER, p_novo_preco IN NUMBER);

    -- Procedure para deletar um produto
    PROCEDURE deletar_produto(p_produto_id IN NUMBER);

    -- Função para buscar o preço de um produto por ID
    FUNCTION obter_preco_produto(p_produto_id IN NUMBER) RETURN NUMBER;

END produto_package;
/

CREATE OR REPLACE PACKAGE BODY produto_package AS

    -- Implementação da função de cálculo de preço com desconto
    FUNCTION calcular_preco_com_desconto(p_produto_id IN NUMBER, p_desconto IN NUMBER) RETURN NUMBER IS
        v_preco NUMBER;
BEGIN
SELECT preco INTO v_preco FROM PRODUTO WHERE id = p_produto_id;
RETURN v_preco - (v_preco * p_desconto / 100);
END calcular_preco_com_desconto;

    -- Implementação da procedure de adicionar produto
    PROCEDURE adicionar_produto(p_nome IN VARCHAR2, p_preco IN NUMBER) IS
BEGIN
INSERT INTO PRODUTO (nome, preco) VALUES (p_nome, p_preco);
END adicionar_produto;

    -- Implementação da procedure de atualizar preço
    PROCEDURE atualizar_preco_produto(p_produto_id IN NUMBER, p_novo_preco IN NUMBER) IS
BEGIN
UPDATE PRODUTO
SET preco = p_novo_preco
WHERE id = p_produto_id;
END atualizar_preco_produto;

    -- Implementação da procedure de deletar produto
    PROCEDURE deletar_produto(p_produto_id IN NUMBER) IS
BEGIN
DELETE FROM PRODUTO WHERE id = p_produto_id;
END deletar_produto;

    -- Implementação da função para obter o preço do produto
    FUNCTION obter_preco_produto(p_produto_id IN NUMBER) RETURN NUMBER IS
        v_preco NUMBER;
BEGIN
SELECT preco INTO v_preco FROM PRODUTO WHERE id = p_produto_id;
RETURN v_preco;
END obter_preco_produto;

END produto_package;
/
