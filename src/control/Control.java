package control;

import java.util.*;
import java.sql.*;

public class Control {
 
  public static LinkedList<LinkedList<String>> 
    searchTitle(String searchquery, LinkedList<String[]> options){
	  return Search.title(searchquery, options);
  }	
	
  public static LinkedList<LinkedList<String>> 
    searchPerson(String searchquery, LinkedList<String[]> options){
	  return Search.person(searchquery, options);
  }
  
  public static LinkedList<LinkedList<String>> 
    searchCompany(String searchquery, LinkedList<String[]> options){
	  return Search.company(searchquery, options);		  
  }
  
  public static LinkedList<LinkedList<String>>
    getDetailedViewTitle(String name){
	  return Details.title(name); 
  }
  
  public static LinkedList<LinkedList<String>> 
    getDetailedViewPerson(String name){
	  return Details.person(name);
  }
 
  public static LinkedList<LinkedList<String>>
    getDetailedViewCompany(String name){
	  return Details.company(name);
  }
  
  public static boolean login(String address, String user, String pass){
    return Connection.login(address, user, pass);
  }


}
