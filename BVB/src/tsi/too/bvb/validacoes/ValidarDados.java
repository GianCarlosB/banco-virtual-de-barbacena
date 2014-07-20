package tsi.too.bvb.validacoes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

/** A classe <code>ValidarDados</code> possui diversos métodos e constantes necessários na validação de operações do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public class ValidarDados {
	
	/** <code>int</code> que determina o número de dígitos da senha númerica de uma conta bancária */
	public static final int SENHA_NUM = 4;
	
	/** <code>int</code> que determina o número de dígitos da senha alfabética de uma conta bancária */
	public static final int SENHA_ALF = 6;
	
	/** <code>int</code> que determina o número mínimo de dígitos de um login ou senha de funcionário */
	public static final int FUNC_MIN = 6;
	
	/** <code>int</code> que determina o número máximo de dígitos de um login de funcionário */
	public static final int FUNC_LOGIN_MAX = 20;
	
	/** <code>int</code> que determina o número máximo de dígitos de uma senha de funcionário */
	public static final int FUNC_SENHA_MAX = 10;
	
	/** <code>int</code> que determina o ano mínimo de uma data de abertura de conta bancária */
	public static final int ANO_MIN = 2001;
	
	/** <code>int</code> que determina o ano máximo de uma data de abertura de conta bancária */
	public static final int ANO_MAX = 2099;
	
	/** Verifica se uma cadeia de caracteres <code>String</code> está no formato de uma expressão regular
	 *  @param string <code>String</code> com a cadeia de caracteres que serão verificados
	 *  @param expressaoRegular <code>String</code> com a expressão regular
	 *  @return <code>boolean</code> com <code>true</code> caso o valor do objeto String seja igual ao padrão 
	 *  definido pela expressão regular, e <code>false</code> caso contrário
	 */
	public static boolean verificarCadeiaDeCaracteres(String string, String expressaoRegular) {
		// Verifica se o valor do objeto String é igual ao padrão definido pela expressão regular.
		if(string.matches(expressaoRegular))
			return true;
		
		return false;
	}
	
	/** Verifica se uma <code>String</code> de dígitos decimais é um cpf válido
	 *  @param CPF <code>String</code> com os dígitos do CPF
	 *  @return <code>boolean</code> com <code>true</code> caso a cadeia de caracteres da <code>String</code> 
	 *  passada como parâmetro forme um cpf válido, e <code>false</code> caso contrário
	 */
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
	
	/** Verifica se uma <code>String</code> está vazia
	 *  @param str <code>String</code> com a cadeia de caracteres que será verificada 
	 *  @return <code>boolean</code> com <code>true</code> caso a cadeia de caracteres da <code>String</code> 
	 *  passada como parâmetro seja vazia, e <code>false</code> caso contrário
	 */
	public static boolean validarVazio(String str) {
		if(str.equals(""))
			return false;
		
		return true;
	}
	
	/** Verifica se uma <code>String</code> é um valor inteiro
	 *  @param str <code>String</code> com os caracteres que serão verificados 
	 *  @return <code>boolean</code> com <code>true</code> caso os caracteres da <code>String</code> 
	 *  passada como parâmetro seja um valor inteiro, e <code>false</code> caso contrário
	 */
	public static boolean validarIntPositivo(String str) {
		try {
			if(Long.parseLong(str) >= 0)
				return true;
			
			return false;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	/** Verifica se uma <code>String</code> é um valor real
	 *  @param str <code>String</code> com os caracteres que serão verificados 
	 *  @return <code>boolean</code> com <code>true</code> caso os caracteres da <code>String</code> 
	 *  passada como parâmetro seja um valor real, e <code>false</code> caso contrário
	 */
	public static boolean validarDoublePositivo(String str) {
		try {
			if(Double.parseDouble(str) >= 0)
				return true;
			
			return false;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	/** Verifica se uma <code>Date</code> é uma data possível dentro dos parâmetros aceitos no sistema BVB
	 *  @param data <code>Date</code> com a data que será verificada
	 *  @return <code>boolean</code> com <code>true</code> caso a data <code>Date</code> 
	 *  passada como parâmetro seja uma data possível, dentro dos parâmetros aceitos no sistema BVB, e 
	 *  <code>false</code> caso contrário
	 *  
	 *  @see Date
	 *  @see ANO_MIN
	 *  @see ANO_MAX
	 */
	public static boolean validarData(Date data) {
		int ano = -1;
		
		if(data != null) {
			Calendar cal = Calendar.getInstance();
	        cal.setTime(data);
	        ano = cal.get(Calendar.YEAR);
		}
		
		if(ano < ANO_MIN || ano > ANO_MAX) // Possível validação || data.compareTo(new Date()) > 0
			return false;
		
		return true;
	}
	
	/** Verifica se duas <code>Date</code> formam um período válido
	 *  @param dataIni <code>Date</code> com a data inicial do período
	 *  @param dataFin <code>Date</code> com a data final do período
	 *  @return <code>boolean</code> com <code>true</code> caso a data inicial <code>Date</code> 
	 *  passada como parâmetro seja maior que a data final <code>Date</code> passada como parâmetro, e 
	 *  <code>false</code> caso contrário
	 *  
	 *  @see Date
	 */
	public static boolean validarPeriodo(Date dataIni, Date dataFin) {
		Calendar calIni = Calendar.getInstance();
		Calendar calFin = Calendar.getInstance();
		
		if(dataIni != null && dataFin != null) {
			calIni.setTime(dataIni);
			calFin.setTime(dataFin);
		}
		else
			return false;
		
		if(calFin.compareTo(calIni) < 0) // Data final é antes da data inicial.
			return false;
		
		return true;
	}
	
	/** Verifica se uma <code>String</code> é uma senha numérica de conta bancária válida: 4 dígitos decimais
	 *  @param senha <code>String</code> com os caracteres que serão verificados
	 *  @return <code>boolean</code> com <code>true</code> caso os caracteres da <code>String</code> 
	 *  passada como parâmetro seja uma senha numérica de conta bancária válida, e <code>false</code> caso contrário
	 *  
	 *  @see SENHA_NUM
	 */
	public static boolean validarSenhaNumCB(String senha) {
		if(senha.length() != SENHA_NUM)
			return false;
		if(!verificarCadeiaDeCaracteres(senha, "[0-9]{4}"))
			return false;
		
		return true;
	}
	
	/** Verifica se uma <code>String</code> é uma senha alfabética de conta bancária válida: 6 letras maiúsculas ou minúsculas
	 *  @param senha <code>String</code> com os caracteres que serão verificados
	 *  @return <code>boolean</code> com <code>true</code> caso os caracteres da <code>String</code> 
	 *  passada como parâmetro seja uma senha alfabética de conta bancária válida, e <code>false</code> caso contrário
	 *  
	 *  @see SENHA_ALF
	 */
	public static boolean validarSenhaAlfCB(String senha) {
		if(senha.length() != SENHA_ALF)
			return false;
		
		if(!verificarCadeiaDeCaracteres(senha, "[a-zA-Z]{6}"))
			return false;
		
		return true;
	}

	/** Verifica se uma <code>String</code> é um login de funcionário válido: 6 a 20 letras, dígitos e os símbolos underscore (_) ou ponto (.)
	 *  @param login <code>String</code> com os caracteres que serão verificados
	 *  @return <code>boolean</code> com <code>true</code> caso os caracteres da <code>String</code> 
	 *  passada como parâmetro seja um login de funcionário válido, e <code>false</code> caso contrário
	 *  
	 *  @see FUNC_MIN
	 *  @see FUNC_LOGIN_MAX
	 */
	public static boolean validarLoginFunc(String login) {
		if(login.length() < FUNC_MIN || login.length() > FUNC_LOGIN_MAX)
			return false;
		
		if(!verificarCadeiaDeCaracteres(login, "[a-zA-Z0-9\\.\\_]*"))
			return false;
		
		return true;
	}
	
	/** Verifica se um <code>char[]</code> é uma senha de funcionário válida
	 *  @param senha <code>char[]</code> com os caracteres que serão verificados
	 *  @return <code>boolean</code> com <code>true</code> caso os caracteres do <code>char[]</code> 
	 *  passado como parâmetro seja uma senha de funcionário válida, e <code>false</code> caso contrário
	 *  
	 *  @see FUNC_MIN
	 *  @see FUNC_SENHA_MAX
	 */
	public static boolean validarSenhaFunc(char[] senha) {
		if(senha.length < FUNC_MIN || senha.length > FUNC_SENHA_MAX)
			return false;
		
		return true;
	}
	
	/** Verifica se dois <code>char[]</code> são iguais
	 *  @param senha1 <code>char[]</code> referênte a senha 1
	 *  @param senha2 <code>char[]</code> referênte a senha 2
	 *  @return <code>boolean</code> com <code>true</code> caso os dois <code>char[]</code> passados como 
	 *  parâmetro sejam iguais, e <code>false</code> caso contrário
	 */
	public static boolean validarSenhasIguais(char[] senha1, char[] senha2) {
		if(!Arrays.equals(senha1, senha2))
			return false;
		
		return true;
	}
	
	/** Verifica se duas <code>String</code> são iguais
	 *  @param senha1 <code>String</code> referênte a senha 1
	 *  @param senha2 <code>String</code> referênte a senha 2
	 *  @return <code>boolean</code> com <code>true</code> caso as duas <code>String</code> passados como 
	 *  parâmetro sejam iguais, e <code>false</code> caso contrário
	 */
	public static boolean validarSenhasIguais(String senha1, String senha2) {
		if(!senha1.equals(senha2))
			return false;
		
		return true;
	}

} // class ValidarDados
