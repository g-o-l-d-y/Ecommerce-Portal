package process.Model.Category;

import java.util.List;

public interface CategoryInterface {
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listCategories();
}