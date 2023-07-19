
public class A {
	
	int no1;
	
	static final int ct =10;
	
	static int ct1;
	
	static
	{
		ct1=0;
	//	no1=8;
	}
	
	static void incrct()
	{
	//	no1=9;
		
		ct1++;
	}
   

	A(int no1)
	{
		this.no1 = no1;
		ct1++;
	}
	
	

	public int getNo1() {
	
		return no1;
	}



	public void setNo1(int no1) {
		this.no1 = no1;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int x=5;
		
		final A ob = new A(10);
		
		
		//ref is final but object is not final, object can still be modified
		ob.setNo1(100); 
		
		A ob1 = new A(15);
		
		
		final int x1;
	     x1=10;
		if(x1==5)
		{
			//x1=8;
		}
		
		
		
		
	//	ob=ob1;
	//	ob = new A(19);
		
		if(args.length >=  2)
		{
		int no1 = Integer.parseInt(args[0]);
		int no2 = Integer.parseInt(args[1]);
		
		System.out.println("Hello World, args0="+no1+" , args1="+no2);
		
		int result = no1 +  no2;
		System.out.println("result of no1="+no1+", no2="+no2+" is "+result) ;
		}
		else
		{
			System.out.println("Insufficient no of args");
		}

	}

}
