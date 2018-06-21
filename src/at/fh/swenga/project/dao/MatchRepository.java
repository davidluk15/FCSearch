package at.fh.swenga.project.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import at.fh.swenga.project.model.MatchModel;

@Repository
@Transactional
public interface MatchRepository extends JpaRepository<MatchModel,Integer>{

}