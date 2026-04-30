package Atividade7;

public class Pessoa {


private boolean dentroDeCasa = true;
private boolean dentroDoCarro = false;

public boolean estaDentroDeCasa() {
    return dentroDeCasa;
}

public void sairDeCasa(Casa casa) {
    casa.sair();
    dentroDeCasa = false;
}

public void entrarNaCasa(Casa casa) {
    casa.entrar();
    dentroDeCasa = true;
    dentroDoCarro = false;
}

public void entrarNoCarro(Carro carro) {
    if (!dentroDeCasa) {
        carro.entrar();
        dentroDoCarro = true;
    } else {
        System.out.println("João precisa sair de casa primeiro.");
    }
}

public void sairDoCarro(Carro carro) {
    carro.sair();
    dentroDoCarro = false;
}

public void pegarFrutas(Arvore arvore) {
    if (!dentroDoCarro) {
        arvore.pegarFrutas();
    } else {
        System.out.println("João precisa sair do carro para pegar frutas.");
    }
}
}