package at.fh.swenga.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.project.model.PlayerModel;

@Repository
@Transactional
public interface PlayerRepository extends JpaRepository<PlayerModel, Integer> {
	
}
