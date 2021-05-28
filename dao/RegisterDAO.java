package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class RegisterDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/scheduleapp";
	private final String DB_USER = "root" ;
	private final String DB_PASS = "" ;

	public boolean register(User registerUser) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

			//insert文の準備
			String sql = "INSERT INTO user(id,pass,name) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//insert文中の?に該当する値を設定し、SQLを実行
			pstmt.setString(1, registerUser.getId());
			pstmt.setString(2, registerUser.getPass());
			pstmt.setString(3, registerUser.getName());

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
