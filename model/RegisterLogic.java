package model;

import dao.RegisterDAO;

public class RegisterLogic {

	public boolean execute(User registerUser) {
		RegisterDAO dao = new RegisterDAO();
		boolean result = dao.register(registerUser);

		return result;
	}

}
