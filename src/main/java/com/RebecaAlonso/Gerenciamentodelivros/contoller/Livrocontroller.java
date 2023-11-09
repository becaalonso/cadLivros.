package com.RebecaAlonso.Gerenciamentodelivros.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RebecaAlonso.Gerenciamentodelivros.entities.Livro;
import com.RebecaAlonso.Gerenciamentodelivros.Service.LivroService;


public class Livrocontroller {

	@RestController
	@RequestMapping("/livro")
	public class LivroController {

		private final LivroService livroService;

		@Autowired
		public LivroController(LivroService livroService) {
			this.livroService = livroService;
		}

		@PostMapping
		public Livro createclient(@RequestBody Livro livro) {
			return livroService.saveLivro(livro);

		}

		@GetMapping("/{id}")
		public ResponseEntity<Livro> getLivro(@PathVariable Long id) {
			Livro livro = livroService.getidLivroById(id);
			if (livro != null) {
				return ResponseEntity.ok(livro);
			} else {
				return ResponseEntity.notFound().build();
			}

		}

		@GetMapping("/home")
		public String paginaInicial() {
			return "index";
		}

		@DeleteMapping("/{id}")
		public void deleteidJogo(@PathVariable Long id) {
			livroService.DeleteJogo(id);
		}

		// Utilizando o ResponseEntity e RequestEntity
		@GetMapping
		public ResponseEntity<List<Livro>> getAllLivro(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Livro> livro = livroService.getAllLivro();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livro);
		}

		@PutMapping("/{id}")
		public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livro) {
			return livroService.updateLivro(id, livro );
		}
	}

	
}
