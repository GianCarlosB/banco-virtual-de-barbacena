package tsi.too.bvb.validacoes;

import java.sql.Date;
import java.util.InputMismatchException;

import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.entidades.tiposenumerados.TipoOperacao;
import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;
import tsi.too.bvb.entidades.tiposenumerados.UF;

public class ValidarDados {
	private static final int SENHA_NUM = 4, SENHA_ALF = 6,
			          FUNC_MIN = 6, FUNC_LOGIN_MAX = 20, FUNC_SENHA_MAX = 10,
			          ANO_MIN = 2001, ANO_MAX = 2099;
	
	public ValidarDados() {
		super();
	}
	
	public int getSENHA_NUM() {
		return SENHA_NUM;
	}

	public int getSENHA_ALF() {
		return SENHA_ALF;
	}

	public int getFUNC_MIN() {
		return FUNC_MIN;
	}

	public int getFUNC_LOGIN_MAX() {
		return FUNC_LOGIN_MAX;
	}

	public int getFUNC_SENHA_MAX() {
		return FUNC_SENHA_MAX;
	}

	public int getANO_MIN() {
		return ANO_MIN;
	}

	public int getANO_MAX() {
		return ANO_MAX;
	}
	
	private static String[] quebrarCadeiaDeCaracteres(String string, String expressaoRegular) {
		// Obtém as Strings usando a expressão regular.
		String strings[] = string.split(expressaoRegular);
		
		return strings;
	}
	
	private static boolean verificarCadeiaDeCaracteres(String string, String expressaoRegular) {
		// Verifica se o valor do objeto String é igual ao padrão definido pela expressão regular.
		if(string.matches(expressaoRegular))
			return true;
		
		return false;
	}
	
	public static boolean validarCPF(String CPF) {
		// Considera-se erro CPF's formados por uma sequência de números iguais
	    if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
	        CPF.equals("22222222222") || CPF.equals("33333333333") ||
	        CPF.equals("44444444444") || CPF.equals("55555555555") ||
	        CPF.equals("66666666666") || CPF.equals("77777777777") ||
	        CPF.equals("88888888888") || CPF.equals("99999999999") ||
	       (CPF.length() != 11))
			return false;

	    try {
			char dig10, dig11;
			int sm = 0, i, r, num, peso = 10;

			// Cálculo do 1º dígito verificador
			for(i = 0; i < 9; i++) {              
			/*
			 *  converte o i-esimo caractere do CPF em um numero:
			 *  por exemplo, transforma o caractere '0' no inteiro 0
			 *  (48 eh a posicao de '0' na tabela ASCII)
			 */    
				num = (int)(CPF.charAt(i) - 48); 
				sm = sm + (num * peso);
				peso = peso - 1;
			}
		
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
			   dig10 = '0';
			else dig10 = (char)(r + 48); // converte no respectivo caractere numerico
			
			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for(i=0; i<10; i++) {
			  num = (int)(CPF.charAt(i) - 48);
			  sm = sm + (num * peso);
			  peso = peso - 1;
			}
		
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
			   dig11 = '0';
			else dig11 = (char)(r + 48);
			
			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
			   return true;
		  
			return false;
			
		} catch (InputMismatchException erro) {
			return false;
		}
	}

	public static boolean validarVazio(String str) {
		if(str.equals(""))
			return false;
		
		return true;
	}
	
	public static boolean validarIntPositivo(String str) {
		try {
			if(Long.parseLong(str) >= 0)
				return true;
			
			return false;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean validarUF(String uf) {
		if(UF.obterUF(uf) == null)
			return false;
		
		return true;
	}
	
	public static boolean validarTipoConta(String tipo) {
		if(TipoConta.obterTipoConta(tipo) == null)
			return false;
		
		return true;
	}
	
	public static boolean validarTipoOperacao(String tipo) {
		if(TipoOperacao.obterTipoOperacao(tipo) == null)
			return false;
		
		return true;
	}

	public static boolean validarTipoUsuario(String tipo) {
		if(TipoUsuario.obterTipoUsuario(tipo) == null)
			return false;
		
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean validarData(Date data) {
		if(data.getYear() < 2001)
			return false;
		
		return true;
	}
	
	public static boolean validarSenhaNumCB(String senha) {
		if(senha.length() != SENHA_NUM)
			return false;
		
		return true;
	}
	
	public static boolean validarSenhaAlfCB(String senha) {
		if(senha.length() != SENHA_NUM)
			return false;
		
		return true;
	}
	
	public static boolean validarLoginFunc(String login) {
		if(login.length() < FUNC_MIN || login.length() > FUNC_LOGIN_MAX)
			return false;
		
		if(verificarCadeiaDeCaracteres(login, "[a-zA-Z0-9\\-\\_]*") == false)
			return false;
		
		return true;
	}
	
	public static boolean validarSenhaFunc(char[] senha) {
		if(senha.length < FUNC_MIN || senha.length > FUNC_SENHA_MAX)
			return false;
		
		return true;
	}
	
	public static boolean validarSenhaFunc(String senha1, String senha2) {
		if(!senha1.toString().equals(senha2.toString()))
			return false;
		
		return true;
	}

} // class ValidarDados
