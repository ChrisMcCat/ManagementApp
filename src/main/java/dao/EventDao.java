package dao;

import domain.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EventDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Event getById(Long id) {
		return this.entityManager.find(Event.class, id);
	}

	public long createNewEvent(Event event) {
		this.entityManager.persist(event);
		return event.getId();
	}

	public List<Event> findAll() {
		final Query query = entityManager.createQuery("SELECT e FROM Event e");
		return query.getResultList();
	}

	public long createNewEvent(String ip, String type, String link, String time) {
		Event event = new Event();
		event.setIp(ip);
		event.setType(type);
		event.setLink(link);
		event.setTime(time);
		this.entityManager.persist(event);
		return event.getId();
	}
}
