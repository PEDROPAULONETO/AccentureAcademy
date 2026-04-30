package Atividade3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NumerosInteiros2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int saoPares = 0;
        ArrayList<Integer> numerosPares = new ArrayList<>();


        System.out.print("Quantos números você deseja digitar: ");
        int quantidadeDeNumeros = input.nextInt();


        int[] numeros = new int[quantidadeDeNumeros];


        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Entre com a posição %d: ", i + 1);
            numeros[i] = input.nextInt();

            switch (numeros[i] % 2) {
                case 0:
                    saoPares++;
                    numerosPares.add(numeros[i]);
                    break;
            }
        }

        System.out.println();

        switch (numeros.length) {
            case 1:
                System.out.println("O número digitado é: " + Arrays.toString(numeros));
                break;
            default:
                System.out.println("Os números digitados são: " + Arrays.toString(numeros));
                break;
        }

        switch (saoPares) {
            case 1:
                System.out.println("A quantidade de numeros pares é " + saoPares + ".");
                System.out.println(numerosPares + " é um numero par");
                break;
            default:
                System.out.println("Desses números apenas " + saoPares + " são pares.");
                System.out.println("Os numeros pares são: " + numerosPares);
                break;
        }

        input.close();
    }
}