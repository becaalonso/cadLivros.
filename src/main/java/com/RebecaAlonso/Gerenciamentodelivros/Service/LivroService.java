package com.RebecaAlonso.Gerenciamentodelivros.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RebecaAlonso.Gerenciamentodelivros.entities.Livro;
import com.RebecaAlonso.Gerenciamentodelivros.repository.LivroRepository;

@Service
public class LivroService {

	private final LivroRepository livroRepository;

	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public List<Livro> getAllLivro() {
		return livroRepository.findAll();
	}

	public Livro getidLivroById(Long idLivro) {
		return livroRepository.findById(idLivro).orElse(null);

	}

	public void DeleteJogo(Long idLivro) {
		livroRepository.deleteById(idLivro);
	}

	// fazendo o update do livro com o optional
	public Livro updateLivro(Long id, Livro novoLivro) {
		Optional<Livro> livroOptional = livroRepository.findById(id);
		if (livroOptional.isPresent()) {
			Livro livroExistente = livroOptional.get();
			livroExistente.setIsbn(novoLivro.getIsbn());
			livroExistente.setDescricao(novoLivro.getDescricao());
			return livroRepository.save(livroExistente);
		} else {
			return null;
		}
	}
}
