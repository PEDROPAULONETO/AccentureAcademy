package Atividade10;

public class Produto {
    private String sku;
    private String nome;
    private String categoria;
    private double preco;
    private int estoque;
    private int vendidos;

    public Produto(String sku, String nome, String categoria, double preco, int estoque) {
        this.sku = sku;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.estoque = estoque;
        this.vendidos = 0;
    }

    public String getSku() {
        return sku;
    }
    public String getNome() {
        return nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public double getPreco() {
        return preco;
    }
    public int getEstoque() {
        return estoque;
    }
    public int getVendidos() {
        return vendidos;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    public void addVendidos(int quantidade) {
        this.vendidos += quantidade;
    }

    @Override
    public String toString() {
        return String.format("SKU: %s | Nome: %s | Cat: %s | Preço: R$%.2f | Estoque: %d", 
            sku, nome, categoria, preco, estoque);
    }
}
