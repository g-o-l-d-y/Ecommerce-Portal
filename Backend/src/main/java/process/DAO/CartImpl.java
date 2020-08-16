package process.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import process.Model.Cart;


@Repository("cartDAO")
@Transactional
public class CartImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory; 
	
	public boolean addToCart(Cart cart) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean deleteCartItem(Cart cart)
	{
		try
		{
		sessionFactory.getCurrentSession().delete(cart);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean updateCart(Cart cart) 
	{
		try
		{
		sessionFactory.getCurrentSession().update(cart);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Cart getCart(int cartId) 
	{
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class,cartId);
		session.close();
		return cart;
	}

	public List<Cart> listCartItems(String username)
	{
		Session session=sessionFactory.openSession();
		Query query =session.createQuery("from Cart where userName=:uname and status='NP'");
		query.setParameter("uname", username);
		List<Cart> cartItemList=query.list();
		session.close();
		return cartItemList;
	}

	public List<Cart> listOrders(String username) {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Cart where userName=:uname and status='P'");
		query.setParameter("uname", username);
		List<Cart> ordersList=query.list();
		session.close();
		return ordersList;
	}
}
