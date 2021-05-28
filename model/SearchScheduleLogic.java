package model;

import dao.SearchScheduleDAO;

public class SearchScheduleLogic {

	public DaySchedule searchDaySchedule(User loginUser, String ymd) {

		//引数を扱いやすく分ける
		String userId = loginUser.getId();
		int year = Integer.parseInt(ymd.substring(0, 4));
		int month = Integer.parseInt(ymd.substring(4, 6));
		int date = Integer.parseInt(ymd.substring(6, 8));

		//DAOで選択した日付の予定を検索する
		SearchScheduleDAO dao = new SearchScheduleDAO();
		DaySchedule daySchedule = dao.serchSchedule(userId, year, month, date);

		return daySchedule;
	}
}
