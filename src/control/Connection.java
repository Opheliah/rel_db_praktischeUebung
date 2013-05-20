package control;

import java.sql.*;

public class Connection {

	private static String address = 
      "jdbc:oracle:thin:@dbvm07.iai.uni-bonn.de:1521:lehre";

	private static String user = "usernameHere";
    private static String pass = "passHere";
    
    private static java.sql.Connection conn;
    
    static boolean login(String address, String user, String pass){
    	try{
    	  java.sql.Connection conn = 
    	    DriverManager.getConnection(address,user,pass);
     	  setAddress(address);
          setUser(user);
          setPass(pass);
          setConn(conn);
          System.out.println("sucessfully connected");
          return(true);
    	}
    	catch(SQLException s){
    		System.out.println(s.getMessage());
    		return(false);
    	}
      }
    
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		Connection.address = address;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		Connection.user = user;
	}
	public static String getPass() {
		return pass;
	}
	public static void setPass(String pass) {
		Connection.pass = pass;
	}

	public static java.sql.Connection getConn() {
		return conn;
	}

	public static void setConn(java.sql.Connection conn) {
		Connection.conn = conn;
	}
    
}
