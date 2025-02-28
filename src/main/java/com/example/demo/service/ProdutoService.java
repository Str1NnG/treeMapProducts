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

        for (int i = 0; i < 10000; i++) {
            Produto produto = new Produto((long) i, "Produto " + (i + 1), 0.01 + (200.00 - 0.01) * Math.random());
            produtoRepository.save(produto);
        }

        long endTime = System.nanoTime();
        long nanoSeconds = endTime - startTime;

        Map<String, Object> response = new LinkedHashMap<>(); // LinkedHashMap para manter a ordem dos atributos
        response.put("nanoSeconds", nanoSeconds);
        response.put("totalProducts", 10000);

        return response;
    }

    public Map<String, Object> consultarProdutos() {
        long startTime = System.nanoTime();

        List<Produto> produtosAbaixoDe100 = produtoRepository.getPrimeiros5AbaixoDe100();
        List<Produto> produtosAcimaDe100 = produtoRepository.getPrimeiros5AcimaDe100();

        long endTime = System.nanoTime();
        long nanoSeconds = endTime - startTime;

        Map<String, Object> response = new LinkedHashMap<>(); // LinkedHashMap para manter a ordem dos atributos
        response.put("nanoSeconds", nanoSeconds);
        response.put("produtosAbaixoDe100", produtosAbaixoDe100);
        response.put("produtosAcimaDe100", produtosAcimaDe100);

        return response;
    }

    public Map<String, Object> getAllProdutos() {
        long startTime = System.nanoTime();

        List<Produto> todosProdutos = produtoRepository.getAllProdutos();

        long endTime = System.nanoTime();
        long nanoSeconds = endTime - startTime;

        Map<String, Object> response = new LinkedHashMap<>(); // LinkedHashMap para manter a ordem dos atributos
        response.put("nanoSeconds", nanoSeconds);
        response.put("produtos", todosProdutos);

        return response;
    }
}
