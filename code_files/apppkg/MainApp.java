package apppkg;
import hr.Emp;
import hr.Manager;
import hr.WageEmp;

public class MainApp {

	public static void main(String[] args) {
		
		Emp e;
		e = new Emp(1,"Namrata",100000);
		  
		System.out.println(e); //e.toString();
		
		//protected variable and method are not accessible to non-derived class
		//in diff package
		//System.out.println(e.getRole());
		//System.out.println(e.role);
		
		double annsal = e.calcAnnSal();
		System.out.println("Annual salary="+annsal);
		
		System.out.println("Annual salary e="+e.calcAnnSal());
		
		
		Emp e1 = e;
		System.out.println("Annual salary e1="+e1.calcAnnSal());
		System.out.println(e1);
		
		e1 = new Emp(2,"Rahul",200000);
		System.out.println("Annual salary e1="+e1.calcAnnSal());
		System.out.println(e1);
		
		//calling overloaded calAnnSal of emp with bonus
		Emp e3 = new Emp(4,"Arjun",200000);
		System.out.println("Annual salary e1="+e3.calcAnnSal(25000));
		System.out.println(e3);
		
		Manager m = new Manager();
		System.out.println(m);
		
		m = new Manager(3,"Parag",120000,"Dev",10000,5);
		System.out.println(m);
		System.out.println(m.calcAnnSal());
		m.delegate();
		
		//protected is not accessible to any class in diff/another package
		//System.out.println(m.role);
		//System.out.println(m.getRole());
				
		
		
		//--------**----------------------------------------
		
		runtimePoly(e);
		runtimePoly(m);
		
		runtimePoly(new Manager(4,"Abhishek",15000,"Dev",10000,15));
		
		runtimePoly(new WageEmp(5,"Geeta",1000,100,50));

	}
	
	
	public static void runtimePoly(Emp e)
	{
		double d  = e.calcAnnSal();
		System.out.println("Annual Salary of :"+e.getName()+" is "+d);
		
		System.out.println("Emp Details:"+e);
		
		// instanceof operator checks the runtime type/dynamic type 
		// of the object reference
		if(e instanceof Manager)
		   ((Manager)e).delegate();
	}

}

