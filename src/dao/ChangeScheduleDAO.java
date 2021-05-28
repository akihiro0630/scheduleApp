package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeScheduleDAO {

	//DB接続情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/scheduleapp";
	private final String DB_USER = "root" ;
	private final String DB_PASS = "" ;

	/*
	 * scheduleテーブルに一件追加する処理
	 * */

	public boolean insertSchedule(String id,int year,int month,int date,String reSchedule,String sTime) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			//insert文の準備
			String sql = "INSERT INTO schedules VALUES(?,?,?,?,NULL,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//INSERTT文中の?に該当する値を設定
			pstmt.setInt(1, year);
			pstmt.setInt(2, month);
			pstmt.setInt(3, date);
			pstmt.setString(4, sTime);
			pstmt.setString(5, id);
			pstmt.setString(6, reSchedule);


			//INSERT文を実行
			int result = pstmt.executeUpdate();

			//戻り値が1以外の場合、falseを返し、1の場合trueを返す
			if(result != 1) {
				return false;
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * scheduleテーブルに一件更新する処理
	 * */

	public boolean updateSchedule(String id,int year,int month,int date,String reSchedule,String sTime){

		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			//UPDATE文の準備
			String sql = "UPDATE schedules SET schedule = ? where id=? and year=? and month = ? and date = ? and sTime=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//UPDATE文中の?に該当する値を設定し、SQLを実行
			pstmt.setString(1, reSchedule);
			pstmt.setString(2, id);
			pstmt.setInt(3, year);
			pstmt.setInt(4, month);
			pstmt.setInt(5, date);
			pstmt.setString(6, sTime);


			//insert文を実行
			int result = pstmt.executeUpdate();

			if(result != 1) {
				return false;
			}

		}catch(SQLException e) {
				e.printStackTrace();
				return false;
		}
		return true;
	}

}
