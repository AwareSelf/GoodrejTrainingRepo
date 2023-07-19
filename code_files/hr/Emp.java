package hr;

public class Emp implements Comparable<Emp> {
	
	private int empid;
	private String name;
	private double salary;
	protected String role;
	public int deptno;
	
	
	public Emp()
	{
		System.out.println("0 arg Emp constructor called..");
	}
		
	public Emp(int empid,String name,double salary)
	{
		System.out.println("args-wala Emp constructor called..");
		this.empid = empid;
		this.name = name;
		this.salary = salary;
	}
	
	public Emp(int empid,String name,double salary,String role)
	{
		System.out.println("args-wala Emp constructor called..");
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.role = role;
	}
	public Emp(int empid,String name,double salary,int deptno)
	{
		System.out.println("args-wala Emp constructor called..");
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.deptno = deptno;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}
	
	

	/**
	 * @return the role
	 */
	protected String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public double calcAnnSal()
	{
		return this.salary*12;
	}
	
	public double calcAnnSal(double bonus)
	{
		System.out.println("overloaded calcAnnSal with bonus called..");
		return this.salary*12 + bonus;
	}
	
	
	@Override
	public int hashCode()
	{
		System.out.println("hashCode method of Emp called with hashCode val as "+this.deptno);
		return this.deptno;
	}
	
	
	public boolean equals(Object o)
	{
		System.out.println("Emp equals method called..");
		if(o instanceof Emp)
		{
			return this.empid == ((Emp) o).empid;
		}
		else
		{
			return false;
		}
	}
	
	  @Override public String toString() { return "Emp details: empid="+this.empid
	  +",  name="+this.name +", salary="+this.salary+",deptno="+this.deptno; }

	@Override
	public int compareTo(Emp o) {
		// TODO Auto-generated method stub
		
		System.out.println("compareTo method of emp called..");
		return this.empid - o.empid;
		//return  (int)(this.salary - o.salary);
		//return o.empid - this.empid //descending order
	}
	 
}
