package entity;

public class Livro {
	
	private long id;
	private String titulo;
	private String autor;
	private String isbn;
	
	public Livro(long id, String titulo, String autor, String isbn) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
	}
	
	public Livro() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	

}
