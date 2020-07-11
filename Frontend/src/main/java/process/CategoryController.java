package process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import process.Model.Category.Category;
import process.Model.Category.CategoryInterface;

@Controller
public class CategoryController {
	
	@Autowired 
	CategoryInterface categoryDAO;
	
	@RequestMapping("/Category")
	public String showCategory(Model m)
	{
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		return "Category";
	}
	
	@RequestMapping(value="addCategory" , method=RequestMethod.POST)
	public String addCategory(@RequestParam("categoryName") String categoryName, @RequestParam("categoryDesc") String categoryDesc, Model m)
	{
		Category c=new Category();
		c.setCategoryName(categoryName);
		c.setCategoryDesc(categoryDesc);
		categoryDAO.addCategory(c);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		System.out.println("Done");
		return "Category";
	}
	
	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category c= categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(c);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryId")int categoryId,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	{
		Category c=categoryDAO.getCategory(categoryId);
		
		c.setCategoryName(categoryName);
		c.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(c);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		Category c=categoryDAO.getCategory(categoryId);
		m.addAttribute("category",c);
		return "UpdateCategory";
	}
}
