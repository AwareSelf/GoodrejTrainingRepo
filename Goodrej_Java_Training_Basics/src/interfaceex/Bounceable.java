package interfaceex;

public interface Bounceable {
	
	int bounceFactor = 5;    //static final so has to be initialized - compile time constant
	
	//anything that is bounceable
	void bounce();  //its public and abstract by default
	

}
