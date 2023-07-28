package stringBuilder.and.wrapper;



public class StringStringBuilderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stubG
		
		
		//immutable concept of String
		  String s = "Nancy";
		  
		  
		  System.out.println(s+" gupta");
		  
		  
		  //below will print Nancy as new object created is not assigned back to reference s
		  //s is still pointing to old String object
		  System.out.println(s);
		  
		  
		  //this will print Nancy Gupta
		  //as u are reassigning newly created String object back to s reference
		  s = s+ " Gupta";
		  System.out.println(s);
		  
		  
		  String s1 = s+" Gupta"; System.out.println(s); System.out.println(s1);
		  
		  String s2 = " Gupta";
		 
		  
		//String imp conversions	
		
        //char to String		
		char ch = 'n';
		
		//String ss = ch; //type mismatch:cannot convert from char to String
		
		String chstr = Character.toString(ch);
		System.out.println("char ch="+ch+" to String:"+chstr);
		
		//String to char
		
		String yesno = "n";
		
		 ch =  yesno.charAt(0);
		 System.out.println("String "+yesno+" to char:"+ch);
		 System.out.println(ch);
		 
		 //char to unicode value
		 
		 ch = 'A';
		 Character x = ch;  //autoboxing char to Character
		 
		 
		 int charval = Character.getNumericValue(ch);
		 
		 System.out.println("char ch="+ch+" to Unicode value:"+charval);
		 
		 
		
		//important methods of string
		
		String str = "Core Java Batch";
		
		String str1 = str.substring(5,8);
		System.out.println(str1);
		
		 str1 = str.substring(5);
		System.out.println(str1);
		
		System.out.println(str.toLowerCase());
		
		//String to char array
		char[] arr = str.toCharArray();
		
		
		//wrap string into string builder and do all modifications
		//convert the string builder back to string object
		//this way we can avoid creating too many string objects in the background (as string
		// is immutable but string builder is mutable so use string builder instead of string
		// for modifications
        String st = "Core Java";		
		StringBuilder sb = new StringBuilder(st);
		sb.append(10).append(" ahahah").substring(5);
		
		st = sb.toString();
		System.out.println(st);
		
		
		
		
		
		
	}

}
