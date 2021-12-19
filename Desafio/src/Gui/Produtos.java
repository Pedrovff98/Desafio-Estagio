package Gui;

import javax.swing.*;
import java.awt.*;

public class Produtos extends JFrame {

    final private String nome;
    Logica logica = new Logica();

     /*
    Construtor(Produtos) inicializa com os componentes para o JFrame
     */

    Produtos(String nome) {
        this.nome = nome;
        setSize(550, 620);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("MelhorPreço.com");
        setLayout(null);
        componetes();
        setFocusable(true);
        setResizable(false);
        SwingUtilities.invokeLater(() -> {
            repaint();
            validate();
        });
    }

    /*
     Método (componentes) adiciona as interfaces gráfica da segunda tela (Produtos).
     */

    void componetes() {

        JTextArea notaFiscalTela = new JTextArea();
        StringBuilder stringBuilder1 = new StringBuilder();

        JLabel bemVindo = new JLabel();

        bemVindo.setText("Bem vindo " + nome + " :)");
        bemVindo.setBounds(10, 0, 150, 15);
        bemVindo.setFont(new Font("SansSerif", Font.PLAIN, 15));
        add(bemVindo);

        JLabel produtos = new JLabel();

        produtos.setBounds(10, 0, 160, 400);
        produtos.setFont(new Font("SansSerif", Font.BOLD, 15));
        produtos.setText("<html>Conheça os produtos:<body>" +
                "<br>" +
                "<br>" +
                "Nome: Celular" +
                "<br>Preço: 985.00 R$" +
                "<br>Codigo: 123" +
                "<br>" +
                "<br>Nome: Notebook" +
                "<br>Preço: 5.873 R$" +
                "<br>Codigo: 124" +
                "<br>" +
                "<br>Nome: Caneta" +
                "<br>Preço: 1.20 R$" +
                "<br>Codigo: 125 " +
                "<br>" +
                "<br>Nome: Caderno" +
                "<br>Preço: 7.72 R$" +
                "<br>Codigo: 126" +
                "</body></html>");
        add(produtos);

        JLabel codigos = new JLabel();

        codigos.setText("Digite o codigo do produto:");
        codigos.setBounds(10, 450, 200, 20);
        add(codigos);

        JTextField inserirCodigos = new JTextField();

        inserirCodigos.setBounds(10, 490, 100, 30);
        add(inserirCodigos);

        JButton adicionarNoCarrinho = new JButton("Adicionar no carrinho");

        adicionarNoCarrinho.setBounds(10, 550, 160, 25);
        adicionarNoCarrinho.addActionListener(x -> {
            try {
                logica.cast(inserirCodigos.getText());
                inserirCodigos.setText("");
            } catch (NumberFormatException ignored) {
            }
            if (logica.notaFiscalFinal.size() != 0) {
                notaFiscalTela.setText("* Itens no carrinho de compra: " + logica.notaFiscalFinal.size());
            }
        });
        add(adicionarNoCarrinho);


        JScrollPane sc = new JScrollPane(notaFiscalTela);
        notaFiscalTela.setLineWrap(true);
        notaFiscalTela.setFont(new Font("SansSerif", Font.PLAIN, 15));
        notaFiscalTela.setEditable(false);
        sc.setBounds(300, 30, 225, 400);
        add(sc);

        JButton finalizarCompra = new JButton("Finalizar Compra");
        JButton novaCompra = new JButton("Nova Compra");

        finalizarCompra.setBounds(320, 550, 200, 25);

        finalizarCompra.addActionListener(x -> {
            adicionarNoCarrinho.setEnabled(false);
            novaCompra.setEnabled(true);

            for (Logica teste : logica.notaFiscalFinal) {
                stringBuilder1.append("\nNome: ").append(teste.getNomes())
                        .append("\nPreço: ").append(teste.getPreco()).append(" R$")
                        .append("\nCodigo: ").append(teste.getCodigos()).append("\n");
            }
            notaFiscalTela.setText("***********NOTA FISCAL**********\n" +
                    stringBuilder1 + "\n"
                    + "TOTAL A PAGAR: " + logica.total() + " R$");

            finalizarCompra.setEnabled(false);
        });

        add(finalizarCompra);

        novaCompra.setBounds(340, 450, 150, 25);
        novaCompra.setEnabled(false);
        novaCompra.addActionListener(x -> {
            stringBuilder1.delete(0, stringBuilder1.length());
            novaCompra.setEnabled(false);
            logica.notaFiscalFinal.clear();
            notaFiscalTela.setText("");
            adicionarNoCarrinho.setEnabled(true);
            finalizarCompra.setEnabled(true);

        });
        add(novaCompra);
    }
}

