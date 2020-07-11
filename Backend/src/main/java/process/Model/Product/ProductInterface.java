package process.Model.Product;

import java.util.List;

public interface ProductInterface {

	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> listProducts();
	public List<Product> listProductsCategoryWise(int categoryId);
}

