package abstractex;

public class Circle extends Shape {
	
	public static final double pi = 3.142;

	public Circle(double radius) {
		
		super(radius);
	}
	
	
	@Override
	public double calcArea()
	{
		return Circle.pi * this.getRadius() * this.getRadius();
	}
	
	@Override
	public double calcPerimeter()
	{
		return 2*Circle.pi* this.getRadius();
	}
	
	@Override
	public String toString()
	{
		return "Shape:Circle, radius:"+this.getRadius();
	}
}
