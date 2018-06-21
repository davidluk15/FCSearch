package at.fh.swenga.project.dao;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.project.model.ClubModel;


@Repository

public interface ClubRepository extends JpaRepository<ClubModel, Integer> {

	@Transactional
	ClubModel findByClubName(String clubName);

	ClubModel getClubByClubId(int clubId);

	void addClub(@Valid ClubModel newClubModel);

}
