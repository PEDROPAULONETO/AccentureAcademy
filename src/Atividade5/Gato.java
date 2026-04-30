package Atividade5;

public class Gato {

    private String nome;
    private int idade;

    public Gato(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void emitirSom() {
        System.out.println("miau!");
    }
}