package service;

import dao.EventDao;
import domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Formatter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.time.LocalDateTime;

@Stateless
public class EventService {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	private static final String BASE_URL = "http://localhost:8080/ManagementApp-1.0-SNAPSHOT/api/";

	@Inject
	private EventDao eventDao;

	public long addEvent(String ip, String type, String link, LocalDateTime time) {
		Event event = new Event();
		event.setIp(ip);
		event.setType(type);
		event.setLink(link);
		event.setTime(time);
		return this.eventDao.createNewEvent(event);
	}

	public JsonObject sendJson(long id) {
		JsonObject json = Formatter.eventToJson(id);

		return json;
	}

}
