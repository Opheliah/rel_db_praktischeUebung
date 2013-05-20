package control;

import java.util.LinkedList;
import java.util.Iterator;
import java.sql.*;

/**
 * @todo wird fallunterscheidung dafür benötigt ob es z.b. charname gibt oder
 *       nicht? ansonsten null? was für ein string wird daraus?
 * @author patrick
 *
 */
public class Details {
	  static LinkedList<LinkedList<String>> title(String name){
		 try{
	       java.sql.Connection conn = Connection.getConn();
	       Statement stmt = conn.createStatement();
	       
	       ResultSet res = stmt.executeQuery("SELECT name.name, role_type.role," 
	         + "char_name.name FROM title, cast_info, name, char_name, " +
	         "role_type WHERE title.title = " + name + " AND title.id" +
	         " = cast_info.movie_id AND cast_info.person_id = name.id AND " +
	         "cast_info.person_role_id = char_name.id AND cast_info.role_id" +
	         " = role_type.id"  );
	       
	     return SqlResultToList.convert(res);
		 }
		 catch(SQLException s){
		   System.out.println(s.getMessage());
		   return null;
		 }
	  }
	  
	  static LinkedList<LinkedList<String>> person(String name){
	    try{
		  java.sql.Connection conn = Connection.getConn();
		  Statement stmt = conn.createStatement();
			       
		  ResultSet res = stmt.executeQuery("SELECT title.title,role_type.role," 
		    + "char_name.name FROM title, cast_info, name, char_name, " +
			  "role_type WHERE  name.name = " + name + " AND title.id = " +
			  "cast_info.movie_id AND cast_info.person_id = name.id AND " +
			  "cast_info.person_role_id = char_name.id AND cast_info.role_id" +
			  " = role_type.id"  );
			       
		  return SqlResultToList.convert(res);
		}
		catch(SQLException s){
		  System.out.println(s.getMessage());
		  return null;
		}  
	  }
	 
	  static LinkedList<LinkedList<String>> company(String name){
		  try{
			  java.sql.Connection conn = Connection.getConn();
			  Statement stmt = conn.createStatement();
				       
			  ResultSet res = stmt.executeQuery("SELECT title.title, " +
			    "kind_type.type FROM title, kind_type, movie_companies" +
			    "WHERE title.id = movie_companies.movie_id AND title.kind_id = "
			    + "kind_type.id");
				       
			  return SqlResultToList.convert(res);
			}
			catch(SQLException s){
			  System.out.println(s.getMessage());
			  return null;
			}    
	  }
}
