package com.wordpress.chhaichivon.repository;

import com.wordpress.chhaichivon.models.Pagination;
import com.wordpress.chhaichivon.models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 7/17/2017
 * TIME   : 12:14 AM
 */
@Repository
public class UserRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	private User getUserById(Long id){
		try{
			return sessionFactory.getCurrentSession().get(User.class,id);
		}catch (Exception e){
			e.printStackTrace();
		}
		return  null;
	}
	@Transactional
	public User getUserByEmail(String email){
		try{
			return (User) sessionFactory.getCurrentSession()
								 .createCriteria(User.class,"user")
								 .add(Restrictions.eq("user.username",email)).uniqueResult();
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	@Transactional
	public void saveUser(User user){
		try{
			sessionFactory.getCurrentSession().save(user);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Transactional
	public void updateUser(User user){
		try {
			sessionFactory.getCurrentSession().update(user);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Transactional
	public void deleteUser(Long id){
		try {
			User user = sessionFactory.getCurrentSession().load(User.class,id);
			if(user != null){
				sessionFactory.getCurrentSession().delete(user);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Transactional
	public List<User> getAllUsers(Pagination pagination){
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(User.class);
			criteria.setFirstResult(pagination.offset());
			criteria.setMaxResults(pagination.getLimit());
			List<User> users = (List<User>)criteria.list();
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 *
	 * 		USER LOGIN SECURITY
	 *
	 */

}
