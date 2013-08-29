import java.util.Scanner;

public class principal {
	/**
	 * Thiago Moraes
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		caminhao ca = new caminhao(); //classe caminhao instanciada
		Scanner ler = new Scanner(System.in); //inicializacao do scanner
		String escolha;		
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("TRAVESSIA DO DESERTO! \n"
				+ "Regras:\n" + " - O jogador controla o caminhão através dos comandos: avancar, voltar, carregar e descarregar.\n"
				+ " - Cada vez que o caminhão move, ele gasta uma unidade de combustível e anda uma unidade de distância.\n"
				+ " - Na posição inicial do mapa existe um estoque infinito de combustível.\n"
				+ " - O jogador pode descarregar combustível do caminhão, que ficará depositado na posição do mapa onde o caminhão se encontra.\n"
				+ " - O jogador pode, a qualquer momento carregar uma unidade de combustível para o caminhão, desde que exista uma unidade de combustível disponível \n na posição onde o mesmo se encontra.\n"
				+ " - O jogo acaba quando o caminhão chegar na última posição do mapa (caso em que o jogador ganha), ou quando o caminhão ficar sem combustível \n e não puder ser recarregado.\n");		

		System.out.println("VAMOS COMEÇAR!!!\n");
		
		System.out.println("Você está na posição "+ca.vMapa[ca.posicao]+". Aqui você pode: carregar ou avancar. Digite a opção desejada! ");
		escolha = ler.next();
		
		switch(escolha){ 
		case "avancar": ca.avancar();
		break;
		case "carregar": ca.carregar();
		break;
		case "status": ca.status();
		break;
		case "voltar": System.out.println("Você não pode voltar!");
		break;
		case "descarregar": System.out.println("Você não pode descarregar!");
		break;
		}

		do {
			System.out.println("Você pode: avancar, voltar, descarregar ou carregar. Digite a opção desejada! ");
			escolha = ler.next();
		
		switch(escolha){ 
		case "avancar": ca.avancar();
		break;
		case "voltar": ca.voltar();
		break;
		case "carregar": ca.carregar();
		break;
		case "descarregar": ca.descarregar();
		break;
		case "status": ca.status();
			}
		} while (!ca.jogoAcabou());
		
		if (ca.venceJogo()) System.out.println("Parabéns, você venceu!");
		else System.err.println("Você perdeu!");
		ler.close();
	}

}
