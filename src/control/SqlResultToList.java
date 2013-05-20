package control;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;

public class SqlResultToList {
	 static LinkedList<LinkedList<String>> convert(ResultSet res)
			    throws SQLException{
			       
				   LinkedList<LinkedList<String>> ret = 
				  	         new LinkedList<LinkedList<String>>();
				   
				   ResultSetMetaData meta = res.getMetaData();
			       int numCol = meta.getColumnCount();
			       LinkedList<String> columnnames = new LinkedList<String>();
			       for(int i = 1; i <= numCol; ++i){
			    	   columnnames.add(meta.getColumnName(i)); 
			       }
			       ret.add(columnnames);
			       	     
			       while(res.next()){
			         LinkedList<String> row  = new LinkedList<String>();
			    	 for(int i = 1; i <= numCol; ++i){
			           row.add(res.getString(i));	 
			         }
			    	 ret.add(row);
			       }
			       return ret;  
	}
}
