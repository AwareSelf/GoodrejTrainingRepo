package stringBuilder.and.wrapper;

public class EnumEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CoffeeShop ob = new CoffeeShop();
		ob.orderCoffee(CoffeeShop.MugSize.JUMBO, CoffeeShop.CofeeType.CAPPUCHINO);
		
		
	}

}

class CoffeeShop
{
	
	enum CofeeType {CAPPUCHINO,EXPRESSO,MOCHA};
	enum MugSize {SMALL,BIG,JUMBO};
	
	void orderCoffee(MugSize ms,CofeeType ct)
	{
		System.out.println("you have placed order for coffee "+ct.name()+" for size "+ms.name());
		
		System.out.println("you have placed order for coffee "+ct.ordinal()+" for size "+ms.ordinal());
	}
	
}
