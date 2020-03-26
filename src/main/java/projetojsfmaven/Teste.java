package projetojsfmaven;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//http://localhost:8080/projetojsf/index.jsf
@RequestScoped
@ManagedBean (name="p")
public class Teste {
	private String texto;

	public void testeMet() {
		System.out.println("Teste");
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
