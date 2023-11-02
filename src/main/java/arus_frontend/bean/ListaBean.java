package arus_frontend.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import arus_frontend.http.servicio.ServicioListarAfiliacion;
import arus_frontend.modelo.Afiliacion;

@ManagedBean(name = "lista")
@SessionScoped
public class ListaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Afiliacion> listAfiliaciones;

	public ListaBean() {
		listAfiliaciones = ServicioListarAfiliacion.ejecutar();
	}
	
	public String verRegistro() {
		return "registro";
	}
	
	public List<Afiliacion> getListAfiliaciones() {
		return listAfiliaciones;
	}

	public void setListAfiliaciones(List<Afiliacion> listAfiliaciones) {
		this.listAfiliaciones = listAfiliaciones;
	}
	
	
	
}
