package jdbc;


import java.util.*;
import java.sql.*;
import javax.sql.*;
import java.io.*;

public class PreparedStatementEx
{


 public static void main(String[] args) 
 {
		
		
	String s;
	try
	{
     Class.forName("org.postgresql.Driver");
		
      try(Connection con=DriverManager.
		  getConnection("jdbc:postgresql://localhost:5432/testdb","postgres","namrata"); )
	  {
		
	    System.out.println("The connection is successful.");
	


        try(Statement stat=con.createStatement();)
		{
		 
		 s="create table student1(Rollno int,Name varchar(50),serName varchar(50))";
         stat.executeUpdate(s);
		}
		catch(SQLException e)
		{   
			e.printStackTrace();
		}
		

        s="insert into student1 values(?,?,?)";
         try(PreparedStatement stat1=con.prepareStatement(s);)
		{
 		     stat1.setInt(1,1);
    		 stat1.setString(2,"Namrata");
    		 stat1.setString(3,"Marathe");
             int no=stat1.executeUpdate();
    		 System.out.println("no of rows inserted:"+no);
    		 stat1.setInt(1,2);
    		 stat1.setString(2,"Rahul");
    		 stat1.setString(3,"Marathe");
             no=stat1.executeUpdate();
    		 System.out.println("no of rows inserted:"+no);


		}
		catch(SQLException e)
		{   
			e.printStackTrace();
		}
		


      	System.out.println("create is successful:");



		try(Statement stat=con.createStatement();)
		{
			
		
         s= "update student1 set name='nikhil' where rollno=1";
		 
          int count = stat.executeUpdate(s);
          
          System.out.println("no of rows updated.."+count);

		}
		catch(Exception e) {
			e.printStackTrace();
		}





        try(Statement stat=con.createStatement();)
		{
		 
         s= "select * from student1";
         ResultSet rset=stat.executeQuery(s);
		
         while(rset.next())
        	 System.out.println(rset.getInt(1)+" "+rset.getString(2)+"    "+rset.getString(3));
			}
		 catch(SQLException e)
		 {   
			e.printStackTrace();
		 }
		
	  }//end of try block to get connection
      catch(SQLException e)
      {
    	  System.out.println("Coonection not created.."+e);
    	  e.printStackTrace();
      }
      
	 } //end of try to load driver class
     catch(ClassNotFoundException e)
     {
    	  System.out.println("SQL Driver class not found.");
     }

	}
}
