package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DaySchedule;
import model.SearchScheduleLogic;
import model.User;

/**
 * Servlet implementation class ScheduleAccsess
 */
@WebServlet("/ScheduleAccsess")
public class ScheduleAccsess extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAccsess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメーターの取得
		String ymd = request.getParameter("ymd");
		HttpSession session = request.getSession();
		session.setAttribute("ymd",ymd);

		//セッションの取得
		User loginUser = (User)session.getAttribute("loginUser");

		//DBの検索logic→DAO→DTO→Servlet
		SearchScheduleLogic searchScheduleLogic = new SearchScheduleLogic();
		DaySchedule daySchedule = searchScheduleLogic.searchDaySchedule(loginUser,ymd);

		//リクエストパラメーターにセット
		request.setAttribute("daySchedule", daySchedule);

		//カレンダー登録画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerSchedule.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメーターの取得
		String ymd = request.getParameter("ymd");
		HttpSession session = request.getSession();
		session.setAttribute("ymd",ymd);

		//セッションの取得
		User loginUser = (User)session.getAttribute("loginUser");

		//DBの検索logic→DAO→DTO→Servlet
		SearchScheduleLogic searchScheduleLogic = new SearchScheduleLogic();
		DaySchedule daySchedule = searchScheduleLogic.searchDaySchedule(loginUser,ymd);

		//リクエストパラメーターにセット
		request.setAttribute("daySchedule", daySchedule);

		//カレンダー登録画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerSchedule.jsp");
		dispatcher.forward(request, response);
	}

}
