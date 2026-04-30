package Atividade6;
public class CarroPrincipal {

    public static void main(String[] args) {

        Carro meuCarro = new Carro("Toyota", "Vermelho", 75000.00);

        meuCarro.exibir();

        meuCarro.movimentar();

        meuCarro.ligar();

        meuCarro.movimentar();

        meuCarro.buzinar();
    }
}