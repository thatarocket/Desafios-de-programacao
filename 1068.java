//Thais de Souza Rodrigues
// Desafios de programacao
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        int abreP = 0; // Calcula o (
        int fechaP = 0; // Calcula o )

        while(input.hasNext()) { //Enquanto tiver expressões
            String frase = input.nextLine();
            char[] fraseChar = frase.toCharArray();
            for(int i = 0; i < frase.length(); i++) {
                if (fraseChar[i] == '(') abreP++;
                else if(fraseChar[i] == ')') fechaP++;  
                if(fechaP > abreP) break; // Pode acontecer de ter um fecha parenteses, sem ter um abre parenteses
            } 
            if(abreP == fechaP) System.out.println("correct");
            else System.out.println("incorrect");
            abreP = 0;
            fechaP = 0;
        } 
    }
}
