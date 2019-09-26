package RecursosDoSistema;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import DepartamentoPessoal.Funcionario;
import DepartamentoPessoal.Participantes;
import RepositorioDeDados.BancoDeDados;
import Exceçoes.ParticipantesException;
import Exceçoes.PalavraChaveException;

public class Controle {

	private BancoDeDados bd;
	private RelatorioDoSistema relatorio;

	public Controle() {

		this.bd = new BancoDeDados();
		relatorio = new RelatorioDoSistema();
	}

	public void emitirAta(String titulo, String participante, String pauta, String setor, String descricao,
			String palavraChave, Funcionario emissor) {
		try {

			Ata ata1 = emissor.criarAta(titulo,
					participante, pauta, setor, descricao, palavraChave, emissor);
					
			

		} catch (PalavraChaveException e) {

			System.out.println(e.toString());

		} catch (ParticipantesException b) {

			System.out.println(b.toString());
		} catch (Exception f) {

			System.out.println(f.toString());
		}
	}

	public void exibirAta(String palavraChave, Funcionario funcionario) {
		boolean controleDeExibicao = false;
		if (bd.buscarAta(palavraChave) != null) {

			Ata ata = this.bd.buscarAta(palavraChave);
			if (ata.getClassificacao().equals("publica")) {
				if (ata.getEstadoDaAta().equals("pronta")) {
					System.out.println((ata.toString()));
				} else if (ata.getEstadoDaAta().equals("revisao")) {
					for (Participantes participante : ata.getParticipantes()) {
						if (funcionario.getNome().equals(participante.getNome())) {
							System.out.print(ata.toString());
							controleDeExibicao = true;

						}

					}
					if (controleDeExibicao == false)
						System.out.println("Ata em revisão,só pode ser visualizada pelos menbros da reuniao");
				}
			} else {
				if (funcionario.getNome().equals(ata.getEmissor().getNome())) {
					System.out.println(ata.toString());
				} else {
					System.out.println("Ata esta classificada como privada");
				}

			}
		} else
			System.out.println("Ata não encontrada");

	}

	public void alterarEstadoDaAta(String palavraChave, Funcionario participante, String estadoAta) {
		if (bd.buscarAta(palavraChave) != null) {

			Ata ata = bd.buscarAta(palavraChave);
			try {
				if (participante instanceof Funcionario) {
					Funcionario emissor = (Funcionario) participante;
					emissor.alterarEstadoAta(ata, estadoAta);
					System.out.println("Estado da Ata alterado com sucesso");
					if (estadoAta.equals("revisao")) {
						envioDeAtaPorEmail(ata, "Ata da reuniao:" + ata.getTitulo());
						System.out.println("Email enviado aos membros da reunião! ");
					} else if (estadoAta.equals("pronta")) {
						//gerarBinarioAta;

					}
				} else {
					System.out.println("O estado da ata só pode ser alterado pelo Emissor");
				}

			} catch (Exception e) {
				System.out.println("Estado da Ata não põde ser alterado");
			}
		} else {
			System.out.println("Ata não encontrada no Banco de Dados");
		}
	}

	public void alteraClassificacaoAta(String palavraChave, Participantes participante, String classificacao) {
		if (bd.buscarAta(palavraChave) != null) {
			Ata ata = bd.buscarAta(palavraChave);

			try {
				if (participante instanceof Funcionario) {
					Funcionario emissor = (Funcionario) participante;
					emissor.alteraClassificacaoAta(ata, classificacao);
					System.out.println("Classificação alterada com sucesso!");
				}
			} catch (Exception e) {

				System.out.println("Erro: Classificação não alterada");
			}
		} else {
			System.out.println("Ata não encontrada no Bando de Dados");
		}
	}

	public void registrarSugestao(String palavraChave, Participantes participante, String descricao) {

		if (bd.buscarAta(palavraChave) != null) {
			Ata ata = bd.buscarAta(palavraChave);

			for (Participantes participantes : ata.getParticipantes())
				if (participantes.getNome().equals(participante.getNome())) {
					if (ata.getEstadoDaAta().equals("revisao")) {
						Sugestao sugestao = new Sugestao(ata, descricao, participante);
						participante.adicionarSugestao(ata, sugestao);
						System.out.println("Sugestao registrada na ata");
					} else {
						System.out.println("Ata não esta em revisao no momento");
					}
				}

		} else {
			System.out.println("Ata não encontrada no banco de dados");

		}
	}

	public void buscarParticipanteNoBD(String nome)  {
		try {
			bd.getPessoaDoBD(nome).toString();

		} catch (Exception e) {

			System.out.println("Participante não cadastrado no BD");
		}
	}

	public void envioDeAtaPorEmail(Ata ata, String assunto) {
		for (Participantes participantes : ata.getParticipantes()) {
			participantes.getEmail().receberEmail(assunto, ata.toString());
		}
		try {
			FileOutputStream fos = new FileOutputStream("Email enviado.txt", false);
			PrintWriter pw = new PrintWriter(fos);

			pw.println(ata.toString());
			pw.close();

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		}

	}

	public boolean verificaFuncionario(Participantes participante) throws ParticipantesException {

		if (participante instanceof Funcionario) {

			return true;

		} else {
			throw new ParticipantesException();

		}

	}

	
	
	

}