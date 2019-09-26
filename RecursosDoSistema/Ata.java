package RecursosDoSistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import AcessoriosDoSistema.DataHora;
import DepartamentoPessoal.Funcionario;
import DepartamentoPessoal.Participantes;
import Exceçoes.PalavraChaveException;
import Exceçoes.ParticipantesException;
import RepositorioDeDados.BancoDeDados;

public class Ata {
	private String titulo;
	private String dataEmissao;
	private HashSet<Participantes> participantes;
	private String inicio;
	private String termino;
	private String pauta;
	private String setor;
	private String descricao;
	private HashSet<String> PalavraChave;
	private Funcionario emissor;
	private String classificacao;
	private String estadoDaAta;
	private HashMap<String, Sugestao> SugestoesParaAta;

	public Ata(String titulo, String participante, String pauta, String setor, String descricao,
			String palavraChave, Funcionario emissor) throws ParticipantesException{
		DataHora data = new DataHora();
		DataHora inicio = new DataHora();
		this.titulo = titulo;
		this.dataEmissao = data.registraData();
		this.participantes = new HashSet<>();
		this.adicionaParticipantes(participante);
		this.inicio = inicio.registraHora();
		this.pauta = pauta;
		this.setor = setor;
		this.descricao = descricao;
		this.PalavraChave = new HashSet<String>();
		this.PalavraChave.add(palavraChave);
		this.emissor = emissor;
		this.classificacao = "privada";
		this.estadoDaAta = "Pre-emitidas";

	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getEstadoDaAta() {
		return estadoDaAta;
	}

	public Object getSugestoesParaAta() {
		return SugestoesParaAta.clone();
	}

	public void adicionarSugestao(Sugestao sugestao) {

		this.SugestoesParaAta.put(sugestao.getData(), sugestao);

	}

	public String getTitulo() {
		return titulo;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public void setParticipantes(HashSet<Participantes> participantes) {
		this.participantes = participantes;
	}

	public void setInicio(String string) {
		this.inicio = string;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public void setEmissor(Funcionario emissor) {
		this.emissor = emissor;
	}

	public HashSet<Participantes> getParticipantes() {
		return participantes;
	}

	public String getPauta() {
		return pauta;
	}

	public Funcionario getEmissor() {
		return emissor;
	}

	public String getInicio() {
		return inicio;
	}

	public String getTermino() {
		return termino;
	}

	public HashSet<String> getPalavraChave() {
		return PalavraChave;
	}

	public void adicionaPalavraChave(String palavraChave) throws PalavraChaveException {

		StringTokenizer st = new StringTokenizer(palavraChave, ",");

		while (st.hasMoreTokens()) {

			String palavrasChave = st.nextToken();

			if (this.PalavraChave.size() < 5) {
				this.PalavraChave.add(palavraChave);
			} else if (palavraChave.isEmpty()) {

				throw new PalavraChaveException();

			}
		

	}
	}

	public boolean alterarEstadoDaAta(String estadoDaAta) {
		if (estadoDaAta.equalsIgnoreCase("emitida") || estadoDaAta.equalsIgnoreCase("revisao")) {
			this.classificacao = estadoDaAta;
			return true;
		}

		return false;
	}

	public boolean alteraClassificacao(String classificaco) {
		if (classificacao.equalsIgnoreCase("privada") || classificacao.equalsIgnoreCase("privada")) {
			this.classificacao = classificacao;
			return true;
		}
		return false;
	}

	public void adicionaParticipantes(String nome)  throws  ParticipantesException{


			BancoDeDados bd = new BancoDeDados();
			StringTokenizer st = new StringTokenizer(nome, ",");

			while (st.hasMoreTokens()) {

				String nomeParticipante = st.nextToken();

			}


	 
	if (this.participantes.size() < 2) {
		throw new  ParticipantesException();
	}
}

	@Override
	public String toString() {
		return "--------------------Informaçoes sobre Ata ------------------------ \n[Titulo da Reuniao: " + titulo
				+ "\n Data de Emissao da Ata: " + dataEmissao + "\n Participantes da Reuniao: " + participantes
				+ "\n Inicio da Reunião: " + inicio + "\n Término da Reuniao: " + termino + "\n Pauta: " + pauta
				+ "\n Setor: " + setor + "\n Descricao: " + descricao + "\n Palavras Chave: " + PalavraChave
				+ "\n Emissor da Ata: " + emissor + "\n Classificacao da Ata: " + classificacao + "\n EstadoDaAta: "
				+ estadoDaAta + "\n Sugestoes Para a Ata: " + SugestoesParaAta + "]";
	}

}
