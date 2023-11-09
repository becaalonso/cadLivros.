package com.RebecaAlonso.Gerenciamentodelivros.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbLivro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	private String descricao;

	@NotNull
	@NotBlank
	private String Isbn;
	
	public Livro() {
		
	}
	
	public Livro(Long id, String Isbn, String descricao) {
		super();
		this.id = id;
        this.Isbn = Isbn;
		this.descricao = descricao;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return Isbn;
	}

	public void setIsbn(String Isbn) {
		Isbn = Isbn;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
