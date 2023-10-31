package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.edu.facitec.model.Comentario;
import py.edu.facitec.repository.ComentarioRepository;

//Arquitectura REST
//Representational State Transfer
//Peticion sin gestion de datos del servido
@RestController
@RequestMapping("api/") // afecta a todos los metodos 
public class ComentarioController {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	
	//Este metodo retornara una lista de Comentario en forma Json
	//Retornar un estado de la petición /api/Comentarios (cli-ser)
	//rotornar del servidor al cliente un Json [] (ser-cli)
	@GetMapping("comentarios")
	public   ResponseEntity<List<Comentario>> getComentario(){
		 
		                                             //retornar las lista completa
		List<Comentario> comentarios= comentarioRepository.findAll();
		
		System.out.println("Ingrese al Listado");
		return new ResponseEntity<>(comentarios,HttpStatus.OK);	
				
		}
	
	/*Recibir un objeto Comentario en formato Json {}
        con la url  /api/Comentario
	Almacenar en la base de datos 
	Retornar el nuevo Comentario registrado
	Retornar el estado de la petición, ok si funciona.
	 								error si no funciona.
	 * 
	 * 
			*/
	@PostMapping("comentario")
	public ResponseEntity<Comentario> saveComentario(@RequestBody Comentario comentario) {
		
		try {
			Comentario ComentarioRetorno = comentarioRepository.save(comentario);
			//Emite 200
			return new ResponseEntity<Comentario>(ComentarioRetorno, HttpStatus.OK);
		} catch (Exception e) {
		
			e.printStackTrace();
				//Si no funciona Emite 500
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}	
	}
	/*  Recicibir un id de la entidad Comentario
	 * por la URL/api/Comentario
	 * Retornar un objeto Comentario
	 * Retornar el status 200 si existe y 404 si no existe**/
	
	
	@GetMapping("comentario/{codigo}")
	 public ResponseEntity<Comentario>getByIs(@PathVariable Long codigo){
	System.out.println("Ingrese a consulta"+codigo);
	//Optionar de Java Util
	Optional<Comentario> comentario =comentarioRepository.findById(codigo);
    
	if(comentario.isPresent()) {
		return new ResponseEntity<Comentario>(comentario.get(), HttpStatus.OK);
		
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}
	/*Recibir un codigo
	 * por la url api/Comentario
	 * 
	 * Retornar en caso de eliminar el statis 200
	 * Retornar un caso de no encontrar el status 404
	 * **/
	
	@DeleteMapping("comentario/{codigo}")
	 public ResponseEntity<Comentario>deleteByIs(@PathVariable Long codigo){
	System.out.println("Ingrese a Eliminar"+codigo);
	//Optionar de Java Util?
	Optional<Comentario>  Comentario = comentarioRepository.findById(codigo);
   
	if(Comentario.isPresent()) {
		
		comentarioRepository.deleteById(codigo);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}
	
}