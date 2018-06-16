package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Livro;
import entity.Pedido;

@RestController
public class PedidoController {
	
	/**
     * 4. Realizar pedidos
     * @param isbn
     * @param data
     * @param pedido
     * @return
     */
    
    @PostMapping("/v1/pedido")    
    public ResponseEntity<?> inserirPedido(@PathVariable(value="isbn") String isbn, @PathVariable(value="data") String data, @RequestBody Pedido pedido) {
    	
    	pedido = new Pedido();
    	
    	Livro[] livro = new Livro[2];
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = new Livro(2L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = null;
    	
    	pedido.setLivros(livro);
    	pedido.setData("11/06/2018");
    	pedido.setStatus("Nota Fiscal Emitida");
    	
    	return ResponseEntity.status(HttpStatus.CREATED).build();    	
    }
    
    /**
     * 5. Acompanhamento o status das entregas realizadas.
     * @param id
     * @param pedido
     * @return
     */
    @RequestMapping("/v1/pedidoStatus/{id}")    
    public ResponseEntity<Pedido> buscarPedido(@PathVariable(value="id") String id, @RequestBody Pedido pedido) {
    	
    	pedido = new Pedido();
    	
    	Livro[] livro = new Livro[2];
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = new Livro(2L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = null;
    	
    	pedido.setId(1L);
    	pedido.setLivros(livro);
    	pedido.setData("14/06/2018");
    	pedido.setStatus("Entregue");    	
    	
    	return ResponseEntity.status(HttpStatus.OK).body(pedido);    	
    }

}
