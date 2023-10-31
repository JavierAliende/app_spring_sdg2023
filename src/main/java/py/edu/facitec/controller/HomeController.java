package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //Trabaja con los request y response
public class HomeController {
				//raiz de la app
	@RequestMapping("/")//URL a responder	
	public String retornarPagina() {
		
		System.out.println("Ingreso al método para cargar la pag. principal");
			//página a responder
		return "usuario/login";
	}

	
	@RequestMapping("/form")//URL a responder	
	public String accederFormularioSuscrito() {
		
		System.out.println("Ingreso al método para cargar la pag. principal");
			//página a responder
		return "suscrito/form";
	}

}
