package collections;
import java.util.*;
import hr.Emp;
public class EmpSalSort implements Comparator<Emp>{

	public EmpSalSort() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		
		System.out.println("Comparator sorts based on emp salary.."); 
		return (int)(o1.getSalary() - o2.getSalary());
	}

}
