package hasarelationship.containment;



public class ContainmentEx {

	public ContainmentEx() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Emp e = new Emp(1,"Namrata",100000);
		Dept d = new Dept(10,"HR",10);
		
		e.setDept(d);
		
		//show employee details along with his department details
		System.out.println(e);
		
		/*
		Dept dp = e.getDept();
		String depname1 = dp.getDeptName();
		*/

		String deptname = e.getDept().getDeptName();
		System.out.println("emp "+e.getName()+" works in department "+deptname);
		
		

	}

}
