package com.ApiWeB.ApiWeb.model;

import jakarta.validation.constraints.NotNull;

public record DadosParaAtualizar(
        @NotNull
        Long id,

        String endereco,

        String telefone,

        String email) {


}
