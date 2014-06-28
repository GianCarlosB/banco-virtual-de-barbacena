/* Cria as tabelas */

CREATE TABLE IF NOT EXISTS cliente (
	CPF VARCHAR(11) NOT NULL,
	nome VARCHAR(250),
	logradouro VARCHAR (250),
	numero VARCHAR (50),
	complemento VARCHAR(250),
	bairro VARCHAR(250),
	cidade VARCHAR(250),
	UF VARCHAR(2),
	cep VARCHAR(8),
	telFixo VARCHAR(10),
	telMovel VARCHAR(10),

	CONSTRAINT pk_cliente PRIMARY KEY (CPF)
);

CREATE TABLE IF NOT EXISTS agencia (
	codAgencia NUMERIC(4, 0) NOT NULL,
	descricao VARCHAR(250),

	CONSTRAINT pk_agencia PRIMARY KEY (codAgencia)
);

CREATE TABLE IF NOT EXISTS conta_bancaria (
	numeroConta NUMERIC(9, 0) NOT NULL,
	codAgencia NUMERIC(4, 0) NOT NULL,
	tipoConta NUMERIC(1, 0) NOT NULL,
	CPF VARCHAR(11),
	contaSalario boolean DEFAULT false,
	dataAbertura Date,
	saldo NUMERIC(15, 2) DEFAULT 0,
	senhaNumerica VARCHAR(32),
	senhaAlfabetica VARCHAR(32),

	CONSTRAINT fk_conta_bancaria_agencia FOREIGN KEY (codAgencia) REFERENCES agencia(codAgencia) ON DELETE CASCADE,
	CONSTRAINT fk_conta_bancaria_cliente FOREIGN KEY (CPF) REFERENCES cliente(CPF) ON DELETE CASCADE,
	CONSTRAINT pk_conta_bancaria PRIMARY KEY (numeroConta, codAgencia, tipoConta)
);

CREATE TABLE IF NOT EXISTS movimentacao (
	numeroConta NUMERIC(9, 0)  NOT NULL,
	codAgencia NUMERIC(4, 0) NOT NULL,
	tipoConta NUMERIC(1, 0) NOT NULL,
	data Date NOT NULL,
	hora DateTime NOT NULL,
	valor NUMERIC(15, 2) DEFAULT 0,
	tipoOperacao NUMERIC(1, 0),

	CONSTRAINT fk_movimentacao_conta_bancaria FOREIGN KEY (codAgencia, numeroConta, tipoConta) REFERENCES conta_bancaria(codAgencia, numeroConta, tipoConta) ON DELETE CASCADE,
	CONSTRAINT pk_movimentacao PRIMARY KEY (numeroConta, codAgencia, tipoConta, data, hora)
);

CREATE TABLE IF NOT EXISTS funcionario (
	nomeUsuario VARCHAR(20) NOT NULL ,
	senha VARCHAR(32),
	tipoUsuario CHAR,

	CONSTRAINT pk_funcionario PRIMARY KEY (nomeUsuario)
);

CREATE TABLE IF NOT EXISTS conexao (
	nomeUsuario VARCHAR(20) NOT NULL,
	dataInicial Date NOT NULL,
	horaInicial DateTime NOT NULL,
	dataFinal Date,
	horaFinal DateTime,

	CONSTRAINT fk_conexao_funcionario FOREIGN KEY (nomeUsuario) REFERENCES funcionario(nomeUsuario) ON DELETE CASCADE,
	CONSTRAINT pk_conexao PRIMARY KEY (nomeUsuario, dataInicial, horaInicial)
);

/* Cria Sequencias */
CREATE SEQUENCE seq_agencia START WITH 1;
CREATE SEQUENCE seq_conta_bancaria START WITH 1;
