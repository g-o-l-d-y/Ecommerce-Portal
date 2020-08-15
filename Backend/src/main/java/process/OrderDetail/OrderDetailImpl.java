package process.OrderDetail;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("orderDAO")
@Transactional
public class OrderDetailImpl implements OrderDetailInterface{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean payment(OrderDetail orderDetail)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateCartStatus(String userName, int orderId, Date orderDate) {
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart set status='P', orderId=:ordId, orderDate=:date where userName=:uname and status='NP'");
		query.setParameter("ordId",orderId);
		query.setParameter("uname", userName);
		query.setParameter("date", orderDate);
		
		int row_eff=query.executeUpdate();
		
		if(row_eff>0)
			return true;
		else
			return false;
	}

}
