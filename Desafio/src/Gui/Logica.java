package Gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Logica {

    /*
    Classe (Logica) responsável para armazenar os produtos selecionados pelo cliente
     */

    List<Logica> notaFiscalFinal = new ArrayList<>();

    private Integer codigos;
    private String nomes;
    private Double preco;

    // Construtor (Logica) privado para adicionar os produtos selecionados pelo usuário.

    private Logica(String nomes, Double preco, int codigo) {
        this.nomes = nomes;
        this.preco = preco;
        this.codigos = codigo;
    }

    Logica() {
    }

    public Integer getCodigos() {
        return codigos;
    }

    public void setCodigos(Integer codigos) {
        this.codigos = codigos;
    }

    // Método (cast) faz o cast dos códigos dos produtos do JTextField para o valor double.
    void cast(String produtos) {
        setCodigos(Integer.parseInt(produtos));
        condicao();
    }

    public String getNomes() {
        return nomes;
    }

    public Double getPreco() {
        return preco;
    }

    //Método (condicao) adiciona os produtos selecionados pelo código no List(notaFiscalFinal).
    void condicao() {
        switch (codigos) {
            case 123 -> notaFiscalFinal.add(new Logica("Celular", 985.0, 123));
            case 124 -> notaFiscalFinal.add(new Logica("Notebook", 5873.0, 124));
            case 125 -> notaFiscalFinal.add(new Logica("Caneta", 1.20, 125));
            case 126 -> notaFiscalFinal.add(new Logica("Caderno", 7.72, 126));
            default -> JOptionPane.showMessageDialog(null, "valor invalido");

        }
    }

    //Método (total) retorna o valor total da compra.
    String total() {
        double total = notaFiscalFinal.stream().mapToDouble(Logica::getPreco).sum();
        return String.format("%.2f", total);
    }
}
