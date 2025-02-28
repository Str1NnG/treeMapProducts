package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProdutoRepository {

    private final TreeMap<Long, Produto> produtos = new TreeMap<>(); // Usando TreeMap para ordenação automática

    public void save(Produto produto) {
        produtos.put(produto.getId(), produto);
    }

    // Filtra produtos com valor abaixo de 100 e retorna os primeiros 5 encontrados
    public Collection<Produto> getPrimeiros5AbaixoDe100() {
        List<Produto> produtosFiltrados = new ArrayList<>();
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
}
