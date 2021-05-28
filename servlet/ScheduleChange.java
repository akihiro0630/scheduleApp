package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScheduleChange
 */
@WebServlet("/ScheduleChange")
public class ScheduleChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストスコープの変数を取り出す
//		String ymd = request.getParameter("ymd");
		String sTime = request.getParameter("sTime");
		String schedule = (String)request.getParameter("schedule");

		//リクエストスコープにセット
		request.setAttribute("sTime", sTime);
		request.setAttribute("schedule", schedule);

		//スケジュール変更画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/scheduleChange.jsp");
		dispatcher.forward(request, response);

	}

}
