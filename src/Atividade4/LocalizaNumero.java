package Atividade4;

public class LocalizaNumero {
    public static void main(String[] args) {

        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numero = 8;
        boolean achou = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == 8) {
                achou = true;
                numero = i;

            }
        }

        if (achou) {
            System.out.println("Achei");
            System.out.printf("Na posição %d está localizado do numero %d", numero, vetor[numero]);
        }
    }
}