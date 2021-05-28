package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DaySchedule;

public class SearchScheduleDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/scheduleapp";
	private final String DB_USER = "root" ;
	private final String DB_PASS = "" ;

	public DaySchedule serchSchedule(String userId,int year, int month,int date) {
		//渡すオブジェクトの生成
		DaySchedule day = new DaySchedule();
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			//insert文の準備
			String sql = "SELECT stime,etime,schedule FROM schedules WHERE id=? AND year=? AND month=? AND date=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//SELECT文中の?に該当する値を設定し、SQLを実行
			pstmt.setString(1, userId);
			pstmt.setInt(2, year);
			pstmt.setInt(3, month);
			pstmt.setInt(4, date);

			//結果を取得
			ResultSet rs = pstmt.executeQuery();

			Integer sTime= null;//開始時間
			Integer eTime= null;//終了時間
			String schedule = null;//スケジュール内容

			//結果を一行ずつセットする
			while(rs.next()) {
				sTime = rs.getInt("stime");
				eTime = rs.getInt("etime");
				schedule = rs.getString("schedule");

				sTimeLogic(day,sTime,schedule);

			}

		}catch(SQLException e) {
				e.printStackTrace();
				return null;
		}
		return day;
	}

	public boolean serchSchedule(String userId,int year, int month,int date,String sTime) {
		//渡すオブジェクトの生成
		DaySchedule day = new DaySchedule();
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			//select文の準備
			String sql = "SELECT schedule FROM schedules WHERE id=? AND year=? AND month=? AND date=? and sTime=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//SELECT文中の?に該当する値を設定し、SQLを実行
			pstmt.setString(1, userId);
			pstmt.setInt(2, year);
			pstmt.setInt(3, month);
			pstmt.setInt(4, date);
			pstmt.setString(5, sTime);

			//結果を取得
			ResultSet rs = pstmt.executeQuery();

			//結果を確認
			if(rs.next()) {
				return true;
			}

		}catch(SQLException e) {
				e.printStackTrace();
				return false;
		}
		return false;
	}

	//sTimeの値ごとに、scheduleをセットするメソッド
	public void sTimeLogic(DaySchedule day,int sTime, String schedule) {
		if(sTime == 0) {
			day.setZero(schedule);
		}else if(sTime == 1) {
			day.setOne(schedule);
		}else if(sTime == 2) {
			day.setTwo(schedule);
		}else if(sTime == 3) {
			day.setThree(schedule);
		}else if(sTime == 4) {
			day.setFour(schedule);
		}else if(sTime == 5) {
			day.setFive(schedule);
		}else if(sTime == 6) {
			day.setSix(schedule);
		}else if(sTime == 7) {
			day.setSeven(schedule);
		}else if(sTime == 8) {
			day.setEight(schedule);
		}else if(sTime == 9) {
			day.setNine(schedule);
		}else if(sTime == 10) {
			day.setTen(schedule);
		}else if(sTime == 11) {
			day.setEleven(schedule);
		}else if(sTime == 12) {
			day.setTwelve(schedule);
		}else if(sTime == 13) {
			day.setThirteen(schedule);
		}else if(sTime == 14) {
			day.setFourteen(schedule);
		}else if(sTime == 15) {
			day.setFifteen(schedule);
		}else if(sTime == 16) {
			day.setSixteen(schedule);
		}else if(sTime == 17) {
			day.setSeventeen(schedule);
		}else if(sTime == 18) {
			day.setEighteen(schedule);
		}else if(sTime == 19) {
			day.setNineteen(schedule);
		}else if(sTime == 20) {
			day.setTwenty(schedule);
		}else if(sTime == 21) {
			day.setTwentyone(schedule);
		}else if(sTime == 22) {
			day.setTwentytwo(schedule);
		}else if(sTime == 23) {
			day.setTwentythree(schedule);
		}else if(sTime == 24) {
			day.setTwentyfour(schedule);
		}
	}

}
