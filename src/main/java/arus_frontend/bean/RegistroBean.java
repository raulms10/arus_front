package arus_frontend.bean;

import java.util.Map;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import arus_frontend.drools.DroolsConfig;
import arus_frontend.http.servicio.ServicioCrearAfiliacion;
import arus_frontend.http.servicio.ServicioListarAdministradoraPension;
import arus_frontend.http.servicio.ServicioListarAdministradoraSalud;
import arus_frontend.http.servicio.ServicioListarTipoDocumentos;
import arus_frontend.modelo.AdministradoraPension;
import arus_frontend.modelo.AdministradoraSalud;
import arus_frontend.modelo.TipoDocumento;

@ManagedBean(name = "registro")
@SessionScoped
public class RegistroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tipoDocumento;
	private String numeroDocumento;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String adminSalud;
	private Date fechaSalud;
	private String adminPension;
	private Date fechaPension;

	private Map<String, String> tiposDeDocumento = new LinkedHashMap<String, String>();
	private Map<String, String> administradorasSalud = new LinkedHashMap<String, String>();
	private Map<String, String> administradorasPension = new LinkedHashMap<String, String>();

	private String mensajeExcepcion = "";

	public RegistroBean() {
		cargarTiposDocumentos();
		cargarAdministradorasSalud();
		cargarAdministradorasPension();
	}

	private void cargarTiposDocumentos() {
		tiposDeDocumento.put("", "");
//		tiposDeDocumento.put("Cédula", "CC");
//		tiposDeDocumento.put("Cédula de extranjería", "CE");
//		tiposDeDocumento.put("Registro Civil", "RC");
//		tiposDeDocumento.put("Tarjeta de Identidad", "TI");

		List<TipoDocumento> listaTipoDocumentos = ServicioListarTipoDocumentos.ejecutar();
		for (TipoDocumento tipoDoc : listaTipoDocumentos) {
			tiposDeDocumento.put(tipoDoc.getNombre(), tipoDoc.getCodigo());
		}
		System.out.println("Cantidad tipos Documento: " + listaTipoDocumentos.size());
	}

	private void cargarAdministradorasSalud() {
		administradorasSalud.put("", "");
//		administradorasSalud.put("Sanitas EPS", "EPS001");
//		administradorasSalud.put("Sura EPS", "EPS002");
//		administradorasSalud.put("Coomeva", "EPS003");
//		administradorasSalud.put("Medimas", "EPS004");

		List<AdministradoraSalud> listAdministradoraSalud = ServicioListarAdministradoraSalud.ejecutar();
		for (AdministradoraSalud admSalud : listAdministradoraSalud) {
			administradorasSalud.put(admSalud.getNombre(), admSalud.getCodigo());
		}
	}

	private void cargarAdministradorasPension() {
		administradorasPension.put("", "");
//		administradorasPension.put("Protección", "AFP001");
//		administradorasPension.put("Porvenir", "AFP002");
//		administradorasPension.put("Colpensiones", "AFP003");

		List<AdministradoraPension> listAdministradoraPension = ServicioListarAdministradoraPension.ejecutar();
		for (AdministradoraPension admPension : listAdministradoraPension) {
			administradorasPension.put(admPension.getNombre(), admPension.getCodigo());
		}
	}

	public void registrar() {
		this.mensajeExcepcion = "";
		System.out.println("Registrando..." + numeroDocumento + " " + adminPension + " " + tipoDocumento + " "
				+ adminSalud + fechaPension + fechaSalud);

		int total = DroolsConfig.aplicarReglasDrools(this);
		System.out.println("Total: " + total);
		if (total > 0) {
			mostrarMensajeExcepcion();
			return;
		}
		this.mensajeExcepcion = guardarRegistro();
		mostrarMensajeExcepcion();
	}
	
	public String verAfiliaciones() {
		return "lista";
	}

	private void mostrarMensajeExcepcion() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, this.mensajeExcepcion, this.mensajeExcepcion));
	}

	private String guardarRegistro() {
		System.out.println("Invocando el back para guardar el registro");
		return ServicioCrearAfiliacion.ejecutar(this);
	}

	public String getMensajeExcepcion() {
		return mensajeExcepcion;
	}

	public void setMensajeExcepcion(String mensajeExcepcion) {
		this.mensajeExcepcion = mensajeExcepcion;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public Map<String, String> getAdministradorasPension() {
		return administradorasPension;
	}

	public void setAdministradorasPension(Map<String, String> administradorasPension) {
		this.administradorasPension = administradorasPension;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getAdminSalud() {
		return adminSalud;
	}

	public Map<String, String> getTiposDeDocumento() {
		return tiposDeDocumento;
	}

	public void setTiposDeDocumento(Map<String, String> tiposDeDocumento) {
		this.tiposDeDocumento = tiposDeDocumento;
	}

	public void setAdminSalud(String adminSalud) {
		this.adminSalud = adminSalud;
	}

	public Date getFechaSalud() {
		return fechaSalud;
	}

	public void setFechaSalud(Date fechaSalud) {
		this.fechaSalud = fechaSalud;
	}

	public String getAdminPension() {
		return adminPension;
	}

	public void setAdminPension(String adminPension) {
		this.adminPension = adminPension;
	}

	public Date getFechaPension() {
		return fechaPension;
	}

	public void setFechaPension(Date fechaPension) {
		this.fechaPension = fechaPension;
	}

	public Map<String, String> getAdministradorasSalud() {
		return administradorasSalud;
	}

	public void setAdministradorasSalud(Map<String, String> administradorasSalud) {
		this.administradorasSalud = administradorasSalud;
	}
}
