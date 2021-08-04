// Thais de Souza Rodrigues
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int linha, coluna;

		while(input.hasNext()) {

			linha = input.nextInt();
			coluna = input.nextInt();
			input.nextLine();
			int matriz[][] = new int[linha][coluna];

			for(int i = 0; i < linha; i++) { //Passa os valores para a matriz
				for(int j = 0; j < coluna;j++) matriz[i][j] = input.nextInt();
				input.nextLine();
			}	

			verif(linha,coluna,matriz);
		}
	}

	public static void verif(int linha, int coluna, int[][] matriz) {

		int quantZero = 0;
		boolean tudoZero = false;
		boolean naoEh = false; //Nao eh matriz de escada
		int posicX = -1;
		int posicY = -1;

		for(int i = 0; i < matriz.length;i++) {
			if(naoEh) break;
			for(int j = 0; j < matriz[0].length;j++) {
				if(!tudoZero) {
					if(matriz[i][j] == 0) { //Se nao houve um caso de tudo ser zero
						quantZero++;
					}
				}				
				else {
					if(matriz[i][j] != 0) { //Se houve o caso, nao pode ter nenhum diferente de 0 em baixo
						naoEh = true;
						break;
					}
				}
			}

			if(quantZero == matriz[0].length) tudoZero = true; //TODAS AS LINHAS ABAIXO DEVEM SER ZERO
			quantZero = 0;
		}

		if(!naoEh) {
			for(int i = 0; i < matriz.length;i++) { //Verificar o segundo caso
				if(naoEh) break;
				for(int j = 0; j < matriz[0].length;j++) {
					if(naoEh) break;
					if(matriz[i][j] != 0 && posicX == -1) { //Primeiro a ser visto
						posicX = i;
						posicY = j;
						for(int k = i; k < matriz.length;k++) { //Navega entre as linhas, para verificar
							if(j > 0) if(matriz[k][j-1] != 0) { //Se eh maior que 0, posso olhar o anterior
								naoEh = true; //Coluna da esquerda deve ser igual a 0
								break;
							}
							if(k < matriz.length-1) if(matriz[k+1][j] != 0) {
								naoEh = true; //Todos que estejam em baixo na mesma coluna devem ser 0;
								break;
							}
						}
					}
				}
				posicX = -1;
				posicY = -1;
				if(naoEh) break;
			}
		}

		if(naoEh) System.out.println("N");
		else System.out.println("S");

	}
}
