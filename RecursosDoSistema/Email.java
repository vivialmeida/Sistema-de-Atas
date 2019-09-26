package RecursosDoSistema;

import java.util.TreeMap;

public class Email {
	
	private String endere�odeEmail;
	private TreeMap <String,String> emailsRecebidos;
	
	
	public Email(String endere�odeEmail) {
		this.endere�odeEmail = endere�odeEmail;
		this.emailsRecebidos =  new TreeMap<>();
	}
	
	public void receberEmail(String assunto, String texto) {
		this.emailsRecebidos.put(assunto, texto);
	}

	public String getEndere�odeEmail() {
		return endere�odeEmail;
	}

	public void setEndere�odeEmail(String endere�odeEmail) {
		this.endere�odeEmail = endere�odeEmail;
	}

	public TreeMap<String, String> getEmailsRecebidos() {
		return emailsRecebidos;
	}

	@Override
	public String toString() {
		return "Email [endere�odeEmail= " + endere�odeEmail + ", emailsRecebidos= " + emailsRecebidos + "]";
	}

	
	
}
