package com.ApiWeB.ApiWeb.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_cadastro")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Cadastros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    String endereco;
    String telefone;

    public Cadastros(DadosParaCadastro dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.endereco = dados.endereco();
        this.telefone = dados.telefone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void atualizarinformacoes(DadosParaAtualizar dados) {
         if(endereco !=null) {
             this.endereco = dados.endereco();
         }
         if(email != null) {
             this.email = dados.email();
         }
         if(telefone != null) {
             this.telefone = dados.telefone();
         }
    }
}

