import java.util.Scanner;

public class Population {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Population Calculator ---");

        System.out.print("Enter Current Population: ");
        long poptn = inp.nextLong();

        System.out.print("Enter Birth-Rate (1 birth/?seconds): ");
        int birth = inp.nextInt();

        System.out.print("Enter Death-Rate (1 death/?seconds): ");
        int death = inp.nextInt();

        System.out.print("Enter Immigrant-Rate (1 immigrant/?seconds): ");
        int immigrant = inp.nextInt();
        
        System.out.print("Enter years: ");
        byte reqYears = inp.nextByte();

        PopulationCalculate(reqYears, poptn, birth, death, immigrant);

    }
    static void PopulationCalculate(byte reqYears, long currentPopltn, int birthRate, int deathRate,
                                     int immigrantRate) {
        //              min * hour * day * 365
        long populationPerYear = currentPopltn;
        int secondsInYear = 60 * 60 * 24 * 365;
        double birthPerYear =  ((double) secondsInYear / birthRate);
        double deathPerYear =  ((double) secondsInYear / deathRate);
        double immigrantPerYear =  ((double) secondsInYear / immigrantRate);
        
        for (int year = 1; year <= reqYears; year++) {
            populationPerYear += (long) ((birthPerYear + immigrantPerYear)- deathPerYear);
            System.out.println("Population in the next " + year + " year(s): "
                                 + populationPerYear);
        }

    }
}