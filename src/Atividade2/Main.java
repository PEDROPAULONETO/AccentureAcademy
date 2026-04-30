package Atividade2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Menu Calculadora ---");
            System.out.println("1. Somar");
            System.out.println("2. Subtrair");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao == 0) break;

            System.out.print("Digite o primeiro número : ");
            int x = scanner.nextInt();
            System.out.print("Digite o segundo número : ");
            int y = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Resultado da Soma: " + add(x, y));
                    break;
                case 2:
                    System.out.println("Resultado da Subtração: " + subtract(x, y));
                    break;
                case 3:
                    System.out.println("Resultado da Multiplicação: " + multiply(new int[]{x, y}));
                    break;
                case 4:
                    System.out.println("Resultado da Divisão: " + divide(x, y));
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    private static int add(int x, int y) {
        return x + y;
    }

    private static int subtract(int x, int y) {
        int diff = 0;
        if (x > y) {
            diff = x - y;
        } else {
            diff = y - x;
        }
        return diff;
    }

    private static int multiply(int[] numbers) {
        int temp = 1;
        for (int i = 0; i < numbers.length; i++) {
            temp = temp * numbers[i];
        }
        return temp;
    }

    private static int divide(int x, int y) {
        int divValue = 0;
        // Evita divisão por zero
        if (x == 0 || y == 0) {
            divValue = 0;
            System.out.println("Aviso: Operação com zero resulta em 0.");
        } else {
            divValue = x / y;
        }
        return divValue;
    }
}