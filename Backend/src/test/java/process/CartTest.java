package process;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.util.Pair;
import process.DAO.CartDAO;
import process.Model.Cart;

public class CartTest {

	static CartDAO cartDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("process");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
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
	
	@Ignore
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
	
	@Test
	public void listOrdersTest()
	{
		List<Cart> ordersList = cartDAO.listOrders("affy");
		assertNotNull("No orders",ordersList);
		for(Cart cart:ordersList)
		{
		System.out.print(cart.getCartId()+":::");
		System.out.print(cart.getUserName()+":::");
		System.out.println(cart.getOrderId());
		System.out.println(cart.getOrderDate());
		}
		Collections.reverse(ordersList);
		ArrayList<Pair<Integer,Date>> orders=new ArrayList<Pair<Integer,Date>>();

		for(int i=0;i<ordersList.size();i++)
		{
			Pair < Integer, Date> ans = new Pair <Integer,Date> (ordersList.get(i).getOrderId(),ordersList.get(i).getOrderDate()); 
			if(!(orders.contains(ans)))
				orders.add(ans);
		}

		for(int i=0;i<orders.size();i++)
			System.out.println(orders.get(i).getKey()+" "+orders.get(i).getValue());
	}
}
