package objectequalsex;



public class CheckEmpEqualsApp {

	public CheckEmpEqualsApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Emp e1;
		e1 = new Emp(1,"Namrata",100000);
		System.out.println(e1);
		
		Emp e2  = new Emp(1,"Namrata",100000);
		System.out.println(e2);
		
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		
		
		System.out.println(e1==e2);
		System.out.println(e1.equals(e2));
		
		e1=e2;
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e1==e2);
		
		System.out.println(e1.equals(e2));
		
		
		
		  

	}

}
