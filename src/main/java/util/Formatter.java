package util;

import dao.EventDao;
import domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.time.format.DateTimeFormatter;

public class Formatter {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Inject
	private EventDao eventDao;

	public static JsonObject eventToJson(long id) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		Event event = new Event();
		String ip = event.getIp();
		String type = event.getType();
		String link = event.getLink();
		String time = event.getTime();
		builder.add("id", String.valueOf(id));
		builder.add("ip", ip);
		builder.add("type", type);
		builder.add("link", link);
		builder.add("time", time);
		return builder.build();
	}

	public static JsonObject eventIdToJson(long id) {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("id", id);
		return builder.build();
	}
}
