package coding.chargebee.question;

import java.util.Scanner;

public class DateFormat {
	public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        String dateOne = s.nextLine();
        String dateTwo = s.nextLine();
        String[] dateOneArray = dateOne.split("-");
        String[] dateTwoArray = dateTwo.split("-");
        int startDate = Integer.parseInt(dateOneArray[0].trim());
        int startMonth = Integer.parseInt(dateOneArray[1].trim());
        int startYear = Integer.parseInt(dateOneArray[2].trim());
        int endDate = Integer.parseInt(dateTwoArray[0].trim());
        int endMonth = Integer.parseInt(dateTwoArray[1].trim());
        int endYear = Integer.parseInt(dateTwoArray[2].trim());
        int currentDate = startDate;
        int currentMonth = startMonth;
        int currentYear = startYear;
        while(currentYear < endYear || (currentYear == endYear && currentMonth < endMonth)
            || (currentYear == endYear && currentMonth == endMonth &&  currentDate <= endDate)){
            if(currentYear == startYear && currentMonth == startMonth
                && currentDate == startDate){
                    System.out.print(printDate(currentDate,currentMonth,currentYear));
                }else{
                    System.out.print(printDate(1,currentMonth,currentYear));
                }
                System.out.print(" to ");
                if(currentYear == endYear && currentMonth == endMonth){
                    System.out.print(printDate(endDate,currentMonth,currentYear));
                }else{
                    System.out.print(printDate(100,currentMonth,currentYear));
                }
                currentDate = 1;
                currentMonth = currentMonth +1;
                if(currentMonth > 12){
                    currentMonth = 1;
                    currentYear = currentYear+1;
                }
                System.out.println();
            }
    }
    
    private static String printDate(int currentDate,int currentMonth,int currentYear){
        String format = "";
        if(currentDate != 100){
            if(currentDate < 10){
                format = "0"+currentDate+"-";
            }else{
                format = currentDate+"-";
            }
            if(currentMonth < 10){
                format += "0"+currentMonth+"-";
            }else{
                format += currentMonth+"-";
            }
        }else{
        switch(currentMonth){
            case 1: format += 31+"-"+"01"+"-";
            break;
            case 2: 
                if(currentYear % 4 == 0 && currentYear % 400 != 0){
                    format += 29+"-"+"02"+"-";
                }else {
                	format += 28+"-"+"02"+"-";
                }
            break;
            case 3: format += 31+"-"+"03"+"-";
            break;
            case 4: format += 30+"-"+"04"+"-";
            break;
            case 5: format += 31+"-"+"05"+"-";
            break;
            case 6: format += 30+"-"+"06"+"-";
            break;
            case 7: format += 31+"-"+"07"+"-";
            break;
            case 8: format += 31+"-"+"08"+"-";
            break;
            case 9: format += 30+"-"+"09"+"-";
            break;
            case 10: format += 31+"-"+"10"+"-";
            break;
            case 11: format += 30+"-"+"11"+"-";
            break;
            case 12: format += 31+"-"+"12"+"-";
            break;
        }
        }
        format += currentYear;
        return format;
    }
}
