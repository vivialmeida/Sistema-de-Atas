package Exce�oes;

@SuppressWarnings("serial")
public class PalavraChaveException extends Exception {

	@Override
	public String toString() {

		return "Aten��o: \n Numero de palavras-chave deve ser maior/igual a 1 e menor/igual a 5";
	}

}
