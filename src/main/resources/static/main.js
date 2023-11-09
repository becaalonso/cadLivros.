document.getElementById('cadastroForm').addEventListener('submit', cadastrarLivro);
var result = 0;
function cadastrarLivro(event) {
	event.preventDefault();

	const Isbn = document.getElementById('Isbn').value;
	const descricao = document.getElementById('decricao').value;

	fetch('http://localhost:8080/livro', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({ Isbn, descricao }),
	})
		.then(response => response.json())
		.then(data => {
			alert('Livro cadastrado com sucesso!');
			document.getElementById('cadastroForm').reset();
		})
		.catch(error => {
			console.error('Erro ao cadastrar Livro:', error);
		});
}
function pesquisarLivro() {
	const searchId = document.getElementById('searchId').value;

	fetch(`http://localhost:8080/Livro/${searchId}`)
		.then(response => {
			if (response.status === 404) {
				return Promise.reject('Livro não encontrado');
				result = 0;
			}
			return response.json();
		})
		.then(data => {
			result = 1;
			document.getElementById('Isbn').value = `${data.name}`;
			document.getElementById('descricao').value = `${data.plataform}`;
		})
		.catch(error => {
			console.error('Erro ao pesquisar Livro:', error);
			const resultadoPesquisa = document.getElementById('resultadoPesquisa');
			resultadoPesquisa.innerHTML = 'Livro não encontrado.';


		});
}
function atualizarLivro() {
	pesquisarJogo();
	if (result == 1) {
		const Isbn = document.getElementById('Isbn').value;
		const descricao = document.getElementById('decricao').value;
		const searchId = document.getElementById('searchId').value;

		fetch(`http://localhost:8080/Livro/${searchId}`, {
			method: 'PUT',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ Isbn, descricao }),
		})
			.then(response => response.json())
			.then(data => {
				alert('Livro atualizado com sucesso!');
				document.getElementById('cadastroForm').reset();
			})
			.catch(error => {
				console.error('Erro ao atualizar Livro:', error);
			});
	} else {
		alert('ID não encontrado na base de dados. Nenhum Livro foi alterado. Favor pesquisar Livro a ser alterado !!!');
	}
	}
	function deletarLivro() {
	pesquisarLivro();
	if (result == 1) {
		const Isbn = document.getElementById('Isbn').value;
		const descricao = document.getElementById('descricao').value;
		const searchId = document.getElementById('searchId').value;

		fetch(`http://localhost:8080/Livro/${searchId}`, {
			method: 'DELETE',
			headers: {
				'Content-Type': 'application/json',
			},
			body: JSON.stringify({ Isbn, descricao }),
		})
			.then(response => response.json())
			.then(data => {
				alert('Livro deletado com sucesso!');
				document.getElementById('cadastroForm').reset();
			})
			.catch(error => {
				console.error('Erro ao deletar Livro:', error);
			});
	} else {
		alert('ID não encontrado na base de dados. Nenhum Livro foi deletado. Favor pesquisar Livro a ser alterado !!!');
	}
}
