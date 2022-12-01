package com.training.libraryapi.service;

import com.training.libraryapi.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutosService {

    private static List<Produto> produtos;

    static {
        produtos = new ArrayList<>(List.of(new Produto(1L,
                        "Carioca",
                        "jdçlkasjdla",
                        "Preto e Forte",
                        2.50,
                        "tradicional"),
                new Produto(2L,
                        "Expresso",
                        "jdçlkasjdla",
                        "Intenso",
                        3.50,
                        "tradicional")));
    }

    public List<Produto> getAllProdutos() {
        return produtos;
    }

    public Produto findById(long id) {
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));

    }

    public long totalProdutos() {
        long qtdProdutos = produtos.size();
        log.info("Quantidade de Produtos: {}", qtdProdutos);
        return qtdProdutos;
    }

}
