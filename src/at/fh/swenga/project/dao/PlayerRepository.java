package at.fh.swenga.project.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.project.model.PlayerModel;

@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<PlayerModel, Integer> {
	

	
	List<PlayerModel>findByFirstName(String firstName);
	
	List<PlayerModel>findByLastName(String lastName);
	
	List<PlayerModel>findByPosition (String position);
	
	List<PlayerModel>findByAvailabelTrainingDays (String availabelTrainingDays);
	

	}

	

