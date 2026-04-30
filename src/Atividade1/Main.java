package Atividade1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int precoClasseA = 50;
        int precoClasseB = 30;
        int precoClasseC = 20;

        System.out.print("Quantidade de ingressos vendidos na Classe A: ");
        int qtdA = scanner.nextInt();

        System.out.print("Quantidade de ingressos vendidos na Classe B: ");
        int qtdB = scanner.nextInt();

        System.out.print("Quantidade de ingressos vendidos na Classe C: ");
        int qtdC = scanner.nextInt();

        int rendaTotal = (qtdA * precoClasseA) + (qtdB * precoClasseB) + (qtdC * precoClasseC);

        System.out.println("\n--- Total de Vendas ---");
        System.out.println("Renda da Classe A: R$" + (qtdA * precoClasseA));
        System.out.println("Renda da Classe B: R$" + (qtdB * precoClasseB));
        System.out.println("Renda da Classe C: R$" + (qtdC * precoClasseC));
        System.out.println("------------------------");
        System.out.println("Renda Total Gerada: R$" + rendaTotal);

        scanner.close();
    }
}