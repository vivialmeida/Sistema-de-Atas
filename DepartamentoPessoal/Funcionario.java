package DepartamentoPessoal;

import Exce�oes.PalavraChaveException;
import Exce�oes.ParticipantesException;
import RecursosDoSistema.Ata;
import RecursosDoSistema.Email;

public class Funcionario extends Participantes {

	private String setor;

	public Funcionario(String nome, Email email, String setor) {
		super(nome, email);
		this.setor = setor;
	}

	public Ata criarAta(String titulo, String participante, String pauta, String setor, String descricao,
			String palavraChave, Funcionario emissor) throws PalavraChaveException, ParticipantesException {

		Ata ata = new Ata(titulo, participante, pauta, setor, descricao, palavraChave, this);

		return ata;

	}

	public boolean alteraClassificacaoAta(Ata ata, String classificacao) {

		if (this.getNome().equals(ata.getEmissor().getNome())) {

			return ata.alteraClassificacao(classificacao);

		} else {

			System.out.println("Ata s� pode ser alterada pelo emissor");
			return false;
		}

	}

	public boolean alterarEstadoAta(Ata ata, String estado) {

		if (this.getNome().equals(ata.getEmissor().getNome())) {

			return ata.alterarEstadoDaAta(estado);

		} else {
			System.out.println("Ata s� pode ser alterada pelo emissor");
			return false;
		}

	}

	public boolean excluirAta(Ata ata) {

		if (this.getNome().equals(ata.getEmissor().getNome())) {

			ata = null;
			return true;

		} else {

			System.out.println("Ata s� pode ser excluida pelo emissor");
			return false;
		}
	}

	public String consultaAta(Ata ata) {

		StringBuilder sb = new StringBuilder();
		sb.append("Consulta da Ata" + "\n");
		sb.append("Setor da Reuni�o:" + ata.getSetor() + "\n");
		sb.append("Titulo da Reuni�o:" + ata.getTitulo() + "\n");
		sb.append("Data E Hora da Reuni�o: " + ata.getDataEmissao() + " �s " + ata.getInicio() + "." + "\n");
		sb.append("����������������������������������������������������������������������������" + "\n");
		sb.append("Pauta da Reuni�o:" + ata.getPauta() + "\n");
		sb.append("Estado da Ata: " + ata.getEstadoDaAta() + "\n");
		sb.append("Classifica��o da Ata: " + ata.getClassificacao() + "\n");
		sb.append("Local e Data de Emiss�o:  " + "S�o Lu�s - " + ata.getDataEmissao() + "\n");

		return sb.toString();
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String toString() {
		return super.toString() + "\nConvidado \n Setor::" + setor;
	}

}
