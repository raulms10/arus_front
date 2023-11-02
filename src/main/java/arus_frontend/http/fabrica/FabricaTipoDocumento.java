package arus_frontend.http.fabrica;

import java.util.Map;

import arus_frontend.bean.RegistroBean;
import arus_frontend.modelo.TipoDocumento;

public class FabricaTipoDocumento {
	
	private FabricaTipoDocumento() {}

	public static TipoDocumento crarTipoDocumento(RegistroBean registroBean) {
		String codigoTipoDocumento = registroBean.getTipoDocumento();
		String nombreTipoDocumento = "";
		Map<String, String> mapTipos = registroBean.getTiposDeDocumento();
		for (Map.Entry<String, String> entry : mapTipos.entrySet()) {
		    if (entry.getValue().equals(codigoTipoDocumento)) {
				nombreTipoDocumento = entry.getKey();
				break;
			}
		}
		return new TipoDocumento(codigoTipoDocumento, nombreTipoDocumento);
	}
	
	
}
