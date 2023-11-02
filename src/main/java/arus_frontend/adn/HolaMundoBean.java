package arus_frontend.adn;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "holaMundoBean")
@SessionScoped
public class HolaMundoBean {
	
	private String mensaje = "Hola mundo desde Bean";

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
