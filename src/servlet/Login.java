package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//セッションの初期化
		HttpSession session = request.getSession();
		session.setAttribute("loginUser",null);

		//リクエストパラメーターの取得
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		//Userインスタンスの生成
		User user = new User(id, pass);

		//ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		User loginUser = loginLogic.execute(user);

		//ログイン成功時
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
		}

		//ログイン結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);

	}

}
