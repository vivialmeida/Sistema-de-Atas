package RecursosDoSistema;

import java.util.TreeMap;

public class Email {
	
	private String endereçodeEmail;
	private TreeMap <String,String> emailsRecebidos;
	
	
	public Email(String endereçodeEmail) {
		this.endereçodeEmail = endereçodeEmail;
		this.emailsRecebidos =  new TreeMap<>();
	}
	
	public void receberEmail(String assunto, String texto) {
		this.emailsRecebidos.put(assunto, texto);
	}

	public String getEndereçodeEmail() {
		return endereçodeEmail;
	}

	public void setEndereçodeEmail(String endereçodeEmail) {
		this.endereçodeEmail = endereçodeEmail;
	}

	public TreeMap<String, String> getEmailsRecebidos() {
		return emailsRecebidos;
	}

	@Override
	public String toString() {
		return "Email [endereçodeEmail= " + endereçodeEmail + ", emailsRecebidos= " + emailsRecebidos + "]";
	}

	
	
}
