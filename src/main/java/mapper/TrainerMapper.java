package mapper;

import domain.Trainer;
import dto.TrainerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrainerMapper {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	public TrainerDto mapEntityToDto(Trainer trainerEntity) {

		logger.debug("Trainer mapping to DTO");

		TrainerDto trainerDto = new TrainerDto();

		trainerDto.setId(trainerEntity.getId());
		trainerDto.setName(trainerEntity.getName());
		trainerDto.setSurname(trainerEntity.getSurname());
		trainerDto.setPhoneNumber(trainerEntity.getPhoneNumber());
		trainerDto.setMail(trainerEntity.getMail());

		logger.debug("Trainer mapping to DTO -> all set for Trainer ID {}", trainerDto.getId());

		return trainerDto;
	}
}
