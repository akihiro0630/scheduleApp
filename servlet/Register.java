package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CheckResult;
import model.RegisterCheckLogic;
import model.RegisterLogic;
import model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションの削除
		HttpSession session = request.getSession();
		session.invalidate();

		//新規登録画面画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメーターの取得
		String id = request.getParameter("registerID");
		String pass = request.getParameter("registerPass");
		String name = request.getParameter("registerName");

		//新規登録者のインスタンスを生成
		User registerUser = new User(id,pass,name);

		//入力値チェック
		RegisterCheckLogic registerCheckLogic = new RegisterCheckLogic();
		CheckResult checkResult = registerCheckLogic.execute(registerUser);

		if(checkResult.getFlag() == false) {
			//入力チェックが通らなかったときの処理
			HttpSession session = request.getSession();
			session.setAttribute("errorMsg", checkResult.getMessage());

			//登録画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);

		}else {
			//入力チェックが通った場合の処理
			RegisterLogic registerLogic = new RegisterLogic();
			boolean registerResult = registerLogic.execute(registerUser);

			if(!registerResult) {
				//登録がうまくいかなかったとき、初期画面へフォワード
	            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
	            rd.forward(request, response);
			}else {
				// 登録成功時、セッションにアカウント情報を登録
	            HttpSession session = request.getSession();
	            session.setAttribute("registeredUser", registerUser);

	            //登録成功画面へフォワード
	            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/registerSuccess.jsp");
	            rd.forward(request, response);
			}



		}





	}

}
