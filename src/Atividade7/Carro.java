package Atividade7;

public class Carro {

    private boolean ligado;

    public void entrar() {
        System.out.println("João entrou no carro.");
    }

    public void sair() {
        System.out.println("João saiu do carro.");
    }

    public void ligar(boolean dentroDeCasa) {
        if (dentroDeCasa) {
            System.out.println("Não é possível ligar o carro dentro de casa.");
        } else {
            ligado = true;
            System.out.println("Carro ligado.");
        }
    }

    public void desligar() {
        ligado = false;
        System.out.println("Carro desligado.");
    }

    public void dirigir() {
        if (ligado) {
            System.out.println("Carro em movimento.");
        } else {
            System.out.println("Não é possível dirigir. O carro está desligado.");
        }
    }
}