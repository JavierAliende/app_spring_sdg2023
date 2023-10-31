	package py.edu.facitec.model;
	
	import java.time.LocalDate;
	import java.util.List;
	
	import javax.persistence.Entity;
	import javax.persistence.OneToMany;
	
	import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
	
	@Entity // p. crear la tabla
	public class Post extends General {
		//Se obtiene la Id mediante la herencia
		
	private String titulo;
	private String autor;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate fecha;
	private String texto;
		
	         
	//La lista es más importante
	@JsonManagedReference(value= "variable1")
	// objto a crear dentro de comentario 
	@OneToMany(mappedBy = "post")
		private List<Comentario>comentarios;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
		
		
		
	}
