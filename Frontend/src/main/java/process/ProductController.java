package process;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import process.Model.Category.Category;
import process.Model.Category.CategoryInterface;
import process.Model.Product.Product;
import process.Model.Product.ProductInterface;

@Controller
public class ProductController {
	
	@Autowired
	ProductInterface productDAO;
	@Autowired
	CategoryInterface categoryDAO;
	
	int prodId;
	
	@RequestMapping("/Product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		List<Product> productList=productDAO.listProducts();
		
		m.addAttribute("product", product);
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		LinkedHashMap<Integer,String> categoryList1=new LinkedHashMap<Integer,String>();
		
		for(Category category:categoryList)
		{
			categoryList1.put(category.getCategoryId(), category.getCategoryName());
		}
		return categoryList1;
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST, consumes="multipart/form-data")
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("productImage") MultipartFile filedet, Model m)
	{
		Product product1=new Product();
		m.addAttribute("product", product1);
		productDAO.addProduct(product);
		
		//Image Adding
		
		String imagePath="C:\\Users\\goldy\\git\\Ecommerce-Portal\\Frontend\\src\\main\\webapp\\resources\\images\\";
		imagePath=imagePath+String.valueOf(product.getProductId())+".png";
		
		File imageFile=new File(imagePath);
		
		if(!filedet.isEmpty())
		{
			try
			{
				
				byte fileBuffer[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				System.out.println("Uploaded");
				bs.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("Error Occured While File Uploading");
		}
		
		//Image Adding Completed
		List<Product> productList=productDAO.listProducts();
		
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "Product";
	}
	
	/*
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId,Model m)
	{
		Product p=productDAO.getProduct(productId);
		m.addAttribute("product",p);
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST, consumes="multipart/form-data")
	public String updateProduct(@RequestParam("productId")int productId,@RequestParam("productName")String productName, 
			@RequestParam("productDesc")String productDesc, @RequestParam("stock") int stock, @RequestParam("price") double price,
			 @RequestParam("supplierId") int supplierId, @RequestParam("productImage") MultipartFile filedet, Model m)
	{
		Product product1=new Product();
		m.addAttribute("product", product1);
		Product p=productDAO.getProduct(productId);
		
		p.setProductName(productName);
		p.setProductDesc(productDesc);
		p.setPrice(price);
		p.setStock(stock);
		p.setSupplierId(supplierId);
		p.setproductImage(filedet);
		
		String imagePath="C:\\Users\\goldy\\git\\Ecommerce-Portal\\Frontend\\src\\main\\webapp\\resources\\images\\";
		imagePath=imagePath+String.valueOf(productId)+".jpg";
		
		File imageFile=new File(imagePath);
		
		if(!filedet.isEmpty())
		{
			try
			{
				byte fileBuffer[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				System.out.println("Uploaded");
				bs.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("Error Occured While File Uploading");
		}
		
		productDAO.updateProduct(p);
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		System.out.println("Updation");
		
		return "Product";
	}
	*/
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		prodId=productId;
		Product product1=productDAO.getProduct(productId);
		m.addAttribute("product", product1);
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/addProduct",method=RequestMethod.POST, consumes="multipart/form-data")
	public String updateProduct(@ModelAttribute("product")Product product,@RequestParam("productImage") MultipartFile filedet,Model m)
	{
		int productId=prodId;
		System.out.println(productId);
		Product p=productDAO.getProduct(productId);
		double price=product.getPrice();
		int stock=product.getStock();
		int supplierId=product.getSupplierId();
		String productName=product.getProductName();
		String productDesc=product.getProductDesc();
		int categoryId=product.getCategoryId();
		
		p.setProductName(productName);
		p.setProductDesc(productDesc);
		p.setPrice(price);
		p.setStock(stock);
		p.setSupplierId(supplierId);
		p.setproductImage(filedet);
		p.setCategoryId(categoryId);
		
		productDAO.updateProduct(p);
		
		String imagePath="C:\\Users\\goldy\\git\\Ecommerce-Portal\\Frontend\\src\\main\\webapp\\resources\\images\\";
		imagePath=imagePath+String.valueOf(productId)+".png";
		
		File image=new File(imagePath);
		image.delete();
		File imageFile=new File(imagePath);
		
		if(!filedet.isEmpty())
		{
			try
			{
				byte fileBuffer[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				System.out.println("Uploaded");
				bs.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("Error Occured While File Uploading");
		}
		
		
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		System.out.println("Updated");
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		return "Product";
	}
	
	/*
	@RequestMapping(value="displayProducts" ,method=RequestMethod.POST)
	public String displayProducts(Model model)
	{
		List<Product> listProducts=productDAO.listProducts();
		model.addAttribute("productList", listProducts);
		return "ProductList";
	}
	*/
	
	@RequestMapping(value="/productDisplay")
	public String productDisplay(Model m)
	{
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		return "ProductDisplay";
	}
	
	@RequestMapping(value="/totalProductDisplay/{productId}")
	public String totalProductDisplay(@PathVariable("productId")int productId,Model m)
	{
		Product product1=productDAO.getProduct(productId);
		m.addAttribute("product", product1);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		return "TotalProductDisplay";
	}
	
}
