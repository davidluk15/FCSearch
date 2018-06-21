package at.fh.swenga.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import at.fh.swenga.project.model.ClubPlayerModel;

@Repository
@Transactional
public interface ClubPlayerRepository extends JpaRepository<ClubPlayerModel,Integer>{

}
