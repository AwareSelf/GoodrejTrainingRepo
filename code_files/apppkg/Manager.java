package apppkg;

public class Manager extends hr.Emp {
	
	
	private String typeMgr;
	private double commission;
	private int teamSize;
	
	public Manager()
	{
	
		System.out.println("0 arg constructor of Manager called..");
	}
	
	public Manager(int empid,String name,double salary,String typeMgr,
			double commission,int teamSize)
	{
		super(empid,name,salary);
		
		
		System.out.println("args-wala Manager constructor called..");
		
		this.typeMgr = typeMgr;
		this.teamSize = teamSize;
		this.commission = commission;
	}
	
	public Manager(int empid,String name,double salary,String typeMgr,
			double commission,int teamSize,String role)
	{
		super(empid,name,salary);
		this.role=role;
		
		
		System.out.println("args-wala Manager constructor called..");
		
		this.typeMgr = typeMgr;
		this.teamSize = teamSize;
		this.commission = commission;
	}
	
	
	
	
	public String getTypeMgr() {
		return typeMgr;
	}

	public void setTypeMgr(String typeMgr) {
		this.typeMgr = typeMgr;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	@Override
	public String toString()
	{
		return super.toString()+",team size="+this.teamSize
				         +",commission="+this.commission
				         +",type manager"+this.typeMgr;
				         
	}
	
	@Override
	public double calcAnnSal()
	{
		return super.calcAnnSal()+  this.commission;
	}
	
	public void delegate()
	{
		System.out.println("The role of this emp is:"+this.role);
		System.out.println("The role of this emp is:"+this.getRole());
		System.out.println("manager "+ this.getName()+" delegating to his team, of team size:"+this.teamSize);
	}
	
	

}
