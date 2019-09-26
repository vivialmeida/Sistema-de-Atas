package Exceçoes;

@SuppressWarnings("serial")
public class PalavraChaveException extends Exception {

	@Override
	public String toString() {

		return "Atenção: \n Numero de palavras-chave deve ser maior/igual a 1 e menor/igual a 5";
	}

}
