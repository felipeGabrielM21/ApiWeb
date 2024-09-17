package com.ApiWeB.ApiWeb.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosParaCadastro(

        @NotNull
        String nome,

        @Email
        @NotNull
        String email,

        @NotNull
        String endereco,

        @NotNull
        String telefone) {
}
