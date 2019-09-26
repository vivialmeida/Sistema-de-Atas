package RepositorioDeDados;

import Exceçoes.ParticipantesException;

import java.util.HashSet;
import java.util.TreeMap;

import DepartamentoPessoal.Convidado;

import DepartamentoPessoal.Funcionario;
import DepartamentoPessoal.Participantes;
import RecursosDoSistema.Ata;
import RecursosDoSistema.Email;

public class BancoDeDados {

	private HashSet<Participantes>  pessoalCadastrado = new HashSet<Participantes>();
	private TreeMap<String, Ata> atasJaEmitidas = new TreeMap<>();

	Funcionario funcionario1 = new Funcionario("Carlos",
			new Email("joao@gmail.com"), "departamento pessoal");
	Funcionario funcionario2 = new Funcionario("Vanessa",
			new Email("vanessa@gmail.com"), "financeiro");
	Funcionario funcionario3 = new Funcionario("Carolina",
			new Email("carolina@gmail.com"), "contabilidade");
	Funcionario funcionario4 = new Funcionario("Paulo",
			new Email("paulo@gmail.com"), "manutentcao");
	Convidado colaborador1 = new Convidado("Jose",
			new Email("jose@gmail.com"), "Polegar Producoes");
	Convidado colaborador2 = new Convidado("Joao",
			new Email("jb@gmail.com"));

	public BancoDeDados() {

		pessoalCadastrado.add(funcionario1);
		pessoalCadastrado.add(funcionario2);
		pessoalCadastrado.add(funcionario3);
		pessoalCadastrado.add(funcionario4);
		pessoalCadastrado.add(colaborador1);
		pessoalCadastrado.add(colaborador2);

	}

	public HashSet<Participantes> getPessoal() {

		HashSet<Participantes> copia = new HashSet<Participantes>();

		for (Participantes participante : pessoalCadastrado) {

			copia.add(participante);
		}

		return copia;

	}
	public void adicionarParticipantesNoBD(Participantes participante) {

		try {
			if (this.getPessoaDoBD(participante.getNome()) != null) {
				this.pessoalCadastrado.add(participante);

			}
		} catch (Exception e) {
			System.out.println("Erro: Participante ja se encontra no cadastro");
		}

	}

	public Participantes getPessoaDoBD(String nome)
			throws ParticipantesException {

		for (Participantes participante : pessoalCadastrado) {
			
			String nomePessoaBD = participante.getNome();

			if (nome.equals(nomePessoaBD)) {
	
				return participante.getParticipante(nome);
				 
			}
		}

		throw new ParticipantesException();
		
	}
	public void adicionarAtaNoBD(String strData, Ata ata) {

		// if (this.buscarAta(ata.getPalavraChave().) != null) {
		this.atasJaEmitidas.put(strData, ata);
	}

	public Ata buscarAta(String palavraChave) {
		Ata ata = null;
		try {
			for (String data : this.atasJaEmitidas.keySet()) {
				for (String palavra : this.atasJaEmitidas.get(data).getPalavraChave()) {
					if (palavra.equals(palavraChave)) {
						ata = atasJaEmitidas.get(data);
						return ata;

					}

				}
			}
		} catch (Exception e) {
			System.out.println("Ata não encontrada");
		}

		return ata;
	}

	public void excluirAta(String palavraChave, Participantes emissor) {

		if (this.buscarAta(palavraChave) != null) {

			Ata ata = this.buscarAta(palavraChave);

			for (String data : this.atasJaEmitidas.keySet()) {
				Ata ataAux = this.atasJaEmitidas.get(data);
				if (ataAux.equals(ata)) {

					if (emissor.excluirAta(ataAux)) {
						this.atasJaEmitidas.remove(ataAux);
					} else {
						System.out.println("Erro: Ata não excluida");
					}
				}

			}

		} else {

			System.out.println("Ata não encontrada");
		}
	}

	@SuppressWarnings("unchecked")
	public TreeMap<String, Ata> getAtasDoBD() {

		TreeMap<String, Ata> copiaAtasDoBD = new TreeMap<String, Ata>();
		copiaAtasDoBD = (TreeMap<String, Ata>) atasJaEmitidas.clone();
		return copiaAtasDoBD;
	}

}
