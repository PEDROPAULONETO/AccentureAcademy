package Atividade5;

public class PrincipalAnimais {

    public static void main(String[] args) {

        Gato meuGato = new Gato("Mingau", 3);
        Dog meuDog = new Dog("Pingo", 5);

        System.out.println("O gato faz: ");
        meuGato.emitirSom();
        System.out.println();
        System.out.println("O cachorro faz: ");
        meuDog.emitirSom();

    }
}
