package com.ApiWeB.ApiWeb.repository;

import com.ApiWeB.ApiWeb.model.Cadastros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastros, Long > {
}
