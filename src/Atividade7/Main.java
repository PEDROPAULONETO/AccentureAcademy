package Atividade7;

public class Main {

    public static void main(String[] args) {

        Casa casa = new Casa();
        Carro carro = new Carro();
        Arvore arvore = new Arvore();
        Pessoa joao = new Pessoa();

        // João mora na casa (estado inicial)

        joao.sairDeCasa(casa);

        joao.entrarNoCarro(carro);

        carro.dirigir();

        carro.ligar(joao.estaDentroDeCasa());

        carro.dirigir();

        System.out.println("João vai até a árvore...");

        joao.sairDoCarro(carro);

        joao.pegarFrutas(arvore);

        joao.entrarNoCarro(carro);

        carro.ligar(joao.estaDentroDeCasa());

        carro.dirigir();

        System.out.println("João chegou em casa...");

        carro.desligar();

        joao.sairDoCarro(carro);

        joao.entrarNaCasa(casa);
    }
}