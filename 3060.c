// Thais de Souza Rodrigues
// Desafios de programação I
#include <stdio.h>

int main() {
    int valorCompra;
    int parcelas;
    int divisao;
    int resto;

    scanf("%i",&valorCompra);
    scanf("%i",&parcelas);

    if(valorCompra % parcelas == 0) {
        for(int i = 0; i < parcelas; i++) {
            divisao = valorCompra / parcelas;
            printf("%i\n",divisao);
        }
    }
    else {
        resto = valorCompra % parcelas;
        divisao = valorCompra / parcelas;
        for(int i = 0; i < resto; i++) printf("%i\n", divisao+1);
        parcelas = parcelas - resto; 
        for(int j = 0; j < parcelas; j++) printf("%i\n",divisao);
    }
    return 0;
}
