package RecursosDoSistema;

import java.util.Scanner;

import DepartamentoPessoal.Funcionario;
import DepartamentoPessoal.Participantes;
import Exceçoes.ParticipantesException;
import RepositorioDeDados.BancoDeDados;

public class InterfaceDoSistema {
	Controle controle = new Controle();
	BancoDeDados meubd;

	int numero;
	int opcao;

	public InterfaceDoSistema(BancoDeDados bd) {
		BancoDeDados meubd = bd;

	}

	public void iniciaSistema() {

		opcao = this.getOpcao();
		while (opcao != 9) {
			switch (opcao) {

			case 1:
				try {
					Funcionario funcionario = null;
					Participantes participante = meubd
							.getPessoaDoBD(getStr("Nome Funcionário Emissor: "));
					if (controle.verificaFuncionario(participante)) {
						funcionario = (Funcionario) participante;
					}

				 
					controle.emitirAta(
							getStr("Título da Reuniao"),
							getStr("o nome dos participantes da reuniao separados por ,"),
							getStr("Pauta da Reuniao"),
							getStr("Setor de organizacao da reuniao"),
							getStr ("Descricao"),
							getStr("as Palavras-Chave separadas por ,"), funcionario);
							
							
				} catch (ParticipantesException e) {
					System.out.println(e.toString());

				} catch (Exception f) {
					System.out.println("Ocorreu um erro: Ata não Criada");

				}
				break;

			case 2:
				try {
					Funcionario funcionario = null;
					Participantes participante = meubd.getPessoaDoBD(getStr("Nome do emissor"));
					if (controle.verificaFuncionario(participante)) {
						funcionario = (Funcionario) participante;
					}

					controle.exibirAta(getStr("Palavra Chave"), funcionario);
				} catch (ParticipantesException e) {
					System.out.println(e.toString());
				}
				break;

			case 3:

				try {
					Funcionario funcionario = null;
					Participantes participante = meubd.getPessoaDoBD(getStr("Nome Funcionário Emissor: "));
					if (controle.verificaFuncionario(participante)) {
						funcionario = (Funcionario) participante;
					}

					controle.exibirAta(getStr("uma Palavras-Chave para a busca"), funcionario);

				} catch (ParticipantesException e) {
					System.out.println(e.toString());

				}

				break;

			case 5:
				try {
					Funcionario funcionario = null;
					Participantes participante = meubd.getPessoaDoBD(getStr("Nome Funcionário Emissor: "));
					if (controle.verificaFuncionario(participante)) {
						funcionario = (Funcionario) participante;
					}
					controle.alterarEstadoDaAta(getStr("Palavras-Chave para a busca"), funcionario,
							getStr("Estado da Ata:"));
				} catch (ParticipantesException e) {
					System.out.println(e.toString());

				}

				break;

			case 6:

				try {
					Participantes participante;
					participante = meubd.getPessoaDoBD(getStr("Nome Participante: "));
					controle.registrarSugestao(getStr("uma Palavras-Chave para a busca"), participante,
							getStr("Descrição da Sugestao: "));
				} catch (Exception e) {
					System.out.println(e.toString());

				}
				break;

			case 7:

				try {
					Funcionario funcionario = null;
					Participantes participante = meubd.getPessoaDoBD(getStr("Nome Funcionário Emissor: "));
					if (controle.verificaFuncionario(participante)) {
						funcionario = (Funcionario) participante;
					}
					controle.exibirAta(getStr(" Palavras-Chave para a busca"), funcionario);
				} catch (ParticipantesException e) {
					System.out.println(e.toString());

				}

		
				break;

			}

			opcao = getOpcao();

		}
	}

	private int getOpcao() {

		do {
			opcao = getInt(
					" Digite 1 para criar Ata, 2 para excluir Ata, 3 para exibir Ata, 4  Altera Classificação da Ata, 5 Altera estado da Ata, 6 realizar sugestao, 7 Consultar Ata,  8 - Gerar relatório do sitema e 9 - Sair");
			if (opcao != 1 & opcao != 2 & opcao != 3 & opcao != 4 & opcao != 5 & opcao != 6 & opcao != 7 & opcao != 8
					& opcao != 9) {
				opcao = 0;
			}

		} while (opcao == 0);
		return opcao;
	}

	private int getInt(String string) {

		Scanner r = new Scanner(System.in);

		System.out.println("Entre com " + string);

		if (r.hasNextInt()) {
			return r.nextInt();
		}
		String st = r.next();
		System.out.println("Erro na Leitura de Dados");

		return 0;
	}

	private String getStr(String string) {

		try {

			Scanner s = new Scanner(System.in);

			System.out.println("Entre com " + string);

			return s.nextLine();

		} catch (Exception e) {
			System.out.println("Erro na Leitura de Dados");
			return null;
		}
	}
}
