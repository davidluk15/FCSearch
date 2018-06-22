package at.fh.swenga.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.project.model.ClubModel;


@Repository
@Transactional
public interface ClubRepository extends JpaRepository<ClubModel, Integer> {

	
	ClubModel findByClubName(String clubName);

	ClubModel getClubByClubId(int clubId);
	
	List<ClubModel>findByLocation(String location);
	
	List<ClubModel>findByTrainingDays(String trainingDays);
	
	List<ClubModel>findByTrainingTime(String trainingTime);


	
	




}
