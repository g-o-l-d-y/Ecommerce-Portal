package process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import process.Model.Category.Category;
import process.Model.Category.CategoryInterface;

@Controller
public class CategoryController {
	
	@Autowired 
	CategoryInterface categoryDAO;
	
	@RequestMapping(value="addCategory" , method=RequestMethod.POST)
	public String addCategory(@RequestParam("categoryName") String categoryName, @RequestParam("categoryDesc") String categoryDesc)
	{
		Category c=new Category();
		c.setCategoryName(categoryName);
		c.setCategoryDesc(categoryDesc);
		categoryDAO.addCategory(c);
		System.out.println("Done");
		return "Category";
	}
	
	@RequestMapping(value="listCategories" , method=RequestMethod.GET)
	public String listCategories(Model model)
	{
		List<Category> listCategories=categoryDAO.listCategories();
		model.addAttribute("categoryList", listCategories);
		return "CategoryList";
	}
	
	@RequestMapping(value="deleteCategory",method=RequestMethod.POST)
	public String deleteCategory(@RequestParam("categoryId") int categoryId)
	{
		Category c= categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(c);
		return "Category";
	}
	
	@RequestMapping(value="editCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryId") int categoryId, @RequestParam("categoryName") String categoryName)
	{
		Category c=categoryDAO.getCategory(categoryId);
		c.setCategoryName(categoryName);
		categoryDAO.updateCategory(c);
		return "Category";
	}
}
