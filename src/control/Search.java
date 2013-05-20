package control;

import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class Search {
	  static LinkedList<LinkedList<String>> 
	    search(String select, String searchquery, LinkedList<String[]> options){
		  Iterator<String[]> it = options.iterator();
		  String sqlstatement;
		  StringWriter writer = new StringWriter();
		  if(select == "all") writer.write("SELECT * FROM ");
		  else               writer.write("SELECT " + select + " FROM ");
		  writer.write("IMDB.title,");
		  
		  boolean title = false, cast_info = false, name = false, 
		    char_name = false, role_type = false, movie_companies = false,
		    company_name = false;
		  
		  while(it.hasNext()){
			  String[] opt = it.next();
			  switch(opt[1]){
			    case "Person" : 
			    	addToFromClause(writer,"cast_info",cast_info);
			    	addToFromClause(writer,"name",name);
			    	break;
			    case "Titel" :
			    	break;			    	
			    case "Produktionsjahr" :
			    	addToFromClause(writer,"title",title);
			        break;
			    case "Film-/Serienrolle" :
			    	addToFromClause(writer,"cast_info",cast_info);
			    	addToFromClause(writer,"char_name",char_name);
			    	break;
			    case "Mitarbeiterfunktion" :
			    	addToFromClause(writer,"cast_info",cast_info);
			    	addToFromClause(writer,"role_type",role_type);
			    	break;
			    case "Filmgesellschaft" :
			    	addToFromClause(writer,"movie_companies",movie_companies);
			    	addToFromClause(writer,"company_name",company_name);
			    	break;
			  }
		  }
		  writer.write(" WHERE ");
		  boolean where_empty = true;
		  
		  if(cast_info){
			  writer.write("IMDB.cast_info.movie_id = IMDB.title.id AND ");
			  if(name) writer.write("IMDB.name.id = IMDB.cast_info.person_id" +
			  		" AND ");	  
			  if(char_name) writer.write("IMDB.char_name.id = " +
			  		"IMDB.cast_info.person_role_id AND ");
			  if(role_type) writer.write("IMDB.role_type.id = " +
			  		"IMDB.cast_info.role_id AND ");
		  } 
		  if(movie_companies){
			  writer.write("IMDB.movie_companies.movie_id = IMDB.title.id AND "
			    + "IMDB.company_name.id = IMDB.movie_companies.company_id");
		  }
		  
		  it = options.iterator();
		  while(it.hasNext()){
		     if(!where_empty) writer.write(" AND ");
		     String[] opt = it.next();
		     String[] optSql = new String[3];
		     switch(opt[1]){
		       case "Person" : 
		    	    optSql[1] = "name.name";
			    	break;
			    case "Titel" :
			    	optSql[1] = "title.title";
			    	break;			    	
			    case "Produktionsjahr" :
			    	optSql[1] = "title.production_year";
			        break;
			    case "Film-/Serienrolle" :
			    	optSql[1] = "char_name.name";
			    	break;
			    case "Mitarbeiterfunktion" :
			    	optSql[1] = "role_type.role";
			    	break;
			    case "Filmgesellschaft" :
			    	optSql[1] = "company_name.name";
			    	break;
		     }
		     switch(opt[2]){
		       case "ist gleich" :
		    	 optSql[2] = "=";
		         break;
		       case "ist ungleich" :
		    	 optSql[2] = "<>";
		    	 break;
		       case "ist groesser" :
		    	 optSql[2] = ">";
		    	 break;
		       case "ist kleiner" :
		    	 optSql[2] = "<";
		         break;
		       case "ist groesser/gleich" :
		    	 optSql[2] = ">=";
		    	 break;
		       case "ist kleiner/gleich" :
		    	 optSql[2] = "<=";
		    	 break;
		     }
		     writer.write("IMDB." + opt[1] + " " + opt[2] + " " + opt[3]);
		  }
		  try{
		    java.sql.Connection conn = Connection.getConn();
			Statement stmt = conn.createStatement();
		    ResultSet res = stmt.executeQuery(writer.toString());
		    return SqlResultToList.convert(res);
		  }   	
		  catch(SQLException s){
		    System.out.println(s.getMessage());
		    return null;
		  }
	  }	
	  
	  /*
	  static LinkedList<LinkedList<String>> 
	    person(String searchquery, LinkedList<String[]> options){
		  
	  }
	  
	  static LinkedList<LinkedList<String>> 
	    company(String searchquery, LinkedList<String[]> options){
				  
	  }	
	  
	  static LinkedList<LinkedList<String>> 
	    all(String searchquery, LinkedList<String[]> options){
				  
	  }	
	  */
	  static void addToFromClause(StringWriter writer, String table,
	    boolean added){
		  if(!added){
			  writer.write(",IMDB." + table);
			  added = true;
		  }
	  }
}
