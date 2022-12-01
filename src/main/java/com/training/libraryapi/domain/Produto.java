package com.training.libraryapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String image;
    private String descricao;
    private double preco;
    private String tipo;
}
