package com.example.demo.controller;

import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/inserir-produtos")
    public ResponseEntity<Map<String, Object>> inserirProdutos() {
        return ResponseEntity.ok(produtoService.inserirProdutos());
    }

    @GetMapping("/consultar-produtos")
    public ResponseEntity<Map<String, Object>> consultarProdutos() {
        return ResponseEntity.ok(produtoService.consultarProdutosNaArvore());
    }

    @GetMapping("/produtos")
    public ResponseEntity<Map<String, Object>> getAllProdutos() {
        return ResponseEntity.ok(produtoService.getAllProdutos());
    }
}
