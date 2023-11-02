package arus_frontend.http.fabrica;

import arus_frontend.bean.RegistroBean;
import arus_frontend.modelo.Afiliado;
import arus_frontend.modelo.TipoDocumento;

public class FabricaAfiliado {

	private FabricaAfiliado() {
	}

	public static Afiliado crearAfiliado(RegistroBean registroBean) {
		TipoDocumento tipoDocumento = FabricaTipoDocumento.crarTipoDocumento(registroBean);
		return new Afiliado(tipoDocumento, registroBean.getNumeroDocumento(), registroBean.getPrimerNombre(),
				registroBean.getSegundoNombre(), registroBean.getPrimerApellido(), registroBean.getSegundoApellido());
	}

}
