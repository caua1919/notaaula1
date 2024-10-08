package questão2;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== Sistema de Controle de Produto ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Vender Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    venderProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrarProduto() {
        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tamanho/peso do produto: ");
        String tamanhoOuPeso = scanner.nextLine();
        System.out.print("Digite a cor do produto: ");
        String cor = scanner.nextLine();
        System.out.print("Digite o valor do produto: ");
        double valor = scanner.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 

        Produto produto = new Produto(codigo, nome, tamanhoOuPeso, cor, valor, quantidade);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void venderProduto() {
        System.out.print("Digite o código do produto que deseja vender: ");
        String codigo = scanner.nextLine();
        Produto produto = encontrarProduto(codigo);

        if (produto != null) {
            System.out.print("Digite a quantidade que deseja vender: ");
            int quantidadeVenda = scanner.nextInt();
            scanner.nextLine(); 

            if (quantidadeVenda > produto.getQuantidade()) {
                System.out.println("Quantidade em estoque insuficiente!");
                return;
            }

            double valorTotal = produto.getValor() * quantidadeVenda;
            System.out.println("Valor total da venda: " + valorTotal);
            System.out.println("Formas de pagamento: ");
            System.out.println("1. Pix");
            System.out.println("2. Espécie");
            System.out.println("3. Transferência");
            System.out.println("4. Débito");
            System.out.println("5. Crédito (3x sem juros)");
            System.out.print("Escolha uma forma de pagamento: ");
            int formaPagamento = scanner.nextInt();
            scanner.nextLine(); 

            switch (formaPagamento) {
                case 1: 
                case 3: 
                case 4: 
                    valorTotal *= 0.95; 
                    break;
                case 2: 
                    System.out.print("Digite o valor pago: ");
                    double valorPago = scanner.nextDouble();
                    scanner.nextLine(); 
                    if (valorPago > valorTotal) {
                        double troco = valorPago - valorTotal;
                        System.out.printf("Troco: %.2f\n", troco);
                    } else if (valorPago < valorTotal) {
                        System.out.println("Valor pago insuficiente!");
                        return;
                    }
                    break;
                case 5:
                    System.out.println("Venda parcelada em 3x sem juros.");
                    break;
                default:
                    System.out.println("Forma de pagamento inválida!");
                    return;
            }

            produto.setQuantidade(produto.getQuantidade() - quantidadeVenda);
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static Produto encontrarProduto(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return produto;
            }
        }
        return null;
    }

    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de produtos:");
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}
