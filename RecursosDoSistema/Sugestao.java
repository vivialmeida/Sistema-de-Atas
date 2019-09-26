package RecursosDoSistema;
import java.sql.Date;

import AcessoriosDoSistema.DataHora;
import DepartamentoPessoal.Participantes;

public class Sugestao {
	
	private Ata ata;
	private String descricao;
	private String data;
	private Participantes participanteSugestor;
	
	public Sugestao(Ata ata, String descricao, Participantes participanteSugestor) {
		DataHora dataAtual = new DataHora();
		this.ata = ata;
		this.descricao = descricao;
		this.data = dataAtual.registraData();
		this.participanteSugestor = participanteSugestor;
		
	}
	
	
	public Ata getAta() {
		return ata;
	}


	public void setAta(Ata ata) {
		this.ata = ata;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getData() {
		return data;
	}


	@Override
	public String toString() {
		return "Sugestão: \n [Ata=" + ata + ", Descricao= \n" + descricao + ", Data= \n" + data + ", Participante Sugestor="
				+ participanteSugestor + "]";
	}


	



	
}
                                                   