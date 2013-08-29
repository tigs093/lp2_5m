import java.util.Arrays;
import java.util.Scanner;


public class caminhao {
	static int vMapa [] = new int [5];
	static int posicao = 0, combustivel = 6;
	static Scanner ler = new Scanner(System.in);
	
	public void avancar(){
		System.out.println("Você avançou uma posição!");
		posicao++;
		combustivel--;
	}
	
	public void voltar(){
		System.out.println("Você voltou uma posição!");
		posicao--;
		combustivel--;
	}
	
	public void carregar(){
		
		if (combustivel < 6) {
			if (posicao == 0) {
			combustivel++;}
		
		else if (vMapa[posicao] > 0){		
			vMapa[posicao]--;
			combustivel++;
			}		
			
		else System.err.println("Não foi possível carregar.");
		
		}else System.out.print("O tanque já está cheio!\n");
	}
		
	public void descarregar(){
		
		if (posicao > 0) { 
			System.out.println("Você descarregou 1 unidade de combustível!");
			vMapa[posicao]++;
			combustivel--; }
		else System.err.println("Você não pode descarregar na posição inicial.");
	}
	
	public void status(){
		System.out.print("Você está na posição: "+posicao+" E possui "+combustivel+" unidades de combustível.\n");
		System.out.println(Arrays.toString(vMapa));
	
	}

	public boolean jogoAcabou(){
		boolean jogo = false;
		if (posicao == 9 || combustivel == 0) {
			jogo = true;
		
		System.out.println("Fim de Jogo!");
		System.exit(0);
		}
		return jogo;
	}
	
	public boolean venceJogo(){
		return posicao == 9 ? true : false;
		
	}
}
