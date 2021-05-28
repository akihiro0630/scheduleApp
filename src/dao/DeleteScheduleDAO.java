package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteScheduleDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/scheduleapp";
	private final String DB_USER = "root" ;
	private final String DB_PASS = "" ;

	public boolean deleteSchedule(String id,String year,String month,String date,String sTime) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			//insert文の準備
			String sql = "DELETE from schedules where id=? and year=? and month=? and date=? and stime=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//insert文中の?に該当する値を設定し、SQLを実行
			pstmt.setString(1, id);
			pstmt.setString(2, year);
			pstmt.setString(3, month);
			pstmt.setString(4, date);
			pstmt.setString(5, sTime);

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
