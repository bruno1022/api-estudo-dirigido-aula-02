package entity;

public class CarrinhoCompras {

	private long id;	
	private Livro[] livros;
	private String isbn;
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Livro[] getLivros() {
		return livros;
	}
	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
	
}
