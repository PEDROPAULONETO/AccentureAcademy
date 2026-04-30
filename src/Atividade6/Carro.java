package Atividade6;

public class Carro {

    private String marca;
    private String codigoCor;
    private double preco;
    private boolean ligado;
    private boolean emMovimento;

    public Carro(String marca, String codigoCor, double preco) {
        this.marca = marca;
        this.codigoCor = codigoCor;
        this.preco = preco;
        this.ligado = false;
        this.emMovimento = false;
    }

    public void exibir() {
        System.out.println("Marca: " + marca);
        System.out.println("Código da Cor: " + codigoCor);
        System.out.println("Preço: " + preco);
    }

    public void ligar() {
        ligado = true;
        System.out.println("Carro ligado.");
    }

    public void movimentar() {
        if (ligado) {
            emMovimento = true;
            System.out.println("Carro em movimento.");
        } else {
            System.out.println("Não é possível movimentar. O carro está desligado.");
        }
    }

    public void buzinar() {
        if (emMovimento) {
            System.out.println("Bip Bip!");
        } else {
            System.out.println("Não é possível buzinar. O carro está parado.");
        }
    }
}
