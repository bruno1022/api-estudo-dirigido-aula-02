package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.CarrinhoCompras;
import entity.Comentario;
import entity.Livro;
import entity.Pedido;


@RestController
public class LivroController {
	
	/**
	 * 1. Postar comentários para livros.
	 * @param isbn
	 * @param comentario
	 * @return
	 */
	@PostMapping("/v1/livro/{isbn}/comentario")    
    public ResponseEntity<Comentario> insereComentario(@PathVariable(value="isbn") String isbn, @RequestBody Comentario comentario) {
		comentario.setComentario("Ótimo livro para quem quer aprender Java");
		comentario.setId(1L);
		comentario.setIsbn("8576081733");
		//return comentario, HttpStatus.CREATED;	
		return ResponseEntity.status(HttpStatus.CREATED).body(comentario);		
    }

	/**
	 * 2. Pesquisa de livros por critérios diversos.
	 * @param isbn
	 * @param autor
	 * @return
	 */
    @RequestMapping("/v1/livro/{isbn}/{autor}")    
    public Livro livro(@PathVariable(value="isbn") String isbn, 
    		@PathVariable(value="autor") String autor) {
        return new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    }
    
    /**
     * 3.1. Buscar Carrinho de Compras
     * @param id
     * @return
     */
    @RequestMapping("/v1/carrinhoCompras/{id}")    
    public CarrinhoCompras buscarCarrinhoCompras(@PathVariable(value="id") String id) {
    	
    	CarrinhoCompras cc = new CarrinhoCompras();
    	
    	Livro[] livro = new Livro[3];
    	
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = new Livro(2L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[2] = new Livro(3L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	
    	cc.setLivros(livro);
    	
    	cc.setId(1l);
    	/*
    	String[] array = {"8576081733","8576081733","8576081733"};
    	cc.setIsbn(array);
    	*/
        return cc;
    }
    
    /**
     * 3.2. Inserir Novo Carrinho de Compras
     * @param id
     * @param carrinhoCompras
     * @return
     */
    @PostMapping("/v1/carrinhoCompras")    
    public ResponseEntity<CarrinhoCompras> inserirCarrinhoCompras(@RequestBody CarrinhoCompras carrinhoCompras) {
    	
    	Livro[] livro = new Livro[1];
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	
    	carrinhoCompras = new CarrinhoCompras();
    	carrinhoCompras.setLivros(livro);
    	return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoCompras);    	
    }
    
    /**
     * 3.3. Adicionar Livro ao Carrinho de Compras
     * @param id
     * @param isbn
     * @param carrinhoCompras
     * @return
     */
    @PutMapping("/v1/carrinhoCompras/{id}/livro")    
    public ResponseEntity<CarrinhoCompras> adicionarLivroCarrinhoCompras(@PathVariable(value="id") String id, @RequestBody CarrinhoCompras carrinhoCompras) {
    	
    	carrinhoCompras = new CarrinhoCompras();
    	
    	Livro[] livro = new Livro[2];
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = new Livro(2L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	
    	carrinhoCompras.setLivros(livro);
    	carrinhoCompras.setId(1L);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoCompras);    	
    }
    
    /**
     * 3.4. Remover Livro do Carrinho de Compras
     * @param isbn
     * @param carrinhoCompras
     * @return
     */
    @PutMapping("/v1/carrinhoCompras/{isbn}")    
    public ResponseEntity<CarrinhoCompras> deletarLivroCarrinhoCompras(@PathVariable(value="isbn") String isbn, @RequestBody CarrinhoCompras carrinhoCompras) {
    	
    	carrinhoCompras = new CarrinhoCompras();
    	
    	Livro[] livro = new Livro[2];
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = new Livro(2L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = null;
    	
    	carrinhoCompras.setLivros(livro);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoCompras);    	
    }
    
    /**
     * 4. Realizar pedidos
     * @param isbn
     * @param data
     * @param pedido
     * @return
     */
    
    @PostMapping("/v1/pedido")    
    public ResponseEntity<Pedido> inserirPedido(@PathVariable(value="isbn") String isbn, @PathVariable(value="data") String data, @RequestBody Pedido pedido) {
    	
    	pedido = new Pedido();
    	
    	Livro[] livro = new Livro[2];
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = new Livro(2L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = null;
    	
    	pedido.setLivros(livro);
    	pedido.setData("11/06/2018");
    	pedido.setStatus("Nota Fiscal Emitida");
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(pedido);    	
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
    
    /**
     * 6. Cadastrar livros
     * @param isbn
     * @param autor
     * @param titulo
     * @param livro
     * @return
     */
    @RequestMapping("/v1/livro")    
    public ResponseEntity<Livro> cadastraLivro(@PathVariable(value="isbn") String isbn, @PathVariable(value="autor") String autor, @PathVariable(value="titulo") String titulo, @RequestBody Livro livro) {
    	
    	livro = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	return ResponseEntity.status(HttpStatus.CREATED).body(livro);    	
    }

}
