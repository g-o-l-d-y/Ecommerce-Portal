package process;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import process.User.User;
import process.User.UserInterface;


public class UserTest {
	
	static UserInterface userDAO;
	@BeforeClass
	public static void executeFirst()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("process");
	context.refresh();
	userDAO=(UserInterface)context.getBean("userDAO");
	context.close();
	}
	
	@Ignore
	@Test
	public void registerUserTest()
	{
		User user=new User();
		user.setUserName("lidya18");
		user.setCustomerName("Lidya Dashwood");
		user.setAddress("Kolathur, Chennai");
		user.setEmailId("lidya18@gmail.com");
		user.setMobileNo("9898989898");
		user.setPassword("abcde");
		user.setRole("ROLE_ADMIN");
		user.setEnabled(true);
		assertTrue("Problem in registering", userDAO.registerUser(user));
	}
	
	@Test
	public void updateUserTest()
	{
		User user= new User();
		user=userDAO.getUser("lidya18");
		user.setCustomerName("Lidya Dashwood");
		assertTrue("Update failed", userDAO.updateUser(user));
	}
}
