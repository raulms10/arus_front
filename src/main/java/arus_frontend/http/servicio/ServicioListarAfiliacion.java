package arus_frontend.http.servicio;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import arus_frontend.http.ClienteHttp;
import arus_frontend.modelo.Afiliacion;

public class ServicioListarAfiliacion {

	private static final String CONTEXTO_ADMINISTRADORA_SALUD = "afiliacion";

	private ServicioListarAfiliacion() {}
	
	public static List<Afiliacion> ejecutar() {
		ClienteHttp clienteHttp = new ClienteHttp(CONTEXTO_ADMINISTRADORA_SALUD);
		String docs = clienteHttp.doGET();
		Gson gson = new Gson();
		Type listaAfiliacionType = new TypeToken<List<Afiliacion>>(){}.getType();
		return gson.fromJson(docs, listaAfiliacionType);
	}
}
