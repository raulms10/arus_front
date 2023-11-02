package arus_frontend.http.servicio;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import arus_frontend.http.ClienteHttp;
import arus_frontend.modelo.AdministradoraSalud;

public class ServicioListarAdministradoraSalud {

	private static final String CONTEXTO_ADMINISTRADORA_SALUD = "administradoras_salud";

	private ServicioListarAdministradoraSalud() {}
	
	public static List<AdministradoraSalud> ejecutar() {
		ClienteHttp clienteHttp = new ClienteHttp(CONTEXTO_ADMINISTRADORA_SALUD);
		String docs = clienteHttp.doGET();
		Gson gson = new Gson();
		Type listaAdministradoraSaludType = new TypeToken<List<AdministradoraSalud>>(){}.getType();
		return gson.fromJson(docs, listaAdministradoraSaludType);
	}
	
}
