package misci;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchingEx {
	
	public static void main(String[] args)
	{  /*
		Pattern class:
			A Pattern object represents "compiled version of Regular Expression".
			We can create a Pattern object by using compile() method of Pattern class.
		*/
		
		/*
		 * A Matcher object can be used to match character sequences against a Regular Expression.
We can create a Matcher object by using matcher() method of Pattern class.

  find() - It attempts to find next match and returns true if it is available otherwise returns false.
  group() - returns the matched pattern
		 */
		
		boolean b = Pattern.matches("a*b", "aaaaab");
		System.out.println(b);
		
		int count=0;
		Pattern p=Pattern.compile("ab");
		Matcher m=p.matcher("abbbabbaba  this is baba");
		while(m.find())
		{
     		count++;
		System.out.println(m.start()+"------"+m.end()+"------"+m.group());
		}
		System.out.println("The no of occurences :"+count);
	}

}
