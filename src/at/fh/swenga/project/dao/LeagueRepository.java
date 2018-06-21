package at.fh.swenga.project.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import at.fh.swenga.project.model.LeagueModel;

@Repository
@Transactional
public interface LeagueRepository extends JpaRepository<LeagueModel,Integer>{

}