package arus_frontend.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import arus_frontend.modelo.ErrorHttp;


public class ClienteHttp {
	
	private static final String ENDPOINT_SERVICIOS = "http://localhost/adn_arus/";
	
	private String urlServicio;
	
	public ClienteHttp(String contextoServicio) {
		this.urlServicio = ENDPOINT_SERVICIOS + contextoServicio;
	}

	public String doGET() {
		String respuestaServicio = "";
		try {
			// URL de la API o página web a la que quieres hacer la solicitud GET
			URL url = new URL(this.urlServicio);

			// Abrir conexión HTTP
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Obtener respuesta
			int responseCode = connection.getResponseCode();
			System.out.println("Código de respuesta: " + responseCode);

			// Leer la respuesta del servidor
			BufferedReader reader;
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}
			
			String line;
			StringBuilder response = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Imprimir la respuesta
			System.out.println("Respuesta del servidor:" + response.toString());
			respuestaServicio = response.toString();
			
			// Cerrar la conexión
			connection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
			respuestaServicio = e.getMessage();
		}
		return respuestaServicio;
	}

	public String doPost(Object bodyRequest) {
		String respuestaServicio = "";
		try {
			// URL de la API a la que quieres hacer la solicitud POST
			URL url = new URL(this.urlServicio);

			// Abrir conexión HTTP
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

			// Habilitar el envío de datos en el cuerpo de la solicitud
			connection.setDoOutput(true);

			String jsonInputString = this.obtenerJsonString(bodyRequest);
			System.out.println("Body: " + jsonInputString);

			// Escribir el JSON en el cuerpo de la solicitud
			DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
			writer.write(jsonInputString);
			outputStream.flush();
			writer.close();
			outputStream.close();

			// Obtener respuesta
			int responseCode = connection.getResponseCode();
			System.out.println("Codigo de respuesta: " + responseCode + " " + connection.getContentType());

			// Leer la respuesta del servidor
			BufferedReader reader;
			if(responseCode == HttpURLConnection.HTTP_OK) {
				return respuestaServicio;
				//reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}
			
			String line;
			StringBuilder response = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			respuestaServicio = response.toString();
			System.out.println("Respuesta del servidor:" + response.toString());
			// Imprimir la respuesta
			if ("application/json".equals(connection.getContentType())) {
				Gson gson = new Gson();
				ErrorHttp error = gson.fromJson(respuestaServicio, ErrorHttp.class);
				respuestaServicio = error.getMensaje();
			}

			// Cerrar la conexión
			connection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
			respuestaServicio = e.getMessage();
		}
		return respuestaServicio;
	}
	
	private String obtenerJsonString(Object bodyRequest) {		
		Gson gson = new Gson();
		JsonObject jsonObject = gson.toJsonTree(bodyRequest).getAsJsonObject();
		return jsonObject.toString();
	}
}
