package Atividade9;

class Aluno {
    private String nome;
    private double[] notas;

    public Aluno(String nome, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.notas = new double[]{nota1, nota2, nota3};
    }

    public String getNome() {

        return nome;
    }
    public double getMedia() {

        return (notas[0] + notas[1] + notas[2]) / 3.0;
    }

    public String getStatus() {
        double m = getMedia();
        return (m >= 70) ? "Aprovado" : (m >= 50 ? "Recuperação" : "Reprovado");
    }

    @Override
    public String toString() {
        return String.format("Aluno: %s | Média: %.2f | Status: %s", nome, getMedia(), getStatus());
    }
}