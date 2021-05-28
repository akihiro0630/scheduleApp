package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ChangeScheduleLogic;
import model.User;

/**
 * Servlet implementation class ScheduleChange2
 */
@WebServlet("/ScheduleChange2")
public class ScheduleChange2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleChange2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストスコープの変数を取り出す
		String reSchedule = request.getParameter("reSchedule");
		String sTime = request.getParameter("sTime");
		String ymd = request.getParameter("ymd");

		//セッションからログインユーザー情報の取り出し
		HttpSession session =  request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		String id = loginUser.getId();

		//スケジュール変更のロジックを実行
		ChangeScheduleLogic logic = new ChangeScheduleLogic();
		boolean result = logic.execute(id,ymd,reSchedule,sTime);

		//戻り値と日付情報をリクエストパラメーターにセット
		request.setAttribute("result", result);
		request.setAttribute("ymd", ymd);

		//変更結果表示画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/changeScheduleResult.jsp");
		dispatcher.forward(request, response);

	}

}
