package service;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class LogService {

	private final static String BASE_URL = "http://localhost:8080/ManagementApp-1.0-SNAPSHOT/api/";

	private JsonObject getLogs() {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client
				.target(BASE_URL)
				.path("tracking")
				.path("logs");
		try (Response responseTarget = webTarget.request().get()) {
			if (Response.Status.OK.equals(responseTarget.getStatusInfo())) {
				JsonObject json = responseTarget.readEntity(JsonObject.class);
				return json;
			}
			int status = responseTarget.getStatus();
			throw new IllegalStateException("Error: " + status);
		}
	}
}
