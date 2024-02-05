import java.util.Scanner;

public class HouseModelsPrice {
    public static void main(String[] args) {
        float colonialPriceSqFeet = 0f, splitEntryPriceSqFeet = 0f, singleStoryPriceSqFeet = 0f;
        String bestPriceModel = "";

        Scanner inp = new Scanner(System.in);
        System.out.println("\t --- House Model Prices ---");

        System.out.print("Enter Base-Price of Colonial House Model: $");
        float colonialBase = inp.nextFloat();
        System.out.print("Enter Finished Area (in sq. feet): ");
        float colonialArea = inp.nextFloat();

        System.out.print("Enter Base-Price of Split-Entry House Model: $");
        float splitEntryBase = inp.nextFloat();
        System.out.print("Enter Finished Area (in sq. feet): ");
        float splitEntryArea = inp.nextFloat();

        System.out.print("Enter Base-Price of Single-Story House Model: $");
        float singleStoryBase = inp.nextFloat();
        System.out.print("Enter Finished Area (in sq. feet): ");
        float singleStoryArea = inp.nextFloat();

        colonialPriceSqFeet = colonialBase / colonialArea;
        splitEntryPriceSqFeet = splitEntryBase / splitEntryArea;
        singleStoryPriceSqFeet = singleStoryBase / singleStoryArea;

        if (colonialPriceSqFeet < splitEntryPriceSqFeet && colonialPriceSqFeet < singleStoryPriceSqFeet) {
            bestPriceModel = "Colonial House Model";
        } else if (splitEntryPriceSqFeet < colonialPriceSqFeet && splitEntryPriceSqFeet < singleStoryPriceSqFeet) {
            bestPriceModel = "Split-Entry House Model";
        } else if (singleStoryPriceSqFeet < splitEntryPriceSqFeet && singleStoryPriceSqFeet < colonialPriceSqFeet) {
            bestPriceModel = "Single-Story House Model";
        }

        System.out.printf("Price Per Square Feet:\n  Colonial House Model: $%.2f\n" +
                "  Split-Entry House Model: $%.2f\n  Single-Story House Model: $%.2f\n" +
                "Best Price Model: %s", colonialPriceSqFeet, splitEntryPriceSqFeet,
                singleStoryPriceSqFeet, bestPriceModel);
    }
}
