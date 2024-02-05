import java.util.Scanner;

public class FramePicture {
    public static void main(String[] args) {
        int crownNum = 0;
        float frameCost = 0f, colorCost = 0f, crownCost = 0f, cardCost = 0f,
                glassCost = 0f, frameSize = 0f, totalCost = 0f;

        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- Frame of Picture ---");
        System.out.print("Enter Length of Picture (in inches): ");
        float length = inp.nextFloat();

        System.out.print("Enter Width of Picture (in inches): ");
        float width = inp.nextFloat();

        inp.nextLine();
        System.out.print("What is the type of Frame? ('Fancy' or 'Regular'): ");
        String frameType = inp.nextLine();

        System.out.print("Enter Frame-Color of your choice: ");
        String color = inp.nextLine();

        System.out.print("Do you want to add Crowns? (Enter 'true'/'false'): ");
        boolean crown = inp.nextBoolean();
        if (crown) {
            System.out.print("Enter number of crowns: ");
            crownNum = inp.nextInt();
            crownCost = crownNum * (0.35f);
        }

        System.out.print("Do you want to add CardBoard behind the picture? (Enter 'true'/'false'): ");
        boolean cardBoard = inp.nextBoolean();

        System.out.print("Do you want to add Glass Coating? (Enter 'true'/'false'): ");
        boolean glass = inp.nextBoolean();

        frameSize = 2 * (length + width);
        if (cardBoard) {
            // cardboard cost = $0.02 per square inch (Area)
            cardCost = 0.02f * length * width;
        }
        if (glass) {
            // glass coating cost = $0.07 per square inch (Area)
            glassCost = 0.07f * length * width;
        }

        if (frameType.equalsIgnoreCase("regular")) {
            frameCost = 0.15f * frameSize;

        } else if (frameType.equalsIgnoreCase("fancy")) {
            frameCost = 0.25f * frameSize;
        }
        colorCost = 0.10f * frameSize;
        totalCost = frameCost + colorCost + glassCost + cardCost + crownCost;

        System.out.printf("Frame Type: %s\nFrame Color: %s\nCrowns: %d\n" +
                "Glass Coating: %b\nCard Board: %b\nCost for Framing Picture: $%.2f",
                frameType.toUpperCase(), color.toUpperCase(), crownNum, glass,
                cardBoard, totalCost);
    }
}
