package com.example.demo.controller;

import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/inserir-produtos")
    public ResponseEntity<Map<String, Object>> inserirProdutos() {
        // Chama o serviço para inserir os produtos e obter os dados
        Map<String, Object> response = produtoService.inserirProdutos();
        return ResponseEntity.ok(response);  // Retorna a resposta como JSON
    }

    @GetMapping("/consultar-produtos")
    public ResponseEntity<?> consultarProdutos() {
        return ResponseEntity.ok(produtoService.consultarProdutos());
    }
}