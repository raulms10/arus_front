package arus_frontend.http.fabrica;

import java.text.SimpleDateFormat;

import arus_frontend.bean.RegistroBean;
import arus_frontend.modelo.AdministradoraPension;
import arus_frontend.modelo.AdministradoraSalud;
import arus_frontend.modelo.Afiliacion;
import arus_frontend.modelo.Afiliado;

public class FabricaAfiliacion {

	private FabricaAfiliacion() {
	}

	public static Afiliacion crearAfiliacion(RegistroBean registroBean) {
		Afiliado afiliado = FabricaAfiliado.crearAfiliado(registroBean);
		AdministradoraPension administradoraPension = FabricaAdministradoraPension
				.crearAdministradoraPension(registroBean);
		AdministradoraSalud administradoraSalud = FabricaAdministradoraSalud.crearAdministradoraSalud(registroBean);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return new Afiliacion(null, afiliado, administradoraSalud, dateFormat.format(registroBean.getFechaSalud()),
				administradoraPension, dateFormat.format(registroBean.getFechaPension()));
	}

}
