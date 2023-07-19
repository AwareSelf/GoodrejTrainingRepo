package hr;

public class WageEmp extends Emp {
	
	private double wages;
	private int hrs;
	
	public WageEmp()
	{
		System.out.println("0 arg constructor of WageEmp called..");
	}

	public WageEmp(int empid,String name,double salary,double wages,int hrs ) {
		// TODO Auto-generated constructor stub
		super(empid,name,salary);
		System.out.println("arg-wala constructor of WageEmp called..");
		this.hrs = hrs;
		this.wages = wages;
		
		
	}
	
	public WageEmp(int empid,String name,double salary,int deptno,double wages,int hrs ) {
		// TODO Auto-generated constructor stub
		super(empid,name,salary,deptno);
		System.out.println("arg-wala constructor of WageEmp called..");
		this.hrs = hrs;
		this.wages = wages;
		
		
	}
	public double calcAnnSal()
	{
		System.out.println("overloaded calcAnnSal called..");
		return super.calcAnnSal()+ ((this.wages * this.hrs)*12);
	}
	
	public double calcAnnSal(double bonus)
	{
		System.out.println("overloaded calcAnnSal with bonus called..");
		return super.calcAnnSal(bonus)+ ((this.wages * this.hrs)*12);
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ", Wages="+this.wages+", hrs="+this.hrs;
	}

}
