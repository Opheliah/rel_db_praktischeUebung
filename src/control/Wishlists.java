package control;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

class Wishlists {
  private static LinkedList<String> lists = new LinkedList<String>();

  static LinkedList<String> getLists() {
	return lists;
  }
  
  static void createList(String listname) throws IllegalArgumentException{
	 if(lists.contains(listname)){
	   throw new IllegalArgumentException("List with this name allready" +
	   		" exists.");
	 }
	 lists.add(listname);
	 try{
	   java.sql.Connection conn = Connection.getConn();
	   Statement stmt = conn.createStatement();
	   stmt.executeQuery("CREATE TABLE " + listname + " " +
	   		"(listentry VARCHAR(30));");
	 }   	
	 catch(SQLException s){
	   System.out.println(s.getMessage());
	 }
  }
  
  static void removeList(String listname){
	 lists.remove(listname);
	 try{
	   java.sql.Connection conn = Connection.getConn();
	   Statement stmt = conn.createStatement();
	   stmt.executeQuery("DROP TABLE " + listname + ";");
	 }   	
	 catch(SQLException s){
	   System.out.println(s.getMessage());
	 }
  }
  
  static LinkedList<String> showList(String listname){
    try{
	  java.sql.Connection conn = Connection.getConn();
	  Statement stmt = conn.createStatement();
	  ResultSet res = stmt.executeQuery("SELECT * FROM " + listname + ";");
	
	  LinkedList<String> ret = new LinkedList<String>();
      while(res.next()){
	    String row  = res.getString(1);
	    ret.add(row);
	  }
	  return ret;
    }   	
	catch(SQLException s){
	  System.out.println(s.getMessage());
	  return null;
	}  	  
  }
 
  static void addToList(String listname, String entry){
    try{
      java.sql.Connection conn = Connection.getConn();
      Statement stmt = conn.createStatement();
	  stmt.executeQuery("INSERT INTO " + listname + "(listentry) SELECT '" + 
        entry + "' FROM dual WHERE NOT EXISTS(SELECT * FROM " + 
		listname + "WHERE listentry = " + entry + ");");
    }
    catch(SQLException s){
 	   System.out.println(s.getMessage());
    }
  }
  
  static void removeFromList(String listname, String entry){
    try{
	  java.sql.Connection conn = Connection.getConn();
	  Statement stmt = conn.createStatement();
	  stmt.executeQuery("DELETE FROM " + listname + "WHERE listentry = " + 
	    entry + ";");
	}
	catch(SQLException s){
	  System.out.println(s.getMessage());
	}
  }
}
