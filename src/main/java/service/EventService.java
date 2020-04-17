package service;

import dao.EventDao;
import domain.Event;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Stateless
public class EventService {

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
}
