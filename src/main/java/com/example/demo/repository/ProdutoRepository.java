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

    public List<Produto> getPrimeiros5AbaixoDe100() {
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto produto : produtos.values()) {
            if (produto.getValor() < 100.00 && produtosFiltrados.size() < 5) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }

    public List<Produto> getPrimeiros5AcimaDe100() {
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto produto : produtos.values()) {
            if (produto.getValor() >= 100.00 && produtosFiltrados.size() < 5) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }

    public List<Produto> getAllProdutos() {
        return new ArrayList<>(produtos.values());
    }
}
