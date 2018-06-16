package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Comentario;
import entity.Livro;


@RestController
public class LivroController {
	
	/**
	 * 1. Postar comentários para livros.
	 * @param isbn
	 * @param comentario
	 * @return
	 */
	@PostMapping("/v1/livro/{isbn}/comentario")    
    public ResponseEntity<?> insereComentario(@PathVariable(value="isbn") String isbn, @RequestBody Comentario comentario) {
		//comentario.setComentario("Ótimo livro para quem quer aprender Java");
		comentario.setId(1L);
		//comentario.setIsbn("8576081733");
		comentario.setIsbn(isbn);
		//return comentario, HttpStatus.CREATED;	
		return ResponseEntity.status(HttpStatus.CREATED).build();		
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
     * 6. Cadastrar livros
     * @param isbn
     * @param autor
     * @param titulo
     * @param livro
     * @return
     */
    @RequestMapping("/v1/livro")    
    public ResponseEntity<?> cadastraLivro(@RequestBody Livro livro) {
    	
    	livro = new Livro(1L,"Use A Cabeça! Java","Kathy Sierra","8576081733");
    	return ResponseEntity.status(HttpStatus.CREATED).build();    	
    }

}
