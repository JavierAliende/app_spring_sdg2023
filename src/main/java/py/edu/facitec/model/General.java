package py.edu.facitec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


// Utilización de herencia o clase Padre en JPA
//Permite reutilizar los atribulos contenidos.
@MappedSuperclass
public class General {
	
        @Id     //Pk           //estrategia para utilizar ala generacion de la Base de Datos
    	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "General [id=" + id + "]";
	}
	
    
	
}
