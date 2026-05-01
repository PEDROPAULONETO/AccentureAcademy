package Atividade9;

import java.util.Scanner;


public class RelatorioEstudantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno[] alunos = new Aluno[10];
        int contador = 0;
        int totalReal = 0;

        while (contador < 10) {
            System.out.print("\nDigite o nome do aluno (Mínimo 3 caracteres) ou Digite '0' para sair: ");
            String nome = scanner.nextLine();

            String acao = nome.equals("0") ? "SAIR" : (nome.length() < 3 ? "ERRO" : "CONTINUAR");

            switch (acao) {
                case "SAIR":
                    contador = 10;
                    break;

                case "ERRO":
                    System.out.println("Nome inválido! O nome deve ter pelo menos 3 caracteres.");
                    break;

                case "CONTINUAR":
                    double[] n = new double[3];
                    for (int j = 0; j < 3; j++) {
                        boolean ok = false;
                        while (!ok) {
                            try {
                                System.out.print("Nota " + (j + 1) + " (0-100): ");
                                double nota = Double.parseDouble(scanner.nextLine());

                                ok = (nota >= 0 && nota <= 100)? true : false;

                                n[j] = nota;

                            } catch (Exception e) {
                                System.out.println("Entrada inválida! Digite um número entre 0 e 100.");
                                ok = false;
                            }
                        }
                    }
                    alunos[totalReal++] = new Aluno(nome, n[0], n[1], n[2]);
                    contador = (totalReal == 10) ? 10 : contador;
                    break;
            }
        }

        System.out.println((totalReal > 0) ? iniciarRelatorio(alunos, totalReal) : "\nNenhum aluno cadastrado.");
        scanner.close();
    }

    private static String iniciarRelatorio(Aluno[] alunos, int total) {
        exibirEstatisticas(alunos, total);
        return "\n--- Fim do Relatório ---";
    }

    private static void exibirEstatisticas(Aluno[] alunos, int total) {
        double soma = 0, maior = -1, menor = 101;
        int[] situacao = {0, 0, 0};

        System.out.println("\n--- Relatório Individual ---");
        for (int i = 0; i < total; i++) {
            Aluno a = alunos[i];
            System.out.println(a);

            double m = a.getMedia();
            soma += m;

            maior = (m > maior) ? m : maior;
            menor = (m < menor) ? m : menor;

            situacao[0] += a.getStatus().equals("Aprovado") ? 1 : 0;
            situacao[1] += a.getStatus().equals("Recuperação") ? 1 : 0;
            situacao[2] += a.getStatus().equals("Reprovado") ? 1 : 0;
        }

        System.out.println("\n--- Estatística da Turma ---");
        System.out.printf("Média Geral: %.2f | Maior Média: %.2f | Menor Média: %.2f\n", (soma/total), maior, menor);
        System.out.println("Aprovados: " + situacao[0] + " | Recup: " + situacao[1] + " | Reprov: " + situacao[2]);

        System.out.println("\n--- Destaque(s) ---");
        for (int i = 0; i < total; i++) {
            System.out.print((alunos[i].getMedia() == maior)
                    ? "Maior média: " + alunos[i].getNome() + " (Média: " + String.format("%.2f", maior) + ")\n"
                    : "");
        }
    }
}