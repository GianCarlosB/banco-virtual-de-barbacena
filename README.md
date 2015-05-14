BVB - Banco Virtual de Barbacena
========

Trabalho prático apresentado como requisito parcial para obtenção de aprovação na disciplina de Tecnologia de Orientação
a Objetos, do 5º período no Curso de Tecnologia em Sistemas para Internet, no Instituto Federal do Sudeste de
Minas Gerais - Campus Barbacena.<hr>
![logo](https://raw.github.com/GianCarlosB/BVB---Banco-Virtual-de-Barbacena/master/BVB/src/tsi/too/bvb/recursos/imagens/Logo02 - BVB.png)
<hr>
<h4>BVB</h4>
Este sistema possui três módulos: Contas Bancárias, Caixa Eletrônico e Controle de Funcionários. 
A seguir uma breve descrição sobre cada um:<br>
<ul>
  <li>
    Contas Bancárias: este é o módulo fundamental do sistema BVB, composto de serviços elementares oferecidos a 
    qualquer cliente, como, por exemplo, abrir uma conta corrente, depositar o salário, verificar o saldo da conta, 
    sacar dinheiro e efetuar depósito. As funções deste módulo são para uso exclusivo dos funcionários do banco, sendo 
    que os serviços de administração da conta (p. ex. saque, depósito e extrato) são realizados pelo próprio cliente
    através do Caixa Eletrônico.
  </li>
  <li>
    Caixa Eletrônico: é composto de funções que permitam ao cliente exercer o autoatendimento, realizando funções como,
    por exemplo: retirar extrato, fazer uma transferência de sua conta corrente para uma aplicação, depositar um 
    dinheiro em sua caderneta de poupança e sacar dinheiro. Somente clientes do banco estão autorizados a usar os 
    serviços deste módulo, exceção feita a função de depósito, pois qualquer pessoa que esteja portando os códigos de
    identificação de uma conta (número da agência, número e tipo da conta bancária) poderão efetuar um depósito em 
    dinheiro ou cheque na conta de um cliente do BVB.
  </li>
  <li>
    Controle de Funcionários: módulo responsável pela segurança do sistema. Somente funcionários devidamente 
    cadastrados poderão usar as funções do BVB. O Administrador é o responsável por gerenciar as contas de usuários.
  </li>
</ul>
<hr>
<h4>Tecnologias Utilizadas</h4>
<ul>
  <li>Linguagem de Programação Java</li>
  <li>Banco de Dados HSQLDB</li>
  <li>Biblioteca JDBC (para manipulação do banco de dados)</li>
  <li>Biblioteca jdatepicker (para exibição gráfica de datas)</li>
</ul>
<hr>
<strong>* IMPORTANTE *</strong><br>
Para acessar a conta de administrador padrão do BVB, basta entrar com os seguintes dados:<br>
Login: admin_bvb<br>
Senha: 123456
<hr>
<h4>Screenshots</h4>
![menu](https://raw.github.com/GianCarlosB/BVB---Banco-Virtual-de-Barbacena/master/BVB/screenshots/BVB - Menu.png)
