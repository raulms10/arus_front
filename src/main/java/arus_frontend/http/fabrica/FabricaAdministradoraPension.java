package arus_frontend.http.fabrica;

import java.util.Map;

import arus_frontend.bean.RegistroBean;
import arus_frontend.modelo.AdministradoraPension;

public class FabricaAdministradoraPension {

	private FabricaAdministradoraPension() {
	}

	public static AdministradoraPension crearAdministradoraPension(RegistroBean registroBean) {
		String codigoAdminPension = registroBean.getAdminPension();
		String nombreAdminPension = "";
		Map<String, String> mapAdminPension = registroBean.getAdministradorasPension();
		for (Map.Entry<String, String> entry : mapAdminPension.entrySet()) {
			if (entry.getValue().equals(codigoAdminPension)) {
				nombreAdminPension = entry.getKey();
				break;
			}
		}
		return new AdministradoraPension(codigoAdminPension, nombreAdminPension);
	}
}
