//Thais de Souza Rodrigues

#include <stdio.h>
#include <string.h>

void atendimento(int funcionarios,int* tempoFunc,int clientes,int* itensClient) {
	int atendendo[funcionarios];
	int maior = -1;
	memset(atendendo,-1,sizeof(atendendo));

	for(int i = 0; i < clientes;i++) { 
		if(i < funcionarios) { //Se os clientes forem menores que os funcionarios, eles vao para os primeiros caixas em ordem do i
			atendendo[i] = tempoFunc[i] * itensClient[i];
			itensClient[i] = 0;
		}
		else { //Se a quantidade de clientes passar o de funcionarios
			int menor = 1000001;
			int func;
			for(int j = 0; j < funcionarios;j++) { //Ele vai procurar o menor tempo do atendimento(porque eh o que acabou mais cedo o atendimento)
				if(atendendo[j] < menor) {
					menor = atendendo[j];
					func = j;
				}
			}
			atendendo[func] = menor + (tempoFunc[func] * itensClient[i]);
			itensClient[i] = 0;
		}
	}
	for(int i = 0; i < funcionarios;i++) if(atendendo[i] > maior) maior = atendendo[i]; //Como eh atendendo "ao mesmo tempo" procuro o que demorou mais
	printf("%i\n",maior);
}

int main() {
	int func,client;
	while(scanf("%i %i",&func,&client) != EOF) {
		int tempoFunc[func];
		int itensClient[client];
		int i;
		for(i = 0; i < func;i++) scanf("%i",&tempoFunc[i]);
		for(i = 0; i < client;i++) scanf("%i",&itensClient[i]);
		atendimento(func,tempoFunc,client,itensClient);
 	}
	return 0;
}
