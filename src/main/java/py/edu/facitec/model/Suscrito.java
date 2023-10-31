package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //Que se creara la tabla suscrito
public class Suscrito {
	
	

	@Id//pk
	@GeneratedValue//genera clave automatico
	private Long codigo;
	private String nombre;
	private String correo;
	
	//Cuando el objeto es más importante 
	//Se ignora la lista (2do caso)
	@JsonIgnore
	@OneToMany (mappedBy ="suscrito")  //Objeto a crear dentro del comentario
	private List<Comentario>comentarios;  //Lista kkkk

	
	

	//GETTERS Y SETTERS
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}


	
	

}
