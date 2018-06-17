package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.CarrinhoCompras;
import entity.Livro;
import entity.Pedido;

@RestController
public class PedidoController {
	
	/**
     * 4. Realizar pedidos
     * @param idCarrinhoCompras    
     * @return
     */
    
    @PostMapping("/v1/pedido/carrinhoCompras")    
    public ResponseEntity<Pedido> inserirPedido(@RequestBody CarrinhoCompras carrinhoCompras) {
    	    	
    	Pedido pedido = new Pedido();
    	pedido.setCarrinhoCompras(carrinhoCompras);
    	pedido.setStatus("Aguardando Pagamento!");
    	pedido.setDataPrevisaoEntrega("14/06/2018");
    	
    	return ResponseEntity.status(HttpStatus.CREATED).build();    	
    }
    
    /**
     * 5. Acompanhamento do status dos pedidos.
     * @param id
     * @param pedido
     * @return
     */
    @RequestMapping("/v1/pedido/{id}")    
    public ResponseEntity<Pedido> buscarPedido(@PathVariable(value="id") Long id) {
    	
    	Pedido pedido = new Pedido();
    	pedido.setId(id); 
    	pedido.setDataPrevisaoEntrega("14/06/2016");
    	pedido.setStatus("Aguardando Pagamento!");
    	
    	CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
    	carrinhoCompras.setId(1);
    	carrinhoCompras.setValor(199.9);
    	
    	Livro[] livro = new Livro[2];
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = new Livro(2L,"Javascript e Jquery. Desenvolvimento de Interfaces Web Interativas","Jon Duckett","8576089459");
    	
    	
    	carrinhoCompras.setLivros(livro);
    	
    	pedido.setCarrinhoCompras(carrinhoCompras);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(pedido);    	
    }

}
