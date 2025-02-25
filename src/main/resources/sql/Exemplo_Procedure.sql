
-- Exemplo de uso da Package `produto_package` com comentários

-- 1. Adicionando um Produto
-- O procedimento abaixo adiciona um novo produto na tabela `produto`.
BEGIN
    produto_package.adicionar_produto('Produto Exemplo', 100.00);
END;
/

-- 2. Atualizando o Preço de um Produto
-- O procedimento abaixo atualiza o preço de um produto já existente. 
-- Aqui estamos atualizando o preço do produto com ID 1 para 120.
BEGIN
    produto_package.atualizar_preco_produto(1, 120.00);  -- Atualizando o preço do produto com ID 1 para 120
END;
/

-- 3. Deletando um Produto
-- O procedimento abaixo deleta um produto existente. 
-- Aqui estamos deletando o produto com ID 1.
BEGIN
    produto_package.deletar_produto(1);  -- Deletando o produto com ID 1
END;
/

-- 4. Calculando o Preço com Desconto
-- A função abaixo calcula o preço de um produto com um desconto aplicado.
-- Aqui estamos calculando o preço do produto com ID 1 com um desconto de 10%.
DECLARE
    v_preco_com_desconto NUMBER;
BEGIN
    v_preco_com_desconto := produto_package.calcular_preco_com_desconto(1, 10);  -- Desconto de 10% no produto com ID 1
    DBMS_OUTPUT.PUT_LINE('Preço com desconto: ' || v_preco_com_desconto);
END;
/

-- 5. Obtendo o Preço de um Produto
-- A função abaixo retorna o preço de um produto existente, dado o seu ID.
-- Aqui estamos obtendo o preço do produto com ID 1.
DECLARE
    v_preco NUMBER;
BEGIN
    v_preco := produto_package.obter_preco_produto(1);  -- Obtendo o preço do produto com ID 1
    DBMS_OUTPUT.PUT_LINE('Preço do produto: ' || v_preco);
END;
/
