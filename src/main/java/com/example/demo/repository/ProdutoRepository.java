package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepository {

    private final TreeMap<Long, Produto> produtos = new TreeMap<>(); // Usando TreeMap para ordenação automática por ID
    private final AtomicLong idGenerator = new AtomicLong(0); // Gerador de IDs únicos

    // Inserindo 10.000 produtos sem utilizar estrutura de repetição
    public void inserirProdutos() {
        Random random = new Random();
        produtos.putAll(
                new Random().longs(10000)
                        .boxed()
                        .collect(Collectors.toMap(
                                id -> idGenerator.getAndIncrement(), // Gera IDs únicos
                                id -> new Produto(id, "Produto " + id, 0.01 + (200.00 - 0.01) * random.nextDouble())
                        ))
        );
    }

    // Retorna todos os produtos com valor abaixo de 100, ordenados por valor
    public TreeMap<Long, Produto> getProdutosAbaixoDe100() {
        // Cria um Comparator para ordenar os produtos pelo valor
        Comparator<Long> comparator = Comparator.comparingDouble(id -> produtos.get(id).getValor());

        // Filtra e coleta os produtos em uma nova TreeMap com o Comparator
        return produtos.entrySet().stream()
                .filter(entry -> entry.getValue().getValor() < 100.00)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        () -> new TreeMap<>(comparator)
                ));
    }

    // Retorna todos os produtos com valor acima de 100, ordenados por valor
    public TreeMap<Long, Produto> getProdutosAcimaDe100() {
        // Cria um Comparator para ordenar os produtos pelo valor
        Comparator<Long> comparator = Comparator.comparingDouble(id -> produtos.get(id).getValor());

        // Filtra e coleta os produtos em uma nova TreeMap com o Comparator
        return produtos.entrySet().stream()
                .filter(entry -> entry.getValue().getValor() >= 100.00)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        () -> new TreeMap<>(comparator)
                ));
    }

    // Método usando headMap para pegar produtos abaixo de 100
    public TreeMap<Long, Produto> getProdutosAbaixoDe100ComHeadMap() {
        // Usando cast para TreeMap
        return new TreeMap<>(produtos.headMap(produtos.lastKey()));  // Filtra tudo abaixo da última chave
    }

    // Método usando tailMap para pegar produtos acima de 100
    public TreeMap<Long, Produto> getProdutosAcimaDe100ComTailMap() {
        // Usando cast para TreeMap
        return new TreeMap<>(produtos.tailMap(produtos.firstKey()));  // Seleciona produtos com valor maior ou igual a 100
    }

    public TreeMap<Long, Produto> getAllProdutos() {
        return produtos;
    }
}
