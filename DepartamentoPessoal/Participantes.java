package DepartamentoPessoal;
import RecursosDoSistema.Ata;
import RecursosDoSistema.Email;
import RecursosDoSistema.Sugestao;

public class Participantes {

	private String nome;
	private Email email;
	
	public Participantes(String nome, Email email) {

		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email; 	
	}


	public Participantes getParticipante(String strNome) {

		Participantes participante = null;

		if (this.nome.equals(strNome)) {

			return this;
		}

		return participante;

	}

public void adicionarSugestao(Ata ata, Sugestao sugestao) {
		
		ata.adicionarSugestao(sugestao);
		
	}

@Override
public String toString() {
	return "Participantes \n Nome:" + nome + "\n Email=" + email;
}

public boolean excluirAta(Ata ataAux) {

	if (this.getNome().equals(ataAux.getEmissor().getNome())) {

		ataAux = null;
		return true;

	} else {

		System.out.println("Ata só pode ser excluida pelo emissor");
		return false;
	}
}
	
}
