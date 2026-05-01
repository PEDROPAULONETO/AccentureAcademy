package Atividade10;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    public enum Status { CREATED, RESERVED, PAID, FAILED, CANCELLED }

    private String id;
    private Cliente cliente;
    private Map<Produto, Integer> itens;
    private Status status;
    private double total;

    public Pedido(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.itens = new HashMap<>();
        this.status = Status.CREATED;
        this.total = 0;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        itens.put(produto, quantidade);
        total += produto.getPreco() * quantidade;
    }

    public String getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Map<Produto, Integer> getItens() {
        return itens;
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return String.format("Pedido ID: %s | Cliente: %s | Total: R$%.2f | Status: %s", 
            id, cliente.getNome(), total, status);
    }
}
