package Terminal;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {

    ProdutosDaLoja produtosDaLoja = new ProdutosDaLoja();

    // Conjunto (listaCarrinhoDeCompra) contendo os produtos selecionados pelo usuário.

    List<CarrinhoDeCompra>
            listaCarrinhoDeCompra = new ArrayList<>();

    private String nome;

    public String getNome() {
        return nome;
    }

    private double preco;

    public double getPreco() {
        return preco;
    }

    // Construtor (CarrinhoDeCompra) privado para adicionar os produtos selecionados pelo usuário.

    private CarrinhoDeCompra(String nome, double preco) {
        this.preco = preco;
        this.nome = nome;
    }

    CarrinhoDeCompra() {
    }

    /*
    O método(produtosComprados) pega os produtos selecionados pelo usuario que estão cadastrados
    no Map(produtosDaLoja) e inseri-os na List(listaCarrinhoDeCompra).
    */

    void produtosComprados(int codigo) {

        String nomeDoItem = produtosDaLoja.produtosDaLoja.entrySet()
                .stream()
                .filter(x -> x.getKey().equals(codigo))
                .map(y -> y.getValue().getNome())
                .findFirst()
                .get();

        double valorDoItem = produtosDaLoja.produtosDaLoja.entrySet().
                stream()
                .filter(x -> x.getKey().equals(codigo))
                .map(y -> y.getValue().getPreco())
                .findFirst()
                .get();

        listaCarrinhoDeCompra.add(new CarrinhoDeCompra(nomeDoItem, valorDoItem));
    }

    /*
    O método (notaFiscal) pecorre a List(listaCarrinhoDeCompra) e soma todos os produtos
    gerando o total da compra.
      */

    double notaFiscal() {
        return listaCarrinhoDeCompra.stream().mapToDouble(pecorrer -> pecorrer.preco).sum();
    }
}
