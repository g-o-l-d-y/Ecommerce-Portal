package process;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import process.OrderDetail.OrderDetail;
import process.OrderDetail.OrderDetailInterface;

public class OrderDetailTest {

    static OrderDetailInterface orderDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("process");
		context.refresh();
		orderDAO=(OrderDetailInterface)context.getBean("orderDAO");
	}
	
	@Test
	public void testPayment()
	{
		OrderDetail orderInfo=new OrderDetail();
		orderInfo.setOrderDate(new java.util.Date());
		orderInfo.setTotalShoppingAmount(77000);
		orderInfo.setUserName("affy");
		orderInfo.setPaymentMode("COD");
		
		assertTrue("Problem in Order Payment",orderDAO.payment(orderInfo));
		assertTrue("Problem in Updating Payment",orderDAO.updateCartStatus(orderInfo.getUserName(),orderInfo.getOrderId()));
	}

}
