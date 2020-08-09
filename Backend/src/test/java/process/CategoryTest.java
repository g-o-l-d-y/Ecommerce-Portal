package process;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import process.Category.Category;
import process.Category.CategoryInterface;

public class CategoryTest {
	static CategoryInterface categoryDAO;
	@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("process");
	context.refresh();
	categoryDAO=(CategoryInterface)context.getBean("categoryDAO");
	context.close();
	}
	
	@Test
	public void addCategoryTest()
	{
	Category category=new Category();
	category.setCategoryName("Mobiles");
	category.setCategoryDesc("Only Android Versions above 5.0");
	assertTrue("Problem in adding the Category",categoryDAO.addCategory(category)); 
	}
	@Ignore
	@Test
	public void getCategoryTest()
	{
	assertNotNull("Problem in get Category",categoryDAO.getCategory(1));
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
	Category category=categoryDAO.getCategory(2);
	assertTrue("Problem in Deletion",categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
	Category category=categoryDAO.getCategory(2);
	category.setCategoryName("Mobiles and Tablets");
	assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
	}

	@Test
	public void listCategoriesTest()
	{
	List<Category> listCategories=categoryDAO.listCategories();
	assertNotNull("No Categories",listCategories);
	for(Category category:listCategories)
	{
	System.out.print(category.getCategoryId()+":::");
	System.out.print(category.getCategoryName()+":::");
	System.out.println(category.getCategoryDesc());
	}
	}
}

