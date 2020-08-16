package process.DAO;

import java.util.List;

import process.Model.Cart;

public interface CartDAO {
	
	public boolean addToCart(Cart cart);
	public boolean deleteCartItem(Cart cart);
	public boolean updateCart(Cart cart);
	public List<Cart> listCartItems(String username);
	public Cart getCart(int cartId);
	public List<Cart> listOrders(String username);
}
