package collections;
import hr.*;

import java.util.*;

public class HashSetEx {

	public HashSetEx() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        Set<Emp> s = new HashSet<Emp>();
        Emp e = new Emp(1,"Namrata",100000,10);
		s.add(e);
		Emp e1 = new Emp(2,"Rahul",200000,20);
		s.add(e1);
		Manager m = new Manager(3,"Parag",120000,10,"Dev",10000,5,"Manager");
		s.add(m);
		Manager m1 = new Manager(4,"Abhishek",15000,20,"Dev",10000,15,"Manager");
		s.add(m1);
		s.add(new WageEmp(5,"Geeta",1000,30,100,50));
		Emp ex = new Emp(1,"Namrata",100000,10);
		s.add(ex);
		
		System.out.println(s);
		System.out.println(s.size());
				
		System.out.println(s.contains(ex));
		System.out.println(s.contains(new Emp(1,"Namrata",100000,10)));
		System.out.println(s.contains(new Emp(11,"Rama",100000,10)));
		
		System.out.println("************************Treeset************************");
		
		Set<Emp> ts = new TreeSet<Emp>();
         e = new Emp(5,"Namrata",100000,10);
		ts.add(e);
		 e1 = new Emp(3,"Rahul",200000,20);
		ts.add(e1);
		 m = new Manager(4,"Parag",120000,10,"Dev",10000,5,"Manager");
		ts.add(m);
		m1 = new Manager(2,"Abhishek",15000,20,"Dev",10000,15,"Manager");
		ts.add(m1);
		ts.add(new WageEmp(1,"Geeta",1000,30,100,50));
	    ex = new Emp(5,"Namrata",100000,10);
		ts.add(ex);
		
		System.out.println(ts);
		
		
		System.out.println("************************Treeset with comparator************************");
		
		EmpSalSort comptr = new EmpSalSort();
		Set<Emp> ts1 = new TreeSet<Emp>(comptr);
        e = new Emp(5,"Namrata",100000,10);
		ts1.add(e);
		 e1 = new Emp(3,"Rahul",200000,20);
		ts1.add(e1);
		 m = new Manager(4,"Parag",120000,10,"Dev",10000,5,"Manager");
		ts1.add(m);
		m1 = new Manager(2,"Abhishek",15000,20,"Dev",10000,15,"Manager");
		ts1.add(m1);
		ts1.add(new WageEmp(1,"Geeta",1000,30,100,50));
	    ex = new Emp(5,"Namrata",100000,10);
		ts1.add(ex);
		
		System.out.println(ts1);
	}
	
	

}
