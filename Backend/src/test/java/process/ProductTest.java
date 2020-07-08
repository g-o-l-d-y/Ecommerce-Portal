package process;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import process.Model.Product.Product;
import process.Model.Product.ProductInterface;

public class ProductTest {
	static ProductInterface productDAO;
	@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("process");
	context.refresh();
	productDAO=(ProductInterface)context.getBean("productDAO");
	context.close();
	}
	
	@Ignore
	@Test
	public void addProductTest()
	{
	Product product=new Product();
	product.setProductName("Samsung Galaxy S10");
	product.setProductDesc("Android Version 10.0");
	product.setCategoryId(65);
	product.setPrice(49990.00);
	product.setStock(50);
	assertTrue("Problem in adding the Product",productDAO.addProduct(product)); 
	}
	
	@Ignore
	@Test
	public void getProductTest()
	{
	assertNotNull("Problem in get Product",productDAO.getProduct(70));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
	Product product=productDAO.getProduct(70);
	assertTrue("Problem in Deletion",productDAO.deleteProduct(product));
	}
	
	@Ignore
	@Test
	public void updateProductTest()
	{
	Product product=productDAO.getProduct(71);
	product.setPrice(49900.00);
	assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	@Test
	public void listProductsTest()
	{
	List<Product> listProducts=productDAO.listProducts();
	assertNotNull("No Products",listProducts);
	for(Product product:listProducts)
	{
	System.out.print(product.getProductId()+":::");
	System.out.print(product.getProductName()+":::");
	System.out.println(product.getProductDesc());
	}
	}
	
}
