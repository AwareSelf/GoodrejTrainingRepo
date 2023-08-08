package ioex;

import java.io.File;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
		
		File f = new File("c:/tempp/abc.java");
		
		if(!f.exists())
		{
			f.createNewFile();
		}
		
		
		System.out.println(f.isDirectory());
		System.out.println(f.isFile());
		System.out.println("get path name of file:"+f.getAbsoluteFile());
		
		
		//f.delete();
		//System.out.println(f.exists());
		
		
		
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		

	}

}
