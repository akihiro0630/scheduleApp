package model;

import java.util.regex.Pattern;

import dao.UserDAO;

public class RegisterCheckLogic {


	public CheckResult execute(User user) {

		String id = user.getId();
		String pass = user.getPass();
		String name = user.getName();

		//チェック用パラメーター
		boolean flag = true;
		String message = null;

		//入力チェック
		if(id == null || id == "") {
			flag = false;
			message = "メールアドレスは入力が必須です。";
		}else if(pass == null || pass == "") {
			flag = false;
			message = "パスワードは入力が必須です。";
		}else if(name == null || name == "") {
			flag = false;
			message = "氏名は入力が必須です。";
		}else if(idCheck(id) == false) {
			flag = false;
			message = "メールアドレスの形式が不正です。";
		}

		//重複チェック
		if(flag) {
			UserDAO userDAO = new UserDAO();
			flag = userDAO.searchUser(id);
			if(!flag) {
				message = "入力いただいたメールアドレスはすでに登録済みです。";
			}
		}

		CheckResult checkResult = new CheckResult(flag,message);

		return checkResult;
	}

	public boolean idCheck(String id) {
		String mailFormat = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";
		Pattern pattern = Pattern.compile(mailFormat);
	    boolean result = pattern.matcher(id).matches();
		return result;
	}



}
