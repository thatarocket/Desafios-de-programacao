// Thais de Souza Rodrigues
java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int casos = 0;
		while(input.hasNext()) {
			casos = input.nextInt();
			input.nextLine();
			for(int i = 0; i < casos;i++) {
				String frase = input.nextLine();
				contaFrase(frase);
			}
		}
	}

	public static void contaFrase(String frase) {
		char[] separado = frase.toCharArray();
		char letra = 'a';
		int cont = 0;

		for(int j = 0; j < separado.length;j++) {
			for(int i = 0; i < separado.length;i++) {
				if(separado[i] == letra) {
					cont++;
					break;
				}
			}
			letra = (char) (letra+1);
		}
		if(cont == 26) System.out.println("frase completa");
		else if(cont >= 13 && cont < 26) System.out.println("frase quase completa");
		else System.out.println("frase mal elaborada");
	}
}
