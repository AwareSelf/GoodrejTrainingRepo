package abstractex;

import java.util.Scanner;

public class AbstractApp {

	public AbstractApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Shape: 1.Square/2.Rectangle/3.Triangle/4.Circle");
		
		int shapeno = sc.nextInt();
		
		switch(shapeno)
		{
		
		case 1:
			System.out.println("Enter side of Square:");
			int side = sc.nextInt();
			showAreaAndPmShape(new Square(side));
			break;
		case 2:
			break;
		case 3:
			
			break;
		case 4:
			System.out.println("Enter radius of Circle:");
			double radius = sc.nextDouble();
			showAreaAndPmShape(new Circle(radius));
			break;
						
		default:
			System.out.println("You have not entered correct Shape.");
		}
		
		

	}
	
	
	//here i am displaying value but normally you will return the value
	public static void showAreaAndPmShape(Shape s)
	{
		System.out.println("Shape details:"+s);
		System.out.println("Area:"+s.calcArea());
		System.out.println("Perimeter:"+s.calcPerimeter());
	}
	
	

}
