package abstractex;

public class Square extends Shape {

	public Square(int side) {
		
		super(side,"Square");
		
	}
	
	
	@Override
	public double calcArea()
	{
		return this.getSide1()*this.getSide1();
	}
	
	@Override
	public double calcPerimeter()
	{
		return this.getSide1() * 4;
	}
}
