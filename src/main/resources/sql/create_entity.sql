CREATE TABLE PRODUTO (
                         id NUMBER(19,0) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                         nome VARCHAR2(100 CHAR) NOT NULL,
                         preco NUMBER(10,2) NOT NULL
);