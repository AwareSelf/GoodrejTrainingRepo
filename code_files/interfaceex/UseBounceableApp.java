package interfaceex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseBounceableApp {

	public UseBounceableApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bounceable b = null;
		b = new Ball("red","rubber");
		
		b.bounce();
		
		b = new Ball("pink","Season");
		
        b.bounce();
        
        b = new Tyre("MRF","Big");
        b.bounce();
        
        
        callBounce(new Ball("red","rubber"));
        callBounce(new Tyre("MRF","Big"));
        
       
        //runtime poly
        List<Bounceable> l = new ArrayList<Bounceable>();
        l.add(new Ball("red","rubber"));
        l.add(new Ball("pink","Season"));
        l.add(new Ball("violet","plastic"));
        l.add(new Tyre("MRF","Big"));
        l.add(new Tyre("CEAT","Small"));
        callBounce(l);
      //  l.add("aaa");
        
	}
	
	 static void callBounce(Bounceable b)
	 {
		 b.bounce();
	 }
	 
	 static void callBounce(List<Bounceable> l)
	 {
		l.forEach(b->b.bounce()); //lambda function used as callback
		
	 }
	 
	 

}
