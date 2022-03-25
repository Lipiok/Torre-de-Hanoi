package interativo;

import java.util.Scanner;
import java.util.Stack;

public class hanoiInterativo {
	
	// linha para substituir a chamada recursiva
	private static Stack<String> pilha = new Stack<String>();
	
	//armazena o movimento atual
	
	private static long numMov;
	
	//metodo que ira realizar(imprimir) o movimento do disco entre dois pinos
	
	private static void mover(int O, int D){
		numMov++;
		System.out.println("[" + numMov + "]:" + O + "-->" + D);
	}
	
	//metodo interativo
	public static void hanoi(int n){
		
		int O = 1; //origem
		int D = 3; //destino
		int T = 2; //trabalho
		
		//movimentando o disco
		String comandoAtual = n + "," + O + "," + D + "," + T;
		
		pilha.push(comandoAtual);
		
		//condição para o final do jogo
		while(!pilha.empty()){
			if(n > 1){
				// novo compando pra ser empilhado
				n--;
				String[] vetAux = comandoAtual.split(",");
				
				O = Integer.parseInt(vetAux[1]);
				D = Integer.parseInt(vetAux[2]);
				T = Integer.parseInt(vetAux[3]);
				
				comandoAtual = n + "," + O + "," + D + "," + T;
				
				//empilha o comando de novo
				pilha.push(comandoAtual);
				
				//caso não desempilha
				
			}else{
				//desempilha um comando
				comandoAtual = pilha.pop();
				
				//separa n, origem, destino e trabalho
				String[] vetAux = comandoAtual.split(",");
				
				n = Integer.parseInt(vetAux[0]);
				O = Integer.parseInt(vetAux[1]);
				D = Integer.parseInt(vetAux[2]);
				T = Integer.parseInt(vetAux[3]);
				
				mover(O, D);
				
				if(n > 1){
					n--;
					comandoAtual = n + "," + O + "," + D + "," + T;
					pilha.push(comandoAtual);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); //habilitando interação do usuario 
		int n; // numero de discos
				
		System.out.println("digite o numero de discos: ");
		n = in.nextInt();
		
		hanoiInterativo.hanoi(n);
	}

}
