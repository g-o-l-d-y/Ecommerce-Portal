package process.OrderDetail;

public interface OrderDetailInterface {
	
	public boolean payment(OrderDetail orderDetail);
	public boolean updateCartStatus(String userName, int orderId);
}
