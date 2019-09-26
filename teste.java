
import DepartamentoPessoal.Funcionario;
import DepartamentoPessoal.Participantes;
import RecursosDoSistema.Controle;
import RecursosDoSistema.Email;
import RecursosDoSistema.InterfaceDoSistema;
import RepositorioDeDados.BancoDeDados;

public class teste {

	public static void main(String[] args) {
		
		Controle controle1 = new Controle();
		BancoDeDados bd1 = new BancoDeDados();
		Funcionario funcionarioC = null, funcionarioE = null;
		Participantes participante = null;
			
		try {
			participante =  bd1.getPessoaDoBD("Paulo Roberto");
			funcionarioC = (Funcionario) bd1.getPessoaDoBD("Carlos");
			funcionarioE = (Funcionario) bd1.getPessoaDoBD("Carolina Silva");
		} catch (Exception e) {
			System.out.println("Erro funcionario");
		}
		
	
		
		System.out.println(bd1.getPessoal().size());
		
		controle1.emitirAta("Demissao","Paulo,Jose,Joao,Carlos", "demissao de funcionario setor Contabilidade","Contabilidade", "Reuniao para tratar sobre a demissao de metade dos funcionario", "demissao,corte,", funcionarioC );
		
		
	
		
		InterfaceDoSistema ids = new InterfaceDoSistema(bd1);
	
	ids.iniciaSistema();
	}
}
