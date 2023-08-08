package ioex;

import java.io.*;

public class FileIOEx1 {
	
	
	public static void main(String[] args) {
		
		
		fileio("src/classesobjects/empdata.data");
	}
	
	
	
	static void fileio(String filename)
	{
		
		File f = new File(filename);
		//read from charachter based .java file
		
		if(f.exists())
		{		
		
		try(InputStream fr = new FileInputStream(f))
		{
		
		
		int no;
		while((no = fr.read())!=-1)
		{
			
			System.out.print((char)no);
		}
		
	
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	  }
		else
		{
			System.out.println("file "+filename +" does not exist at given location..");
		}
	}

}
