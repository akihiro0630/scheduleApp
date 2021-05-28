package model;

import dao.UserDAO;

public class LoginLogic {
	public User execute(User user) {

		UserDAO dao = new UserDAO();
		User loginUser = dao.searchUser(user);

		return loginUser;
	}

}
