package com.RebecaAlonso.Gerenciamentodelivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RebecaAlonso.Gerenciamentodelivros.entities.Livro;

public interface LivroRepository extends JpaRepository <Livro, Long>{

}

