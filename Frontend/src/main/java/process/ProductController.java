package process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import process.Model.Product.Product;
import process.Model.Product.ProductInterface;

@Controller
public class ProductController {
	
	@Autowired
	ProductInterface productDAO;
	
	@RequestMapping(value="addProduct" , method=RequestMethod.POST)
	public String addProductTest(@RequestParam("categoryId") int categoryId, @RequestParam("productName") String productName, @RequestParam("productDesc") String productDesc, @RequestParam("stock") int stock, @RequestParam("price") double price)
	{
		Product p=new Product();
		p.setCategoryId(categoryId);
		p.setProductName(productName);
		p.setProductDesc(productDesc);
		p.setStock(stock);
		p.setPrice(price);
		productDAO.addProduct(p);
		return "Product";
	}
	
	@RequestMapping(value="deleteProduct",method=RequestMethod.POST)
	public String deleteProduct(@RequestParam("productId") int productId)
	{
		Product p=productDAO.getProduct(productId);
		productDAO.deleteProduct(p);
		return "Product";
	}
	
	@RequestMapping(value="displayProducts" ,method=RequestMethod.POST)
	public String displayProducts(Model model)
	{
		List<Product> listProducts=productDAO.listProducts();
		model.addAttribute("productList", listProducts);
		return "ProductList";
	}
	
}
