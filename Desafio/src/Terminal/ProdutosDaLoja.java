package Terminal;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProdutosDaLoja {

    // Conjunto(produtosDaLoja) contendo os nomes dos produtos e os preços.

    final Map<Integer, ProdutosDaLoja>
            produtosDaLoja = new LinkedHashMap<>();

    private String nome;

    public String getNome() {
        return nome;
    }

    private double preco;

    public double getPreco() {
        return preco;
    }

    ProdutosDaLoja() {
        produtosAdicionados();
    }

    // Construtor(Terminal.ProdutosDaLoja) privado para adicionar os produtos.

    private ProdutosDaLoja(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Método para adicionar nomes e preços no conjunto listaProdutos.

    private void produtosAdicionados() {
        produtosDaLoja.put(123, new ProdutosDaLoja("Celular", 985));
        produtosDaLoja.put(124, new ProdutosDaLoja("Notebook", 5450));
        produtosDaLoja.put(125, new ProdutosDaLoja("Caneta", 1.20));
        produtosDaLoja.put(126, new ProdutosDaLoja("Caderno", 7.72));
    }

}
