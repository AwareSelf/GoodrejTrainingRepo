package miscellaneous;
class Wrapper 
{
	public static void main(String[] args) 
	{
		String s="123";
		int i=4;
		int j;

//***************************************************************************
//All conversions to primitve int


		//convert String to primitive int -  parsexxx methods
		j=Integer.parseInt(s);
		System.out.println("using Integer.parseint j="+j);
		
		//convert String in hexadecimal format to primitive int
		s="A";
		j=Integer.parseInt(s,16);
		System.out.println("using Integer.parseint with radix 16. j="+j);

		//convert String in octal format to primitive int
		s="010";
		j=Integer.parseInt(s,8);
		System.out.println("using Integer.parseint with radix 8. j="+j);

		//convert String to primitive int via wrapper Integer
		//without using autoBoxing
		s=" 13 ";
		Integer wi=Integer.parseInt(s.trim());
		j=wi.intValue();
		System.out.println("using intValue j="+j);


		//same as above using autoUnboxing
		//int value inside Integer wrapper wi would be unboxed and assign to j
		j=wi; 
		System.out.println("using unboxing:j="+j);



//********************************************************************************
//All conversions to String
		//to convert primitive int to String , assign int to Integer and 
		//then call toString on it
		int k=9;
		Integer wk=k; //auto-boxing/auto-wrapping int wrap to Integer
		String ss=wk.toString(); //shortcut ss=new Integer(k).toString()
		System.out.println("primitive int to string:"+ss);

		//convert primitive int directly to binaryString
		ss=Integer.toBinaryString(12); //shortcut ss=new Integer(k).toString()
		System.out.println("primitive int to Binarystring:"+ss);

		//convert primitive int directly to OctalString
		ss=Integer.toOctalString(10); //shortcut ss=new Integer(k).toString()
		System.out.println("primitive int to Octalstring:"+ss);

		//Convert wrapper to String
		//Integer.valueOf(primitive int) ==> Integer object
		//toString converts Integer object to String
		//but you can directly assign int primitive to Integer object also
		ss=Integer.valueOf(i).toString();
		System.out.println("Convert wrapper Integer to String");
//***************************************************************
		// All conversions to wrapper Integer


		//convert primitive int to wrapper int
		k=16;
		Integer tt=k;
		System.out.println(tt);
		//or
 		//using autoBoxing convert primitive int to wrapper int
		int o=9;
		Integer wo=o;

		//or using valueOf convert primitive int to wrapper int
		tt=Integer.valueOf(k);
		System.out.println(tt);



		//convert  hexadecimal String to Integer wrapper
		tt=Integer.valueOf("B",16);
		System.out.println(tt);
		//convert  Binary String to Integer wrapper
		tt=Integer.valueOf("1010",2);
		System.out.println(tt);
  
		
	}
}
