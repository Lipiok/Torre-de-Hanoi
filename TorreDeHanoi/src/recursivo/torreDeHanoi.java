package recursivo;

import java.util.Scanner;

public class torreDeHanoi {

	// imprime o movimento do disco
	private static void mover(int O, int D) {
		System.out.println(O + "-->" + D);
	}

	// metodo da recursão
	static void hanoi(int n, int O, int D, int T) {

		if (n > 1) {
			hanoi(n - 1, O, T, D);
			mover(O, D);
			hanoi(n - 1, O, T, D);
		}

	}
	
	//executando o codigo
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n; // numero de discos 
		
		System.out.println("Digite o numero de discos: ");
		n = in.nextInt();
		
		//executa o hanoi
		torreDeHanoi.hanoi(n, 1, 2, 3);
		
		
	}

}
