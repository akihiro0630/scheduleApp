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
import model.DeleteScheduleLogic;
import model.SearchScheduleLogic;
import model.User;

/**
 * Servlet implementation class ScheduleDelete
 */
@WebServlet("/ScheduleDelete")
public class ScheduleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleDelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメーターの取得
		String ymd = request.getParameter("ymd");
		String sTime = request.getParameter("sTime");
		String id = request.getParameter("id");

		//削除ロジックの実行
		DeleteScheduleLogic logic = new DeleteScheduleLogic();
		boolean result = logic.execute(id,ymd,sTime);

		//次の画面で必要なDayScheduleを生成する
		SearchScheduleLogic searchScheduleLogic = new SearchScheduleLogic();
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		DaySchedule daySchedule = searchScheduleLogic.searchDaySchedule(loginUser,ymd);

		//リクエストパラメーターにセット
		request.setAttribute("daySchedule", daySchedule);


		//スケジュール変更画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerSchedule.jsp");
		dispatcher.forward(request, response);




	}

}
