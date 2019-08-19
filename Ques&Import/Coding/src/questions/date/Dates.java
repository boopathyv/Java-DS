package questions.date;

import java.sql.Timestamp;
import java.util.Date;
public class Dates {

	public static void main(String[] args) {
		int[] date1 = {10,2,2014};
		int[] date2 = {10,3,2015};
		Date dateOne = new Date(date1[2], date1[1], date1[0]);
		Date dateTwo = new Date(date2[2], date2[1], date2[0]);
		System.out.println(dateOne);
		System.out.println(dateTwo);
		Timestamp timeStamp1 = new Timestamp(date1[2], date1[1], date1[0], 0,0,0,0);
		Timestamp timeStamp2 = new Timestamp(date2[2], date2[1], date2[0], 0,0,0,0);
		int date = dateOne.compareTo(dateTwo);
		System.out.println("Difference :"+date);
	}
}

//4.Given two dates, find total number of days between them.
//
//Input: dt1 = {10, 2, 2014} dt2 = {10, 3, 2015}
//Output: 393