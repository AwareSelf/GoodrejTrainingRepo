package interfaceex;

public class Ball implements Bounceable{
	
	private String color;
	private int bounceFactor;
	private String type;

	public Ball() {
		// TODO Auto-generated constructor stub
	}

	public Ball(String color, String type) {
		super();
		this.color = color;
	//	this.bounceFactor = bounceFactor;
		this.type = type;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the bounceFactor
	 */
	public int getBounceFactor() {
		return bounceFactor;
	}

	/**
	 * @param bounceFactor the bounceFactor to set
	 */
	public void setBounceFactor(int bounceFactor) {
		this.bounceFactor = bounceFactor;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	//while overriding the super class/intf 
	//method the visibility should be same or higher
	@Override
	public void bounce()
	{
		
		//switch(this.type)
		switch(this.type.toLowerCase())
		{
		case "rubber":
			this.bounceFactor =  Bounceable.bounceFactor * 10;
			break;
		case "season":
			this.bounceFactor = Bounceable.bounceFactor * 5;
			break;
		default:
			this.bounceFactor = Bounceable.bounceFactor;
		
		}
		
		System.out.println(this.color+" Ball is bouncing with bounce factor "+this.bounceFactor);
		
	}

	@Override
	public String toString() {
		return "Ball [color=" + color + ", bounceFactor=" + bounceFactor + ", type=" + type + "]";
	}
	
	

}
