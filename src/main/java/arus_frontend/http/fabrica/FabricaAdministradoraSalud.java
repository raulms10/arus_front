package arus_frontend.http.fabrica;

import java.util.Map;

import arus_frontend.bean.RegistroBean;
import arus_frontend.modelo.AdministradoraSalud;

public class FabricaAdministradoraSalud {

	private FabricaAdministradoraSalud() {
	}

	public static AdministradoraSalud crearAdministradoraSalud(RegistroBean registroBean) {
		String codigoAdminSalud = registroBean.getAdminSalud();
		String nombreAdminSalud = "";
		Map<String, String> mapAdminSalud = registroBean.getAdministradorasSalud();
		for (Map.Entry<String, String> entry : mapAdminSalud.entrySet()) {
			if (entry.getValue().equals(codigoAdminSalud)) {
				nombreAdminSalud = entry.getKey();
				break;
			}
		}
		return new AdministradoraSalud(codigoAdminSalud, nombreAdminSalud);
	}
}
