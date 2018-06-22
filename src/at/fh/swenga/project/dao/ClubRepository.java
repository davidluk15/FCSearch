package at.fh.swenga.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.project.model.ClubModel;


@Repository

public interface ClubRepository extends JpaRepository<ClubModel, Integer> {

	@Transactional
	ClubModel findByClubName(String clubName);

	ClubModel getClubByClubId(int clubId);
	




}
