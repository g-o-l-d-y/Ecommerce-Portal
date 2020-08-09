package process;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import process.Product.Product;
import process.Product.ProductInterface;
import process.User.User;
import process.User.UserInterface;

@Controller
public class UserController {
	
	@Autowired
	UserInterface userDAO;
	
	@Autowired
	ProductInterface productDAO;
	
	
	@RequestMapping("/success")
	public String loginSuccess(HttpSession session,Model m)
	{
		System.out.println("Login Success");
		String page="";
		
		boolean loggedIn=false;
		
		//This object will contain the logged in user detail like username and role.
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		System.out.println(sContext);
		String username=authentication.getName();
		
		//Getting all the roles associated with the user
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				List<Product> productList=productDAO.listProducts();
				m.addAttribute("productList", productList);
				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
		}
		return page;
      }
	  
	
	  @RequestMapping(value="registerUser", method=RequestMethod.POST)
	  public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> model) 
	  {
	   		if(result.hasErrors()) 
	   		{ 
	   			return "Register"; 
	   		} 
	   		user.setEnabled(true);
	   		user.setRole("ROLE_USER");
	   		userDAO.registerUser(user);
	   		return "Login";
	  }
	  
	  	@RequestMapping("/perform_logout")
		public String loggingout(HttpSession session)
		{
			session.invalidate();
			return "Login";
		}
	 
}
