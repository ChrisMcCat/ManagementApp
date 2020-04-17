package dao;

import domain.Trainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class TrainerDao {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@PersistenceContext
	private EntityManager entityManager;

	public long add(Trainer trainer) {
		entityManager.persist(trainer);
		logger.info("Trainer added to DB");
		return trainer.getId();
	}

	public List<Trainer> findAll() {
		return entityManager.createQuery("SELECT t FROM Trainers t").getResultList();
	}

	public Optional<Trainer> findById(long id) {
		return Optional.ofNullable(entityManager.find(Trainer.class, id));
	}
}
