package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RootDAO implements BaseDAO{

	private Connection conn = null;
	public  Connection getConnection(){
            	try{
                String driver = "com.mysql.jdbc.Driver";
                Class.forName(driver);
                System.out.println("driver ok");
                String url = "jdbc:mysql://127.0.0.1:3306/conferencemanager?useSSL=false";
                String user = "roothandler";
                String password = "321";
                conn = DriverManager.getConnection(url,user,password);
            	}catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            	} catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
	        	}
	        	finally{
	        	
	        	}
		return conn;
	}

	
}
