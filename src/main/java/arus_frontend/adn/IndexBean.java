package arus_frontend.adn;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "indexBean")
@SessionScoped
public class IndexBean   {

	//private static final long serialVersionUID = 1L;

	private String valorInicial = "Valor inicial de esta variable";
	
	public String getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(String valorInicial) {
		this.valorInicial = valorInicial;
	}
}
