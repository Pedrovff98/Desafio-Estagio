package Terminal;

import javax.swing.*;
import java.util.Map;
import java.util.Scanner;

public class LojaPrincipal {

    public static void main(String[] args) {

        ProdutosDaLoja produtosDaLoja = new ProdutosDaLoja();
        CarrinhoDeCompra carrinhoDeCompra = new CarrinhoDeCompra();

        Scanner entradaTeclado1 = new Scanner(System.in);
        Scanner entradaTeclado2 = new Scanner(System.in);
        Scanner entradaTeclado3 = new Scanner(System.in);

        String nomeDoCliente = JOptionPane.showInputDialog
                ("Bem vindo, cadastre o seu nome:", "Olá Digite seu nome:");

        System.out.println("Bem vindo " + nomeDoCliente +
                "\nConheça alguns dos nossos produtos:\n");

        //Foreach pecorre o Map(produtosDaLoja) e mostra os produtos cadstrados para o usuário.

        for (Map.Entry<Integer, ProdutosDaLoja> registro : produtosDaLoja.produtosDaLoja.entrySet()) {
            System.out.println("Nome: " + registro.getValue().getNome());
            System.out.println("Preco: " + registro.getValue().getPreco() + " R$");
            System.out.println("Codigo: " + registro.getKey() + "\n");
        }

        System.out.println("Gostaria de comprar algo? (sim/não)");
        String comprarNaLoja = entradaTeclado1.nextLine();

        // Estrutura de repetição para o usuário entrar com valores validos.

        while (!comprarNaLoja.equalsIgnoreCase("sim")
                && !comprarNaLoja.equalsIgnoreCase("não")) {
            System.out.println("Comando invalido, digite apenas os comandos (sim ou não)");
            comprarNaLoja = entradaTeclado1.nextLine();
        }

        // Estrutura de condição e repetição para o selecionar os produtos do usuário e gerar a nota fiscal.

        if (comprarNaLoja.equalsIgnoreCase("sim")) {
            String desejaContinuar = "sim";

            while (desejaContinuar.equalsIgnoreCase("sim")) {

                System.out.println("Digite Codigo do produto:");
                int codigoDoProduto = entradaTeclado2.nextInt();

                while (codigoDoProduto > 126 || codigoDoProduto < 123) {

                    System.out.println("Codigo incorreto, por favor insira novamente: ");
                    codigoDoProduto = entradaTeclado2.nextInt();
                }

                carrinhoDeCompra.produtosComprados(codigoDoProduto);
                System.out.println("Deseja continuar a compra? (sim/finalizar)");
                desejaContinuar = entradaTeclado3.nextLine();

                while (!desejaContinuar.equalsIgnoreCase("sim")
                        && !desejaContinuar.equalsIgnoreCase("finalizar")) {

                    System.out.println("Comando invalido, digite apenas os comandos (sim ou não)");
                    desejaContinuar = entradaTeclado3.nextLine();
                }
            }

            System.out.println("\n***** NOTA FISCAL ELETRONICA *****");
            System.out.println("PRODUTOS SELECIONADOS: \n");

            carrinhoDeCompra.listaCarrinhoDeCompra.forEach(pecorrer -> {

                System.out.println("*Nome: " + pecorrer.getNome());
                System.out.println("Preço: " + pecorrer.getPreco() + " R$\n");
            });

            System.out.printf("TOTAL A PAGAR: %.2f R$", carrinhoDeCompra.notaFiscal());

        } else {
            System.out.println("Obrigado(a) até a proxima.");
        }
        entradaTeclado1.close();
        entradaTeclado2.close();
        entradaTeclado3.close();
    }
}
