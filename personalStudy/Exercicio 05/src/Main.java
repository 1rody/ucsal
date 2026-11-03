import entities.Product;
import services.Stock;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stock stock = new Stock(new ArrayList<>());

        int timer = 0;
        while (timer < 10) {
            System.out.println("=====Bem vindo(a)=====");
            System.out.println("=====SISTEMA DE ESTOQUE DO SEU ZE=====");


            System.out.println(" ");
            System.out.println("Digite um numero de 0 ate 5 para realizar uma operacao:");
            System.out.println("0 - cadastrar novo produto");
            System.out.println("1 - remover produto");
            System.out.println("2 - ver valor do estoque do produto");
            System.out.println("3 - ver valor do estoque todo");
            System.out.println("4 - ver valor produto mais caro no estoque");
            System.out.println("5 - ver informacoes gerais do produto");

            timer++;
            int selector = sc.nextInt();

            switch (selector) {
                default:
                    System.out.println("Opcao invalida.");
                    break;
                case 0 :
                    System.out.println("===CADASTRO DE PRODUTO=====");

                    System.out.println("Nome:");
                    String productName = sc.next();

                    System.out.println("Preco:");
                    double productPrice = sc.nextDouble();

                    System.out.println("Quantidade do produto:");
                    int productQuantity = sc.nextInt();
                    stock.addProduct(productName, productPrice, productQuantity);

                    break;
                case 1 :
                    System.out.println("===REMOCAO DE PRODUTO=====");

                    System.out.println("Nome:");
                    String prodName = sc.next();

                    stock.removeProduct(prodName);

                    break;
                case 2 :
                    System.out.println("===VALOR TOTAL DOS PRODUTOS:=====");

                    System.out.println("Insira o nome do produto para visualizar o valor total em estoque do produto:");
                    String pName = sc.next();

                    Product product = stock.findProduct(pName);
                    if (product != null) {
                        System.out.println("Valor total" + product.calcTotalValue());
                    }
                    else {
                        System.out.println("Nome invalido, por favor digite outro nome.");
                    }

                    break;
                case 3:
                    System.out.println("=== VALOR TOTAL DO ESTOQUE ===");

                    System.out.println("Valor total: " + stock.calcTotalStock());

                    break;
                case 4:
                    System.out.println("=== PRODUTO MAIS CARO ===");

                    Product mostExpensive = stock.mostExpensiveProduct();

                    if (mostExpensive != null) {
                        System.out.println("Nome: " + mostExpensive.getName());
                        System.out.println("Preco: " + mostExpensive.getPrice());
                        System.out.println("Quantidade: " + mostExpensive.getQuantity());
                    } else {
                        System.out.println("O estoque esta vazio.");
                    }

                    break;

                case 5:
                    System.out.println("=== INFORMACOES DO PRODUTO ===");

                    System.out.println("Digite o nome do produto:");
                    String name = sc.next();

                    Product foundProduct = stock.findProduct(name);

                    if (foundProduct != null) {
                        System.out.println("Nome: " + foundProduct.getName());
                        System.out.println("Preco unitario: " + foundProduct.getPrice());
                        System.out.println("Quantidade: " + foundProduct.getQuantity());
                        System.out.println("Valor total em estoque: " + foundProduct.calcTotalValue());
                    } else {
                        System.out.println("Produto nao encontrado.");
                    }

                    break;
            }
        }
    }
}