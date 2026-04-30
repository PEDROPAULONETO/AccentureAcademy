package Atividade5;

public class Dog {

    private String nome;
    private int idade;

    public Dog(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void emitirSom() {
        System.out.println("auau!");
    }
}