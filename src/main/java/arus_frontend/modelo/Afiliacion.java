package arus_frontend.modelo;

public class Afiliacion {

	private String codigo;
	private Afiliado afiliado;
	private AdministradoraSalud administradoraSalud;
	private String fechaAfiliacionSalud;
	private AdministradoraPension administradoraPension;
	private String fechaAfiliacionPension;
	
	public Afiliacion(String codigo, Afiliado afiliado, AdministradoraSalud administradoraSalud,
			String fechaAfiliacionSalud, AdministradoraPension administradoraPension, String fechaAfiliacionPension) {
		this.codigo = codigo;
		this.afiliado = afiliado;
		this.administradoraSalud = administradoraSalud;
		this.fechaAfiliacionSalud = fechaAfiliacionSalud;
		this.administradoraPension = administradoraPension;
		this.fechaAfiliacionPension = fechaAfiliacionPension;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Afiliado getAfiliado() {
		return afiliado;
	}
	
	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}
	
	public AdministradoraSalud getAdministradoraSalud() {
		return administradoraSalud;
	}
	
	public void setAdministradoraSalud(AdministradoraSalud administradoraSalud) {
		this.administradoraSalud = administradoraSalud;
	}
	
	public String getFechaAfiliacionSalud() {
		return fechaAfiliacionSalud;
	}
	
	public void setFechaAfiliacionSalud(String fechaAfiliacionSalud) {
		this.fechaAfiliacionSalud = fechaAfiliacionSalud;
	}
	
	public AdministradoraPension getAdministradoraPension() {
		return administradoraPension;
	}
	
	public void setAdministradoraPension(AdministradoraPension administradoraPension) {
		this.administradoraPension = administradoraPension;
	}
	
	public String getFechaAfiliacionPension() {
		return fechaAfiliacionPension;
	}
	
	public void setFechaAfiliacionPension(String fechaAfiliacionPension) {
		this.fechaAfiliacionPension = fechaAfiliacionPension;
	}
}
