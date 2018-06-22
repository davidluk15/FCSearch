package at.fh.swenga.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.project.model.UserModel;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	protected EntityManager entityManager;
 
	public List<UserModel> findByUsername(String userName) {
		TypedQuery<UserModel> typedQuery = entityManager.createQuery("select u from UserModel u where u.userName = :name",
				UserModel.class);
		typedQuery.setParameter("name", userName);
		List<UserModel> typedResultList = typedQuery.getResultList();
		return typedResultList;
	}
 
	public void persist(UserModel user) {
		entityManager.persist(user);
	}
	
}
