package process;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import process.Cart.Cart;
import process.Cart.CartInterface;

public class CartTest {

	static CartInterface cartDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("process");
		context.refresh();
		cartDAO=(CartInterface)context.getBean("cartDAO");
	}
	
	@Ignore
	@Test
	public void addToCartTest() {
		Cart cart=new Cart();
		cart.setOrderId(10);
		cart.setProductId(10);
		cart.setProductName("Vivo S5");
		cart.setPrice(27000);
		cart.setQuantity(1);
		cart.setUserName("Lidya18");
		cart.setStatus("NP");
		assertTrue("Problem in adding the Cart",cartDAO.addToCart(cart)); 
	}
	
	@Ignore
	@Test
	public void deleteCartItem()
	{
		Cart cart=cartDAO.getCart(259);
		assertTrue("Problem in Deletion",cartDAO.deleteCartItem(cart));
	}
	
	@Ignore
	@Test
	public void updateCartTest()
	{
		Cart cart=cartDAO.getCart(260);
		cart.setPrice(25000);
		assertTrue("Problem in Updation",cartDAO.updateCart(cart));
	}
	
	@Ignore
	@Test
	public void getCartTest()
	{
		assertNotNull("Problem in get Cart",cartDAO.getCart(260));
	}
	
	@Test
	public void listCartItemsTest()
	{
		List<Cart> listItems=cartDAO.listCartItems("Lidya18");
		assertNotNull("No Cart Items",listItems);
		for(Cart cart:listItems)
		{
		System.out.print(cart.getCartId()+":::");
		System.out.print(cart.getUserName()+":::");
		System.out.println(cart.getOrderId());
		}
	}
}
