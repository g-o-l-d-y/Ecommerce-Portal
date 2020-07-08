package process.Model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserImpl implements UserInterface{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean registerUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		return false;
		}
	}
	
	public boolean updateUser(User user) {
		
		try
		{
			System.out.println("Here");
			sessionFactory.getCurrentSession().update(user);
			System.out.println("Here2");
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	
	public User getUser(String userName) {
		
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class, userName);
		session.close();
		return user;
	}
	
	

}
