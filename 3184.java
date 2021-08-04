//Thais de Souza Rodrigues

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
 
public class Main {
 
    public char[][] mapa;
    public boolean[][] andado; 
    public int ouro;
    String caminho = "";
 
 
    public void Inicializa(Main obj) {
        Scanner input = new Scanner(System.in);
        int coluna = input.nextInt(); //largura
        int linha = input.nextInt(); //altura
        input.nextLine();
 
        mapa = new char[linha][coluna];
        andado = new boolean[linha][coluna];
        int posicX = -1;
        int posicY = -1;
        for(int i= 0; i < linha; i++) { //Colocar o que foi recebido numa matriz
            String frase = input.nextLine();
            char[] separado = frase.toCharArray();
            for(int j = 0 ; j < coluna;j++) {
                obj.mapa[i][j] = separado[j];
                if(obj.mapa[i][j] == 'P') {
                    posicX = i;
                    posicY = j;
                    caminho = i+j + "+";
                }
            }
        }
 
        for(int i = 0; i < linha; i++) { //Coloco o valor -1 na matriz de andado
            for(int j = 0; j < coluna; j++) {
                andado[i][j] = true;
            }
        }
 
        obj.mover(posicX,posicY);
        System.out.println(ouro);
    }
 
    public void mover(int posicX,int posicY) {
        if(!andado[posicX][posicY]) return; //Se nao pode mais andar(Repetido)
        if(!posicaoValida(posicX,posicY)) return;
        andado[posicX][posicY] = false; //Coloca que não pode mais andar
        if(mapa[posicX][posicY] == '#') return; //Se tem uma parede
        if(mapa[posicX][posicY] == 'G') ouro++;  //Se tem ouro
        if(mapa[posicX+1][posicY] == 'T') return; //Se tem uma armadilha
	    if(mapa[posicX][posicY+1] == 'T') return; //Se tem uma armadilha
        if(mapa[posicX-1][posicY] == 'T') return; //Se tem uma armadilha
        if(mapa[posicX][posicY-1] == 'T') return; //Se tem uma armadilha
 
        
        
        caminho += posicX+posicY+"+"; //Acrescenta no caminho 
        mover(posicX+1, posicY);
        mover(posicX , posicY+1);
        mover(posicX-1, posicY);
        mover(posicX, posicY-1);
        return;
    }
 
    public boolean posicaoValida(int posicX,int posicY) {
        if(posicX < 0 || posicY < 0) return false;
        if(posicX >= mapa.length || posicY >= mapa[0].length) return false;
        return true;
    }
 
    public static void main(String[] args) {
        Main objeto = new Main();
        objeto.Inicializa(objeto);  
    }

}
 
 
