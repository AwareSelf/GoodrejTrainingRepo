package stringBuilder.and.wrapper;

public class EnumEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CoffeeShop1 ob = new CoffeeShop1();
		ob.orderCoffee(CoffeeShop1.MugSize.JUMBO, CoffeeShop1.CofeeType.CAPPUCHINO);
		
		
	}

}


class CoffeeShop1
{
	int size;
	enum CofeeType {CAPPUCHINO,EXPRESSO,MOCHA};

	enum MugSize
	{
		SMALL(50),BIG(150),JUMBO(240); //sizes in ml
		
		private int size;
		
		private MugSize(int size)
		{
			this.size =  size;
		}
		
		public int getSize()
		{
			return size;
		}
	}
	
	
	
	
	
	void orderCoffee(MugSize ms,CofeeType ct)
	{
		System.out.println("you have placed order for coffee "+ct.name()+" for mug size "+ms.name()+"\n which can have "+ms.getSize()+" ml of coffee");
		
	//	System.out.println("you have placed order for coffee "+ct.ordinal()+" for size "+ms.getSize());
	}
	
}
