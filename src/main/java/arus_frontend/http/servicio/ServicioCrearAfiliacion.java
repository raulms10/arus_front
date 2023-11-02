package arus_frontend.http.servicio;

import arus_frontend.bean.RegistroBean;
import arus_frontend.http.ClienteHttp;
import arus_frontend.http.fabrica.FabricaAfiliacion;
import arus_frontend.modelo.Afiliacion;

public class ServicioCrearAfiliacion {
	
	private static final String CONTEXTO_AFILIACION = "afiliacion";
	private static final String MENSAJE_EXITOSO = "El registro ha sido exitoso";
	
	private ServicioCrearAfiliacion() {}

	public static String ejecutar(RegistroBean registroBean) {
		Afiliacion afiliacion = FabricaAfiliacion.crearAfiliacion(registroBean);
		ClienteHttp clienteHttp = new ClienteHttp(CONTEXTO_AFILIACION);
		String resultado = clienteHttp.doPost(afiliacion);
		System.out.println("Res: " + resultado);
		return ("".equals(resultado) ? MENSAJE_EXITOSO : resultado);
	}
}
