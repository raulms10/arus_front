package arus_frontend.http.servicio;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import arus_frontend.http.ClienteHttp;
import arus_frontend.modelo.TipoDocumento;

public class ServicioListarTipoDocumentos {
	
	private static final String CONTEXTO_TIPOS_DOCUMENTOS = "tipo_documentos";

	private ServicioListarTipoDocumentos() {}
	
	public static List<TipoDocumento> ejecutar() {
		ClienteHttp clienteHttp = new ClienteHttp(CONTEXTO_TIPOS_DOCUMENTOS);
		String docs = clienteHttp.doGET();
		Gson gson = new Gson();
		Type listaTipoDocumentoType = new TypeToken<List<TipoDocumento>>(){}.getType();
		return gson.fromJson(docs, listaTipoDocumentoType);
	}
}
