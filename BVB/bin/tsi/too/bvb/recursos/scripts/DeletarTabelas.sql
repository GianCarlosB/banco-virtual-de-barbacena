/* Deleta Tabelas */
DROP TABLE cliente CASCADE;
DROP TABLE agencia CASCADE;
DROP TABLE conta_bancaria CASCADE;
DROP TABLE movimentacao CASCADE;
DROP TABLE funcionario CASCADE;
DROP TABLE conexao CASCADE;

/* Deleta Sequencias*/
DROP SEQUENCE seq_agencia IF EXISTS;
DROP SEQUENCE seq_conta_bancaria IF EXISTS;
