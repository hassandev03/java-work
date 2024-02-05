import java.util.Scanner;
public class FutureDates {
    public static void main(String[] args) {
        int today, passedDays, futureDay;
        String todayName, futureDayName;
        Scanner days = new Scanner(System.in);

        System.out.print("Enter today's day number (0 for Sunday and so on): ");
        today = days.nextInt();
        System.out.print("Enter the no. of days elapsed since today: ");
        passedDays = days.nextInt();
        days.close();

        futureDay = (today + passedDays) % 7;

        if (today == 0){
            todayName = "Sunday";
        }
        else if (today == 1) {
            todayName = "Monday";
        }
        else if (today == 2) {
            todayName = "Tuesday";
        }
        else if (today == 3) {
            todayName = "Wednesday";
        }
        else if (today == 4) {
            todayName = "Thursday";
        }
        else if (today == 5) {
            todayName = "Friday";
        }
        else {
            todayName = "Saturday";
        }

        if (futureDay == 0) {
            futureDayName = "Sunday";
        }
        else if (futureDay == 1) {
            futureDayName = "Monday";
        }
        else if (futureDay == 2) {
            futureDayName = "Tuesday";
        }
        else if (futureDay == 3) {
            futureDayName = "Wednesday";
        }
        else if (futureDay == 4) {
            futureDayName = "Thursday";
        }
        else if (futureDay == 5) {
            futureDayName = "Friday";
        }
        else {
            futureDayName = "Saturday";
        }

        System.out.println("Today is " + todayName + " and the future day is " + futureDayName);
    }
}
