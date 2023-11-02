package arus_frontend.http.servicio;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import arus_frontend.http.ClienteHttp;
import arus_frontend.modelo.AdministradoraPension;

public class ServicioListarAdministradoraPension {

	private static final String CONTEXTO_ADMINISTRADORA_PENSION = "administradoras_pension";

	private ServicioListarAdministradoraPension() {
	}

	public static List<AdministradoraPension> ejecutar() {
		ClienteHttp clienteHttp = new ClienteHttp(CONTEXTO_ADMINISTRADORA_PENSION);
		String docs = clienteHttp.doGET();
		Gson gson = new Gson();
		Type listaAdministradoraPensionType = new TypeToken<List<AdministradoraPension>>() {
		}.getType();
		return gson.fromJson(docs, listaAdministradoraPensionType);
	}
}
