package entity;

public class Pedido {
	
	private long id;
	private String data;
	private Livro[] livros;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Livro[] getLivros() {
		return livros;
	}
	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}
	
	
}
