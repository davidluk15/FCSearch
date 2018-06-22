package at.fh.swenga.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.project.model.PlayerModel;
import at.fh.swenga.project.model.UserRoleModel;
 
@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRoleModel, Integer>{
 
}

