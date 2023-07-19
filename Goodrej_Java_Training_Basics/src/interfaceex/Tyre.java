package interfaceex;

public class Tyre implements Bounceable {
	
	private String companyName;
	private String size;
    private int bounceFactor;
	
	public Tyre() {
		// TODO Auto-generated constructor stub
	}

	public Tyre(String companyName, String size) {
		super();
		this.companyName = companyName;
		this.size = size;
	//	this.bounceFactor = bounceFactor;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
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
	
	@Override
	public void bounce()
	{
		this.bounceFactor = this.bounceFactor + Bounceable.bounceFactor/2;
		System.out.println(this.companyName+" Tyre of size "+this.size+" bouncing with bounce"
				+ "factor "+this.bounceFactor);
	}

	@Override
	public String toString() {
		return "Tyre [companyName=" + companyName + ", size=" + size + ", bounceFactor=" + bounceFactor + "]";
	}
	
	

}
