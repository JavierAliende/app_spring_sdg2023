package py.edu.facitec.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity //Tabla
public class Comentario extends General{
	
	private String texto;
	private Integer estrellas;
	
	//Cuando la lista es importante 
	//El objeto se oculta //Tiene que ser igual que al otro 
	@JsonBackReference(value="variable1")
	//Muchos a Uno
	@ManyToOne
	private Post post;
	
	@ManyToOne
    private Suscrito suscrito;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Suscrito getSuscrito() {
		return suscrito;
	}

	public void setSuscrito(Suscrito suscrito) {
		this.suscrito = suscrito;
	}

	
		}

