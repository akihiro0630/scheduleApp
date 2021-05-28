package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/scheduleapp";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public User searchUser(User user) {
		//DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "SELECT id,pass,name from user where id=? and pass=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//select文中の?に該当する値を設定し、SQLを実行
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());

			//結果を取得
			ResultSet rs = pstmt.executeQuery();

			//戻り値の確保
			User loginUser;

			//検索結果があれば戻り値をセットする
			if (rs.next()) {

				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");

				loginUser = new User(id,pass,name);
				return loginUser;

			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public boolean searchUser(String id) {
		//DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "SELECT * from user where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//select文中の?に該当する値を設定し、SQLを実行
			pstmt.setString(1, id);

			//結果を取得
			ResultSet rs = pstmt.executeQuery();


			//検索結果があれば戻り値をセットする
			if (rs.next()) {

				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

}
