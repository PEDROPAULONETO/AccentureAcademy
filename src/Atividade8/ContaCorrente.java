package Atividade8;

public class ContaCorrente {
    public int numero;
    public Cliente cliente;
    public double saldo;
    public String data;

    public ContaCorrente(int numero, Cliente cliente, double saldo, String data) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
        this.data = data;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado --- Saldo atual: R$ " + this.saldo);
        System.out.println("--------------------------------");
    }

    public boolean sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado. Saldo atual: R$ " + this.saldo);
            System.out.println("--------------------------------");
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque.");
            System.out.println("--------------------------------");
            return false;
        }
    }

    public void exibirExtrato() {
        System.out.println("\n--- Extrato ---");
        System.out.println("Cliente: " + cliente.nome + " " + cliente.sobrenome);
        System.out.println("Conta: " + numero + " | Data: " + data);
        System.out.println("Saldo: R$ " + saldo);
    }

    public void transferir(ContaCorrente destino, double valor) {
        System.out.println("Iniciando Pix de R$ " + valor + " para " + destino.cliente.nome + "...");
        System.out.println("--------------------------------");
        if (this.saldo - valor < 0) {
            System.out.println("PIX CANCELADO: Saldo insuficiente (a conta ficaria negativa).");
            System.out.println("--------------------------------");
        } else {
            this.saldo -= valor;
            destino.saldo += valor;
            System.out.println("Pix realizado com sucesso!");
            System.out.println("Saldo atual " + this.cliente.nome + ": R$ " + this.saldo);
        }
    }
}
