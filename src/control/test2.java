package control;

import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;

public class test2 {
	 public static void main(String[] args){
		  
		  Connection.login("jdbc:oracle:thin:@dbvm07.iai.uni-bonn.de:1521:lehre","s6paseun","ps51uSio");
		 // LinkedList<LinkedList<String>> res = Details.person("Steven Spielberg");
		  
		  //System.out.println(res);
		  
		  java.sql.Connection conn = Connection.getConn();
		  try{
		    Statement stmt = conn.createStatement();
			       
		    ResultSet res = stmt.executeQuery("SELECT * FROM IMDB.title WHERE rownum < 10" );
			       
	     	LinkedList<LinkedList<String>> tab =  Details.resultSetToStrings(res);
	     	
	     	System.out.println(tab.size());
	     	Iterator<LinkedList<String>> it1 = tab.iterator();
	     	while(it1.hasNext()){
	     		LinkedList<String> row = it1.next();
	     		Iterator<String> it2 = row.iterator();
	     		while(it2.hasNext()){
	     			System.out.print(it2.next() + " ");
	     		}
	     		System.out.print("\n");
	     	} 
		  }
		  catch(SQLException s){
			  System.out.println(s.getMessage());
			  
		  }
	  }
}
