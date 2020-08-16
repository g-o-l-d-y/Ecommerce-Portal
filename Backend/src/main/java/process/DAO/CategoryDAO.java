package process.DAO;

import java.util.List;

import process.Model.Category;

public interface CategoryDAO {
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listCategories();
}