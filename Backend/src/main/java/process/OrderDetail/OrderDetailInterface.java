package process.OrderDetail;

import java.util.Date;

public interface OrderDetailInterface {
	
	public boolean payment(OrderDetail orderDetail);
	public boolean updateCartStatus(String userName, int orderId, Date date);
}
