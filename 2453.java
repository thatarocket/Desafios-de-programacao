//Thais de Souza Rodrigues 

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) { //Enquanto receber entrada, execute
			String recebido = input.nextLine();
			decodificar(recebido);
		}
	}

	public static void decodificar(String frase) {

		char[] palavras = frase.toCharArray(); //Pega a frase recebida e a separa em caracteres
		String fraseFinal = ""; //A String final composta pela frase decodificada

		for(int i = 0; i < palavras.length;i++) {
			if(palavras[i] == ' ') { //Os espaços nao sao antecedidos do p, logo ja adiciona na frase
				fraseFinal += String.valueOf(palavras[i]); 
			}
			else if(palavras[i] == 'p' || palavras[i] == 'P') { //O p antecede os caracteres da frase
				i++; //Como o p tambem antecede o p que acrescenta a frase, eh necessario passar para o proximo caractere
				fraseFinal += String.valueOf(palavras[i]); // para depois adicionar
			}
		}

		System.out.println(fraseFinal);
	}
}
