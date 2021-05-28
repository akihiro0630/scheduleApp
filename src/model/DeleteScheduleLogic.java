package model;

import dao.DeleteScheduleDAO;

public class DeleteScheduleLogic {
	public boolean execute(String id,String ymd,String sTime) {
		DeleteScheduleDAO dao = new DeleteScheduleDAO();

		String year = ymd.substring(0,4);
		String month = ymd.substring(4,6);
		String date = ymd.substring(6,8);

		boolean result = dao.deleteSchedule(id,year,month,date,sTime);
		return result;
	}

}
