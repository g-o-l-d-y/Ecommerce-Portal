package process;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import process.Cart.Cart;
import process.Cart.CartInterface;
import process.OrderDetail.OrderDetail;
import process.OrderDetail.OrderDetailInterface;
import process.User.UserInterface;

@Controller
public class PaymentController {

	@Autowired
	CartInterface cartDAO;
	
	@Autowired
	UserInterface userDAO;
	
	@Autowired
	OrderDetailInterface orderDAO;
	
	@RequestMapping(value="/payment")
	public String makePayment(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		m.addAttribute("address", userDAO.getUser(username).getAddress());
		
		return "Payment";
	}
	
	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String generateReceipt(@RequestParam("paymentMode")String paymentMode,Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		double total_Amount = this.totalCartValue(cartItemList);
		
		m.addAttribute("total_Amount",total_Amount);
		m.addAttribute("address", userDAO.getUser(username).getAddress());
		
		OrderDetail orderDetail=new OrderDetail();
		orderDetail.setTotalShoppingAmount(total_Amount);
		orderDetail.setUserName(username);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPaymentMode(paymentMode);
		
		if(orderDAO.payment(orderDetail))
		{
			System.out.println("Payment done");
			orderDAO.updateCartStatus(username, orderDetail.getOrderId());
			System.out.println("Cart Updated");
		}
		
		m.addAttribute("order", orderDetail);
		m.addAttribute("address", userDAO.getUser(username).getAddress());
		
		return "Receipt";
	}
	
	public double totalCartValue(List<Cart> cartItemList)
	{
		double totalCost=0;
		int i=0;
		
		while(i<cartItemList.size())
		{
			Cart cartItem=cartItemList.get(i);
			totalCost=totalCost+(cartItem.getPrice()*cartItem.getQuantity());
			i++;
		}
		
		return totalCost;
	}
}
