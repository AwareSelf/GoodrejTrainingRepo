package abstractex;

public abstract class Shape {

	private int side1,side2,side3;
	private int height,base;
	private double radius;
	private String type;
	
	//use it for square,rhombus
	public Shape(int side,String type) {
      
		this.side1 = side;
		this.side2 = side;
		this.side3 = side;
		this.type = type;
	}
	
	//use this constructor for rectangle and parallelogram
	public Shape(int side1,int side2,String type)
	{
		this.side1 = side1;
		this.side2 = side2;
		this.type = type;
		
	}
	
	//use it for Triangle
	public Shape(int side1, int side2, int side3,int height,int base) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.height = height;
		this.type = "Triangle";
	}
	
	public Shape(double radius)
	{
		this.radius =  radius;
		this.type ="Circle";
	}


	public Shape() {
		
	}


	public int getSide1() {
		return side1;
	}


	public void setSide1(int side1) {
		this.side1 = side1;
	}


	public int getSide2() {
		return side2;
	}


	public void setSide2(int side2) {
		this.side2 = side2;
	}


	public int getSide3() {
		return side3;
	}


	public void setSide3(int side3) {
		this.side3 = side3;
	}
	
	
		
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract double calcArea();
	
	public abstract double calcPerimeter();
	
		



	@Override
	public String toString() {
		return "Shape [type="+type+", side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
	}
	
	

}
