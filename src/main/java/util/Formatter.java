package util;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	public static JsonObject eventToJson(String ip, String type, String link, LocalDateTime time) {
		JsonObjectBuilder builder = Json.createObjectBuilder();

		builder.add("ip", ip);
		builder.add("type", type);
		builder.add("link", link);
		builder.add("time", String.valueOf(time));
		return builder.build();
	}

	public static String eventIdToJson(String id, long id1) {
		return null;
	}
}
