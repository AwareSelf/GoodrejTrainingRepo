package stringBuilder.and.wrapper;

public class A {

	public static void main(String[] args) {
		
		final int a;
		a=6;
		//a++;
		
		
		B x = new B(6);
		final B ob = new B(6); //ref becomes final
		
		ob.no = 9; //object is not final so allowed
		
		//ob = new B(6); //but ref is final so not allowed
		
        // ob = x; //but ref is final so not allowed
	}

}


class B
{
	int no;
	
	B(int no)
	{
		this.no = no;
	}
	
	
}
