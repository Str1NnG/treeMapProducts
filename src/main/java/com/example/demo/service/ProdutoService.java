package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Map<String, Object> inserirProdutos() {
        long startTime = System.nanoTime();

        TreeMap<Double, Produto> produtos = new TreeMap<>();
        for (int i = 0; i < 10000; i++) {
            Produto produto = new Produto();
            produto.setDescricao("Produto " + (i + 1));
            produto.setValor(0.01 + (200.00 - 0.01) * Math.random());

            produtos.put(produto.getValor(), produto);

            produtoRepository.save(produto);
        }

        NavigableMap<Double, Produto> produtosAbaixoDe100 = produtos.headMap(100.0, false);
        NavigableMap<Double, Produto> produtosAcimaDe100 = produtos.tailMap(100.0, false);

        System.out.println("\nProdutos abaixo de R$100,00:");
        produtosAbaixoDe100.entrySet().stream().limit(5).forEach(entry ->
                System.out.println(entry.getValue())  // Exibe até 5 produtos
        );

        System.out.println("\nProdutos acima de R$100,00:");
        produtosAcimaDe100.entrySet().stream().limit(5).forEach(entry ->
                System.out.println(entry.getValue())  // Exibe até 5 produtos
        );

        long endTime = System.nanoTime();
        long nanoSeconds = endTime - startTime;

        Map<String, Object> response = new HashMap<>();
        response.put("totalProducts", 10000);
        response.put("nanoSeconds", nanoSeconds);

        return response;
    }

    public List<Produto> consultarProdutos() {
        return produtoRepository.findAll();
    }
}