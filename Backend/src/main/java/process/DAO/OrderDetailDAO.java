package process.DAO;

import java.util.Date;

import process.Model.OrderDetail;

public interface OrderDetailDAO {
	
	public boolean payment(OrderDetail orderDetail);
	public boolean updateCartStatus(String userName, int orderId, Date date);
}
