package DepartamentoPessoal;

import RecursosDoSistema.Email;

public class Convidado extends Participantes {

	private String empresa;

	public Convidado(String nome, Email email, String empresa) {
		super(nome, email);
		this.empresa = empresa;
	}
	
	public Convidado (String nome, Email email) {
		super (nome, email);
	}




	public String getEmpresa() {
		return empresa;
	}

	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nConvidado \n Empresa:" + empresa ;
	}
	

	
	
}

