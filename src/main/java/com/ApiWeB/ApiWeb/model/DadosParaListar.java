package com.ApiWeB.ApiWeb.model;

public record DadosParaListar( String nome,String email, String endereco, String telefone) {
    public DadosParaListar(Cadastros listar) {
        this(listar.getNome(), listar.getEmail(), listar.getEndereco(), listar.getTelefone());
    }
}
