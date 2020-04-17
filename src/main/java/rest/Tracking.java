package rest;

import service.EventService;
import util.Formatter;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("/tracking")
public class Tracking {

	@Inject
	private EventService eventService;

	@POST
	@Path("event")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject createNewEventFromJson(JsonObject json) {
		String ip = json.getString("ip");
		String type = json.getString("type");
		String link = json.getString("link");
		LocalDateTime time = LocalDateTime.parse(json.getString("time"));
		long id = eventService.addEvent(ip, type, link, time);
		return Formatter.eventIdToJson(id);
	}

	@GET
	@Path("logs")
	@Produces(MediaType.TEXT_PLAIN)
	public String printLast20() {
		return "Last20Logs";
	}
}
