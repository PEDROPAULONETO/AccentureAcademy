package Atividade10;

import java.util.*;


public class ECommerceApp {
    private static Map<String, Produto> produtos = new HashMap<>();
    private static Map<String, Cliente> clientes = new HashMap<>();
    private static Map<String, Pedido> pedidos = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int orderCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- E-Commerce CLI ---");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Adicionar Cliente");
            System.out.println("4. Criar Pedido");
            System.out.println("5. Reservar Estoque");
            System.out.println("6. Pagar Pedido");
            System.out.println("7. Cancelar Pedido");
            System.out.println("8. Relatórios");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1": adicionarProduto(); break;
                case "2": listarProdutos(); break;
                case "3": adicionarCliente(); break;
                case "4": criarPedido(); break;
                case "5": gerenciarStatusPedido(Pedido.Status.RESERVED); break;
                case "6": pagarPedido(); break;
                case "7": cancelarPedido(); break;
                case "8": exibirRelatorios(); break;
                case "0": System.exit(0);
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarProduto() {
        System.out.print("SKU: "); String sku = scanner.nextLine();
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Categoria: "); String cat = scanner.nextLine();
        System.out.print("Preço: "); double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Estoque: "); int est = Integer.parseInt(scanner.nextLine());
        produtos.put(sku, new Produto(sku, nome, cat, preco, est));
    }

    private static void listarProdutos() {
        System.out.println("Ordenar por (1) SKU ou (2) Preço?");
        String ord = scanner.nextLine();
        List<Produto> lista = new ArrayList<>(produtos.values());
        if (ord.equals("2")) {
            lista.sort(Comparator.comparingDouble(Produto::getPreco));
        } else {
            lista.sort(Comparator.comparing(Produto::getSku));
        }
        lista.forEach(System.out::println);
    }

    private static void adicionarCliente() {
        System.out.print("ID Cliente: "); String id = scanner.nextLine();
        System.out.print("Nome Cliente: "); String nome = scanner.nextLine();
        clientes.put(id, new Cliente(id, nome));
    }

    private static void criarPedido() {
        System.out.print("ID Cliente: "); String id = scanner.nextLine();
        Cliente cliente = clientes.get(id);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Pedido pedido = new Pedido("PEDIDO-" + (orderCounter++), cliente);
        while (true) {
            System.out.print("SKU do Produto (ou 'fim'): ");
            String sku = scanner.nextLine();
            if (sku.equalsIgnoreCase("fim")) break;
            Produto p = produtos.get(sku);
            if (p != null) {
                System.out.print("Quantidade: ");
                int qtd = Integer.parseInt(scanner.nextLine());
                pedido.adicionarItem(p, qtd);
            } else {
                System.out.println("Produto não encontrado.");
            }
        }
        pedidos.put(pedido.getId(), pedido);
        System.out.println("Pedido criado: " + pedido.getId());
    }

    private static void gerenciarStatusPedido(Pedido.Status novoStatus) {
        System.out.print("ID Pedido: "); String id = scanner.nextLine();
        Pedido p = pedidos.get(id);
        if (p == null) return;

        if (novoStatus == Pedido.Status.RESERVED) {
            for (Map.Entry<Produto, Integer> item : p.getItens().entrySet()) {
                if (item.getKey().getEstoque() < item.getValue()) {
                    System.out.println("Estoque insuficiente para " + item.getKey().getNome());
                    p.setStatus(Pedido.Status.FAILED);
                    return;
                }
            }
            for (Map.Entry<Produto, Integer> item : p.getItens().entrySet()) {
                Produto prod = item.getKey();
                prod.setEstoque(prod.getEstoque() - item.getValue());
            }
            p.setStatus(Pedido.Status.RESERVED);
            System.out.println("Estoque reservado.");
        }
    }

    private static void pagarPedido() {
        System.out.print("ID Pedido: "); String id = scanner.nextLine();
        Pedido p = pedidos.get(id);
        if (p == null || p.getStatus() != Pedido.Status.RESERVED) {
            System.out.println("Pedido deve estar RESERVED para pagar.");
            return;
        }

        System.out.println("Processando pagamento de R$" + p.getTotal());
        p.setStatus(Pedido.Status.PAID);
        p.getCliente().incrementarPedidos();
        p.getItens().forEach((prod, qtd) -> prod.addVendidos(qtd));
        System.out.println("Pagamento APROVADO.");
    }

    private static void cancelarPedido() {
        System.out.print("ID Pedido: "); String id = scanner.nextLine();
        Pedido p = pedidos.get(id);
        if (p == null) return;
        
        if (p.getStatus() == Pedido.Status.RESERVED) {
            p.getItens().forEach((prod, qtd) -> prod.setEstoque(prod.getEstoque() + qtd));
        }
        p.setStatus(Pedido.Status.CANCELLED);
        System.out.println("Pedido cancelado.");
    }

    private static void exibirRelatorios() {
        System.out.println("\n--- RELATÓRIOS ---");
        
        double faturamento = pedidos.values().stream()
            .filter(p -> p.getStatus() == Pedido.Status.PAID)
            .mapToDouble(Pedido::getTotal).sum();
        System.out.printf("Faturamento Total (PAID): R$%.2f\n", faturamento);

        System.out.println("\nTop 3 Produtos:");
        produtos.values().stream()
            .sorted(Comparator.comparingInt(Produto::getVendidos).reversed())
            .limit(3)
            .forEach(p -> System.out.println(p.getNome() + " - Vendidos: " + p.getVendidos()));

        System.out.println("\nFaturamento por Categoria:");
        Map<String, Double> porCat = new HashMap<>();
        pedidos.values().stream().filter(p -> p.getStatus() == Pedido.Status.PAID)
            .forEach(p -> p.getItens().forEach((prod, qtd) -> {
                porCat.put(prod.getCategoria(), porCat.getOrDefault(prod.getCategoria(), 0.0) + (prod.getPreco() * qtd));
            }));
        porCat.forEach((cat, fat) -> System.out.printf("%s: R$%.2f\n", cat, fat));

        System.out.println("\nClientes com mais pedidos:");
        clientes.values().stream()
            .sorted(Comparator.comparingInt(Cliente::getTotalPedidos).reversed())
            .limit(5)
            .forEach(System.out::println);
    }
}
