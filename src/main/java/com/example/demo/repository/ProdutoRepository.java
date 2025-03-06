package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepository {

    private final TreeMap<Long, Produto> produtos = new TreeMap<>();

    private final TreeMap<Produto, Double> mapaProdutos = new TreeMap<>(Comparator.comparingDouble(p -> p.getValor()));// Usando TreeMap para ordenação automática

    public void save(Produto produto) {
        produtos.put(produto.getId(), produto);
    }

    public void saveInTree(Produto produto) {
        mapaProdutos.put(produto, produto.getValor());
    }

    // Filtra produtos com valor abaixo de 100 e retorna os primeiros 5 encontrados
    public Collection<Produto> getPrimeiros5AbaixoDe100() {
        Collection<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto produto : produtos.values()) {
            if (produto.getValor() < 100.00 && produtosFiltrados.size() < 5) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }

    // Filtra produtos com valor acima de 100 e retorna os primeiros 5 encontrados
    public Collection<Produto> getPrimeiros5AcimaDe100() {
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto produto : produtos.values()) {
            if (produto.getValor() >= 100.00 && produtosFiltrados.size() < 5) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }

    // Retorna todos os produtos
    public Collection<Produto> getAllProdutos() {
        return produtos.values(); // O TreeMap retorna os valores de forma ordenada
    }

    public Collection<Produto> findAbaixoValor(Double valor){
        return mapaProdutos.navigableKeySet().stream().filter(p -> p.getValor() < valor).collect(Collectors.toList());
    }

    public Collection<Produto> findAcimaValor(Double valor){
        return mapaProdutos.navigableKeySet().stream().filter(p -> p.getValor() > valor).collect(Collectors.toList());
    }

    public SortedMap<Produto, Double> findAbaixoValorSort(Double valor){
        return mapaProdutos.headMap(new Produto(valor));
    }

    public SortedMap<Produto, Double> findAcimaValorSort(Double valor){
        return mapaProdutos.tailMap(new Produto(valor));
    }
}
