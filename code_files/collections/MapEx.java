package collections;

import java.util.*;

import hr.Emp;
import hr.Manager;
import hr.WageEmp;

public class MapEx {

	public MapEx() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//map of emp with their names-salary
		Map<String,Double> mp = new HashMap<String,Double>();
		mp.put("Ram",5000.0);
		mp.put("Shyam",15000.5);
		mp.put("Ram",5000.4);
		mp.put("Keshav",25000.8);
		System.out.println(mp);
		System.out.println(mp.keySet());
		
		System.out.println("********************Map of Emp->Salary**************************************");
		
		Map<Emp,Double> mp1 = new HashMap<Emp,Double>();
		
        Emp e = new Emp(1,"Namrata",100000,10);
		mp1.put(e,e.getSalary());
		
		Emp e1 = new Emp(2,"Rahul",200000,20);
		mp1.put(e1,e1.getSalary());
		
		Manager m = new Manager(3,"Parag",120000,10,"Dev",10000,5,"Manager");
		mp1.put(m,m.getSalary());
		
		Manager m1 = new Manager(4,"Abhishek",15000,20,"Dev",10000,15,"Manager");
		mp1.put(m1,m1.getSalary());
		
		WageEmp we = new WageEmp(5,"Geeta",1000,30,100,50);
		mp1.put(we,we.getSalary());
		
		Emp ex = new Emp(1,"Namrata",100000,10);
		mp1.put(ex,ex.getSalary());
		
		System.out.println("map size:"+mp1.size());
		
		System.out.println(mp1);
		
		Set<Emp> st = mp1.keySet();
		System.out.println("all key values in the map:"+st);
		
		System.out.println(mp1.get(we));
		
		
		
		
		

	}

}
