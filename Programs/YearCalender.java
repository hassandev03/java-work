import java.util.Scanner;

public class YearCalender {
	public static void main(String[] args) {
		String month = "";
		
		/**  for switch case, always give a default starting value to that variable which is
		* to be initialized in case, so that compiler does not make issue that
		* value of variable may not have been initialized
		*/
		int days = 0;
		Scanner inp = new Scanner(System.in);
		inp.close();
		
		System.out.println("\t --- Year Calender Print ---");
		System.out.print("Enter year: ");
		int year = inp.nextInt();

		System.out.print("Enter first day of year (0 for Sunday and so on) : ");
		int firstDay = inp.nextInt();

		for (int i = 1; i <= 12; i++) {
			boolean toPrint = false;
			int day = 1;
			switch (i) {
				case 1: {
					month = "January";
					days = 31;
					break;
				}
				case 2: {
					month = "February";
					days = ((year % 4 == 0) && (year % 100 != 0)) || year % 400 == 0 ? 29 : 28;
				}
				case 3: {
					month = "March";
					days = 31;
					break;
				}
				case 4: {
					month = "April";
					days = 30;
					break;
				}
				case 5: {
					month = "May";
					days = 31;
					break;
				}
				case 6: {
					month = "June";
					days = 30;
					break;
				}
				case 7: {
					month = "July";
					days = 31;
					break;
				}
				case 8: {
					month = "August";
					days = 31;
					break;
				}
				case 9: {
					month = "September";
					days = 30;
					break;
				}
				case 10: {
					month = "October";
					days = 31;
					break;
				}
				case 11: {
					month = "November";
					days = 30;
					break;
				}
				case 12: {
					month = "December";
					days = 31;
					break;
				}
			}
			System.out.printf("%n\t\t\t     %s %d%n", month, year);
			System.out.println("\t" + "-".repeat(52));

			System.out.printf("\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
					"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");

			for (int weeks = 1; weeks <= 6; weeks++) {
				System.out.print("\t");
				for (int weekDay = 0; weekDay <= 6; weekDay++) {

					if (weekDay == firstDay) {
						toPrint = true;
					}
					if (toPrint) {
						if (day <= days) {
							System.out.print(day + "\t");
							day++;
						}
						if (day > days) {
							firstDay = weekDay + 1;
							if (firstDay == 7) {
								firstDay = 0;
							}
							break;
						}
					} else {
						System.out.print("\t");
					}
				}
				System.out.println();

				if (day > days) {
					break;
				}
			}
		}
	}
}