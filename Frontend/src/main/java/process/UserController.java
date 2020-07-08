package process;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import process.Model.User.User;
import process.Model.User.UserInterface;

@Controller
public class UserController {
	
	@Autowired
	UserInterface userDAO;
	
	/*
	  @RequestMapping(value="registerUser", method=RequestMethod.POST) 
	  public String registerUser(@RequestParam("customerName") String customerName,@RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("emailId")String emailId, @RequestParam("mobileNo")String mobileNo,@RequestParam("address") String address) 
	  { 
		  User user=new User();
		  user.setUserName(userName); 
		  user.setCustomerName(customerName);
		  user.setMobileNo(mobileNo); 
		  user.setPassword(password);
		  user.setEmailId(emailId); 
		  user.setAddress(address);
		  user.setRole("ROLE_USER"); 
		  user.setEnabled(true); 
		  userDAO.registerUser(user);
		  return "Login"; 
	  }
	  */
	 
	
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
	 
}
