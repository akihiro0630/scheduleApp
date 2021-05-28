package model;

import dao.ChangeScheduleDAO;
import dao.SearchScheduleDAO;

public class ChangeScheduleLogic {
	/*
	 * スケジュールを一件更新または追加する処理
	 * */

	public boolean execute(String id,String ymd,String reSchedule,String sTime) {

		//引数の受け取り
		int year = Integer.parseInt(ymd.substring(0,4));
		int month = Integer.parseInt(ymd.substring(4,6));
		int date = Integer.parseInt(ymd.substring(6,8));

		//
		SearchScheduleDAO sdao = new SearchScheduleDAO();
		boolean result = sdao.serchSchedule(id,year,month,date,sTime);

		ChangeScheduleDAO dao = new ChangeScheduleDAO();

		boolean result2 = false;

		if(result == false) {
			result2 = dao.insertSchedule(id,year,month,date,reSchedule,sTime);
		}else {
			result2 = dao.updateSchedule(id,year,month,date,reSchedule,sTime);
		}

		return result2;

	}

}
