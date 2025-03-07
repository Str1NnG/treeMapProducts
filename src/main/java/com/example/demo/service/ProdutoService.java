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

        // Inserindo 10.000 produtos sem utilizar estrutura de repeticao
        produtoRepository.inserirProdutos();

        long endTime = System.nanoTime();
        long nanoSeconds = endTime - startTime;

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("nanoSeconds", nanoSeconds);
        response.put("totalProducts", 10000);

        return response;
    }

    public Map<String, Object> consultarProdutos() {
        long startTime = System.nanoTime();

        TreeMap<Long, Produto> produtosAbaixoDe100 = produtoRepository.getProdutosAbaixoDe100();
        TreeMap<Long, Produto> produtosAcimaDe100 = produtoRepository.getProdutosAcimaDe100();

        long endTime = System.nanoTime();
        long nanoSeconds = endTime - startTime;

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("nanoSeconds", nanoSeconds);
        response.put("produtosAbaixoDe100", produtosAbaixoDe100);
        response.put("produtosAcimaDe100", produtosAcimaDe100);

        return response;
    }

    public Map<String, Object> getAllProdutos() {
        long startTime = System.nanoTime();

        TreeMap<Long, Produto> todosProdutos = produtoRepository.getAllProdutos();

        long endTime = System.nanoTime();
        long nanoSeconds = endTime - startTime;

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("nanoSeconds", nanoSeconds);
        response.put("produtos", todosProdutos);

        return response;
    }
}