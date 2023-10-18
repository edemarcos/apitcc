package com.edemarcos.tcc.app.category.entrypoint.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String nome;
    private String descricao;

}
