package process.DAO;

import process.Model.User;

public interface UserDAO {
	
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String userName);
}
