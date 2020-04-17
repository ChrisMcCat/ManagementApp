package dao;

import domain.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
