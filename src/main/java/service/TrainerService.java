package service;

import dao.TrainerDao;
import domain.Trainer;
import dto.TrainerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class TrainerService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Inject
	private TrainerDao trainerDao;

	@Inject
	private TrainerMapper trainerMapper;

	public TrainerDto findById(long id) {
		Trainer trainer = trainerDao.findById(id).orElseThrow();
		return trainerMapper.mapEntityToDto(trainer);
	}
}
