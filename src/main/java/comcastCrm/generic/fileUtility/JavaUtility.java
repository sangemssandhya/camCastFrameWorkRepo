package comcastCrm.generic.fileUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
 public int getRandomNum()
 {
	 Random random=new Random();
	 int randomnum=random.nextInt(1000);
	 return randomnum;
 }
 public String getSystemDateYYYYMMDD()
 {
	 Date date=new Date();
	 
	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 String dateObj=sdf.format(date);
	 return dateObj;
 }
 
 public String getRequiredDateYYYYMMDD(int days)
 {
	 Date date=new Date();
	 SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	 String startDate=sim.format(date);
	 Calendar cal=sim.getCalendar();
	 cal.add(Calendar.DAY_OF_MONTH, 30);
	 String endDate=sim.format(cal.getTime());
	return endDate;
 }
}