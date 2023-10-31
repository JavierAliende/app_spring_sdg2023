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
import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;

// Arquitectura REST
//Representational State Transfer
//Peticion sin gestion de datos del servido
@RestController
@RequestMapping("api/") // afecta a todos los metodos 
public class SuscritoController {

	@Autowired
	private SuscritoRepository suscritoRepository;
	
	
	//Este metodo retornara una lista de suscrito en forma Json
	//Retornar un estado de la petición /api/suscritos (cli-ser)
	//rotornar del servidor al cliente un Json [] (ser-cli)
	@GetMapping("suscritos")
	public   ResponseEntity<List<Suscrito>> getSuscrito(){
		 
		                                             //retornar las lista completa
		List<Suscrito> suscritos= suscritoRepository.findAll();
		
		System.out.println("Ingrese al Listado");
		return new ResponseEntity<>(suscritos,HttpStatus.OK);
				
				
		}
	
	/*Recibir un objeto suscrito en formato Json {}
        con la url  /api/suscrito
	Almacenar en la base de datos 
	Retornar el nuevo suscrito registrado
	Retornar el estado de la petición, ok si funciona.
	 								error si no funciona.
	 * 
	 * 
			*/
	@PostMapping("suscrito")
	public ResponseEntity<Suscrito> saveSuscrito(@RequestBody Suscrito suscrito) {
		
		try {
			Suscrito suscritoRetorno = suscritoRepository.save(suscrito);
			//Emite 200
			return new ResponseEntity<Suscrito>(suscritoRetorno, HttpStatus.OK);
		} catch (Exception e) {
		
			e.printStackTrace();
				//Si no funciona Emite 500
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}	
	}
	/*  Recicibir un id de la entidad Suscrito
	 * por la URL/api/suscrito
	 * Retornar un objeto suscrito
	 * Retornar el status 200 si existe y 404 si no existe**/
	
	
	@GetMapping("suscrito/{codigo}")
	 public ResponseEntity<Suscrito>getByIs(@PathVariable Long codigo){
	System.out.println("Ingrese a consulta"+codigo);
	//Optionar de Java Util
	Optional<Suscrito>  suscrito =suscritoRepository.findById(codigo);
    
	if(suscrito.isPresent()) {
		return new ResponseEntity<Suscrito>(suscrito.get(), HttpStatus.OK);
		
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
}
	/*Recibir un codigo
	 * por la url api/suscrito
	 * 
	 * Retornar en caso de eliminar el statis 200
	 * Retornar un caso de no encontrar el status 404
	 * **/
	
	@DeleteMapping("suscrito/{codigo}")
	 public ResponseEntity<Suscrito>deleteByIs(@PathVariable Long codigo){
	System.out.println("Ingrese a Eliminar"+codigo);
	//Optionar de Java Util?
	Optional<Suscrito>  suscrito = suscritoRepository.findById(codigo);
   
	if(suscrito.isPresent()) {
		
		suscritoRepository.deleteById(codigo);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}
	
}

	
	
	
	
	
	
	
	
	
	
	