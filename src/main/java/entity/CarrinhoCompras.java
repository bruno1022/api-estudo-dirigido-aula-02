package entity;

public class CarrinhoCompras {

	private long id;	
	private double valor;	
	private Livro[] livros;		
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
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
