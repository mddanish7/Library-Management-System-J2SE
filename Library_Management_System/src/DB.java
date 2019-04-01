import java.sql.Connection;
import java.sql.DriverManager;

public class DB {


	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://Localhost:3306/library","root","Abhi2344");
		}catch(Exception e){System.out.println(e);
			System.out.println("not connected to database");
		}
		return con;
	}
}