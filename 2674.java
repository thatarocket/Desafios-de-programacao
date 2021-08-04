//Thais de Souza Rodrigues 
import java.util.Scanner;

public class Main { 

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = -1;
		while(input.hasNext()) {
			num = input.nextInt();
			encontraPrimo(num);
		}
	}

	public static void encontraPrimo(int num) {
		boolean ehPrimo = false;
		boolean superPrimo = false;
		int tam = 0;

		for(int i = 2; i <= num;i++) { //verifica se eh primo, analisando se eh divisivel pelos seus anteriores
			if(num % i == 0 && num != i) {
				ehPrimo = false;
				superPrimo = false;
				break;
			}
			else ehPrimo = true; 
		}

		if(ehPrimo == true) { //Verificar se eh super primo
			char[] caracteres = ("" + num).toCharArray();
			boolean[] verif = new boolean[caracteres.length]; //marca se naquela posicao é primo
			tam = caracteres.length;

			for(int t = 0; t < verif.length;t++) verif[t] = true;

			for(int j = 0; j < caracteres.length;j++) { //verifica cada caractere do primo
				int atual = Integer.parseInt(String.valueOf(caracteres[j]));
				for(int k = 2; k <= atual;k++) { //para cada caractere, verifica se sao primos
					if(atual % k == 0 && k != atual) {
						verif[j] = false;
						break;
					}
				}

			}

			for(int m = 0; m < tam;m++) { //verifica se houve algum caso de um caractere nao ser primo
				if(caracteres[m] == '1' || caracteres[m] == '0') {
					superPrimo = false;
					break;
				}
				else if(verif[m] == false) {
					superPrimo = false;
					break;
				}
				else superPrimo = true;
			}
		}
		if(ehPrimo == false) System.out.println("Nada");
		else if(ehPrimo == true && superPrimo == true) System.out.println("Super");
		else System.out.println("Primo");

	}
}
