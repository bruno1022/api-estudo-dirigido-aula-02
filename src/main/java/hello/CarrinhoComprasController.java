package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.CarrinhoCompras;
import entity.Livro;

@RestController
public class CarrinhoComprasController {
	
	/**
     * 3.1. Buscar Carrinho de Compras
     * @param id
     * @return
     */
    @RequestMapping("/v1/carrinhoCompras/{id}")    
    public CarrinhoCompras buscarCarrinhoCompras(@PathVariable(value="id") String id) {
    	
    	CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
    	
    	Livro[] livro = new Livro[3];
    	
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[1] = new Livro(2L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	livro[2] = new Livro(3L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	
    	carrinhoCompras.setLivros(livro);
    	
    	carrinhoCompras.setId(1l);
    	/*
    	String[] array = {"8576081733","8576081733","8576081733"};
    	cc.setIsbn(array);
    	*/
        return carrinhoCompras;
    }
    
    /**
     * 3.2. Inserir Novo Carrinho de Compras
     * @param id
     * @param carrinhoCompras
     * @return
     */
    @PostMapping("/v1/carrinhoCompras")    
    public ResponseEntity<?> inserirCarrinhoCompras(@RequestBody CarrinhoCompras carrinhoCompras) {
    	
    	Livro[] livro = new Livro[1];
    	livro[0] = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	
    	carrinhoCompras = new CarrinhoCompras();
    	carrinhoCompras.setLivros(livro);
    	return ResponseEntity.status(HttpStatus.CREATED).build();    	
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
    	
    	if(carrinhoCompras.getLivros()!=null) {
    		return ResponseEntity.status(HttpStatus.OK).body(carrinhoCompras);
    	} else {
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}
    	
    	    	
    }
}
