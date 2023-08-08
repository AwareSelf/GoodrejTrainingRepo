package misci;

import java.util.*;
import java.text.*;
import java.time.*;
import java.time.format.*;

 
public class DateNumberCurrencyFormatDemo {

 
  static public void main(String[] args) throws ParseException  {
      
 
	  Locale.Builder lb = new Locale.Builder();
	  lb.setLanguage("fr");
	  lb.setRegion("FR");
	  Locale l = lb.build();
	  
	 Integer no = 1234567;
	 Double amt = 5125500.556;
	 
	 NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
	 System.out.println(nf.format(amt));
	 nf = NumberFormat.getInstance(l);
	 System.out.println(Locale.FRENCH.getDisplayName()+":"+nf.format(amt));
	  
	 nf = NumberFormat.getInstance(Locale.US);
	 System.out.println(Locale.US.getDisplayName()+":"+nf.format(amt));
	 
    System.out.println(Locale.FRENCH.getDisplayName());
    System.out.println(Locale.getDefault().getDisplayName());
    	
    nf = NumberFormat.getInstance(Locale.FRENCH);
     amt = (Double) nf.parse("5 125 500,556");
     System.out.println("After parsing string amt = 5 125 500,556 using French locale,"
     		+ " amt = "+amt); 
   
     NumberFormat nf1 =  NumberFormat.getCurrencyInstance(Locale.FRANCE);
     Currency c = Currency.getInstance(Locale.FRANCE);
     System.out.println(c.getDisplayName()+":"+nf1.format(250.5));
     
        
     c = Currency.getInstance(Locale.CHINA);
     nf1 =  NumberFormat.getCurrencyInstance(Locale.CHINA);
     System.out.println(c.getDisplayName()+":"+nf1.format(250.5));

     System.out.println(c.getDisplayName()+":"+nf1.parse("¥250.50"));
     
     LocalDate d = LocalDate.now();
     LocalDateTime dt = LocalDateTime.now();
     System.out.println("LocalDate:"+d+",LocalDateTime:"+dt);
     
     DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss", l);
     System.out.println(l.getDisplayName()+":"+df.format(dt));
     
     df = DateTimeFormatter.ofPattern("dd MMM uuuu",Locale.GERMAN);
     System.out.println(Locale.GERMAN.getDisplayName()+":"+df.format(dt));
     df = DateTimeFormatter.ofPattern("dd MMM uuuu",Locale.ITALY);
     System.out.println(Locale.ITALY.getDisplayName()+":"+df.format(dt));
     
     //current/default locale
     df = DateTimeFormatter.ofPattern("dd MMM uuuu");
     System.out.println(Locale.getDefault().getDisplayName()+":"+df.format(dt));
     
     
     df = DateTimeFormatter.ofPattern("dd MMM uuuu",Locale.ITALY);
     LocalDate dd = LocalDate.parse("30 set 2022",df);
     System.out.println("After parsing Italy locale date:30 set 2022 "
     		+ "to current/default Locale date:"+dd);
  }
}