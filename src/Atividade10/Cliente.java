package Atividade10;

public class Cliente {
    private String id;
    private String nome;
    private int totalPedidos;

    public Cliente(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.totalPedidos = 0;
    }

    public String getNome() {
        return nome;
    }
    public int getTotalPedidos() {
        return totalPedidos;
    }
    public void incrementarPedidos() {
        this.totalPedidos++;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Nome: %s | Total Pedidos: %d", id, nome, totalPedidos);
    }
}
