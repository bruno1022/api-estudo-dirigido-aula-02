package entity;

public class Pedido {
	
	private long id;
	private String dataPrevisaoEntrega;	
	private String status;
	private CarrinhoCompras carrinhoCompras;	
	
	public CarrinhoCompras getCarrinhoCompras() {
		return carrinhoCompras;
	}
	public void setCarrinhoCompras(CarrinhoCompras carrinhoCompras) {
		this.carrinhoCompras = carrinhoCompras;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDataPrevisaoEntrega() {
		return dataPrevisaoEntrega;
	}
	public void setDataPrevisaoEntrega(String dataPrevisaoEntrega) {
		this.dataPrevisaoEntrega = dataPrevisaoEntrega;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
