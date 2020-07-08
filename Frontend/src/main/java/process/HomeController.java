package process;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import process.Model.User.User;

@Controller
public class HomeController {

	@RequestMapping(value= {"/Home","/"})
	public String showHome()
	{
		return "Home";
	}
	
	
	@RequestMapping("/Login") 
	public String showlogin() 
	{ 
		return "Login"; 
	}
	 
	@RequestMapping("/Category")
	public String showCategory()
	{
		return "Category";
	}
	
	@RequestMapping("/Product")
	public String showProduct()
	{
		return "Product";
	}
	
	@RequestMapping("/Supplier")
	public String showSupplier()
	{
		return "Supplier";
	}
	
	 /*
		@RequestMapping("/Register")
		public String showRegister()
		{
			return "Register";
		}*/
	
	@RequestMapping(value="Register", method=RequestMethod.GET) 
	public String showRegister(Map<String, Object> model) 
	{
		model.put("user", new User());
		return "Register"; 
	}
	
	
}
