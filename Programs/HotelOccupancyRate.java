import java.util.Scanner;

public class HotelOccupancyRate {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Hostel Occupancy Rate ---");
        System.out.print("Enter the number of floors: ");
        int floors = inp.nextInt();
        int totalRooms = 0, totalOccupied = 0;

        for (int i = 0; i < floors; i++) {
            System.out.printf("\t --- Floor #%d\n", i + 1);
            System.out.print("Enter no. of rooms: ");
            int rooms = inp.nextInt();
            totalRooms += rooms;

            System.out.print("Enter no. of occupied rooms: ");
            int occupied = inp.nextInt();
            totalOccupied += occupied;
        }
        System.out.println("Total Rooms in the Hostel: " + totalRooms);
        System.out.println("Total Occupied Rooms: " + totalOccupied);
        System.out.println("Total Unoccupied Rooms: " + (totalRooms - totalOccupied));
        System.out.println("Occupied Rooms Percentage: " + (((float) totalOccupied / totalRooms) * 100) );
    }
}
