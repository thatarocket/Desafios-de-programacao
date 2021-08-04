//Thais de Souza Rodrigues
// Desafios de programacao
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int I = input.nextInt();
        int F = input.nextInt();
        int pares = 0;
        input.nextLine();
        
        int[] vetor = new int[N];
        for(int i = 0; i < N; i++) vetor[i] = input.nextInt(); //Coloca os valores dentro do vetor
        
        for(int j = 0; j < N; j++) { //Vai comparar cada valor com outro valor diferente
            for(int k = 0; k < N; k++) {
                if(vetor[j] != vetor[k]) { //Nao pode fazer dupla com si mesmo
                    if((vetor[j] + vetor[k] >= I) && (vetor[j] + vetor[k] <= F)) pares+=1;
                }
            }
        }
        pares = pares/2; // Divide por dois, pois ele analisa duplas de duas formas. Exemplo: (2,3) e (3,2), mas só conta uma representacao
        System.out.println(pares);
    }
}
