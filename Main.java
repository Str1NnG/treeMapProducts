import java.util.*;

class Produto {
    String descricao;
    double valor;

    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Produto{descricao='%s', valor=%.2f}", descricao, valor);
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando a árvore rubro-negra (TreeMap) para armazenar os produtos
        TreeMap<Double, Produto> produtos = new TreeMap<>();

        // Gerando 10 mil produtos aleatórios
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            double valor = 0.01 + (200.00 - 0.01) * random.nextDouble();
            String descricao = "Produto " + (i + 1);
            Produto produto = new Produto(descricao, valor);
            produtos.put(valor, produto);
        }

        NavigableMap<Double, Produto> produtosAbaixoDe100 = produtos.headMap(100.0, false);
        NavigableMap<Double, Produto> produtosAcimaDe100 = produtos.tailMap(100.0, false);

        System.out.println("Quantidade de produtos abaixo de R$100,00: " + produtosAbaixoDe100.size());
        System.out.println("Quantidade de produtos acima de R$100,00: " + produtosAcimaDe100.size());

        System.out.println("\nExemplos de produtos abaixo de R$100,00:");
        produtosAbaixoDe100.entrySet().stream().limit(5).forEach(entry -> {
            System.out.println(entry.getValue());
        });

        System.out.println("\nExemplos de produtos acima de R$100,00:");
        produtosAcimaDe100.entrySet().stream().limit(5).forEach(entry -> {
            System.out.println(entry.getValue());
        });
    }
}