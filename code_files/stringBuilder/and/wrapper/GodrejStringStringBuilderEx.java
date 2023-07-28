package stringBuilder.and.wrapper;

public class GodrejStringStringBuilderEx {
	
	
	public static void main(String[] args)
	{
		String s = "Nancy";
		
		String s1 = "Nancy";
		
		System.out.println(s==s1); //true  (uses same string from string pool)
		
		String s2 =  new String("Nancy");
		System.out.println(s==s2);   //false
		
		
		s = "Namrata";
		
		System.out.println(s);
		System.out.println(s + " hi ha ha"); //s.concat(" hi ha ha");
		System.out.println(s);
		s.toLowerCase();
		System.out.println(s);
		
		s = s.toLowerCase();
		System.out.println(s);
		
		//StringBuffer and StringBuilder are same.
		//StringBuffer old legacy class (means before version java 1.5) and String builder was added in 1.5
		StringBuilder sb = new StringBuilder("Java");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		//process
		
		//for string modification use string builder and then convert it back to string
	//	String --> StringBuilder --> modify --> convert it back to String
		
		String name = "Manish Tiwari";
		
		StringBuilder sb1 = new StringBuilder(name);
		name = sb1.append(" is a java").append(" is a fool").reverse().toString();  //subString -> StringBuider to String
		
		System.out.println("final string:"+name);
		
	}

}
