package com.myfinance.utils;

public class StringUtils {
	
	/**
	 * Essa validação serve para verificar se o numero passado consiste num
	 * numero de CPF valido, inclusive testando pelo tamanho;
	 * 
	 * @return retorna true caso o Numero seja um CPF Valido
	 */
	public static boolean validarCPF(String cpf) {

		int soma = 0;
		boolean retorno = false;

		/* Se o tamanho do CPF for menor que o tamanho correto, levante um erro */
		if (cpf.length() != 11) {
			return false;
		}

		for (int i = 0; i < 9; i++) {
			soma += (10 - i) * (cpf.charAt(i) - '0');
		}
		soma = 11 - soma % 11;
		if (soma > 9) {
			soma = 0;
		}
		if (soma == cpf.charAt(9) - '0') {
			soma = 0;
			for (int i = 0; i < 10; i++) {
				soma += (11 - i) * (cpf.charAt(i) - '0');
			}
			soma = 11 - soma % 11;
			if (soma > 9) {
				soma = 0;
			}
			if (soma == cpf.charAt(10) - '0') {
				retorno = true;
			}
		}
		return retorno;
	}

}
