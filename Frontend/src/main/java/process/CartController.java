package process;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import process.Model.Cart.Cart;
import process.Model.Cart.CartInterface;
import process.Model.Product.Product;
import process.Model.Product.ProductInterface;

@Controller
public class CartController {
	
	@Autowired
	CartInterface cartDAO;
	
	@Autowired
	ProductInterface productDAO;
	
	@RequestMapping(value="/Cart")
	public String showCart(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		return "Cart";
	}
	
	@RequestMapping(value="/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		Product product=productDAO.getProduct(productId);
		String username=(String)session.getAttribute("username");
		
		Cart cartItem=new Cart();
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(quantity);
		cartItem.setStatus("NP");
		cartItem.setUserName(username);
		
		cartDAO.addToCart(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		return "Cart";
	}
	
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m,HttpSession session)
	{
		Cart cartItem=cartDAO.getCart(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		return "Cart";
	}
	
	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		Cart cartItem=cartDAO.getCart(cartItemId);
		cartItem.setQuantity(quantity);
		cartDAO.updateCart(cartItem);
		
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		return "Cart";
	}
	
	@RequestMapping(value="/confirmOrder")
	public String confirmOrder(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		m.addAttribute("listCartItems", cartItemList);
		
		m.addAttribute("total_Amount", this.totalCartValue(cartItemList));
		
		return "OrderConfirm";
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
