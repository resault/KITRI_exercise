import java.sql.*;

public class DateTest {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "mvc", "mvc");
			StringBuffer sql = new StringBuffer();
			sql.append("select id, joindate from member");
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			Date join = rs.getDate(2); //2019-05-29
//			Timestamp join = rs.getTimestamp(2); //2019-05-29 23:05:55.0
//			Date join = rs.getDate(2);
			
			
			System.out.println("join : " + join);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
