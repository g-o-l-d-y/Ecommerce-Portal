package process.Model.User;

public interface UserInterface {
	
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String userName);
}
