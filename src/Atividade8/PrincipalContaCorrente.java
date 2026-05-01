package Atividade8;

public class PrincipalContaCorrente {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("João", "Silva", "123.456.789-00");
        Cliente c2 = new Cliente("Maria", "Oliveira", "987.654.321-11");

        ContaCorrente conta1 = new ContaCorrente(101, c1, 500.0, "30/04/2026");

        System.out.println("Titular da Conta 1: " + conta1.cliente.nome + " " + conta1.cliente.sobrenome);
        System.out.println("--------------------------------");
        System.out.println("Saldo Inicial Conta 1: R$ " + conta1.saldo);
        System.out.println("--------------------------------");

        conta1.depositar(200.0);

        ContaCorrente conta2 = new ContaCorrente(202, c2, 100.0, "30/04/2026");

        conta1.sacar(100.0);

        conta1.transferir(conta2, 800.0);

        conta1.transferir(conta2, 50.0);

        conta1.exibirExtrato();
        conta2.exibirExtrato();
    }
}