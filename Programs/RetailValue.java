import java.util.Scanner;

public class RetailValue {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        final float PRODUCT1 = 2.98f, PRODUCT2 = 4.50f, PRODUCT3 = 9.98f,
                PRODUCT4 = 4.49f, PRODUCT5 = 6.87f;

        System.out.println("\t --- Retail Value of Sold Products ---");
        double totalPrice = 0.0;
        int productNum = 0, quantity = 0;
        while (true) {
            System.out.print("Enter Product Number: ");
            productNum = inp.nextInt();
            System.out.print("Enter Quantity Sold: ");
            quantity = inp.nextInt();

            if (productNum == -99 || quantity == -99) {
                break;
            }
            else if (quantity > 0 && (productNum >= 1 || productNum <= 5)) {
                totalPrice += switch (productNum) {
                    case 1 -> PRODUCT1 * quantity;
                    case 2 -> PRODUCT2 * quantity;
                    case 3 -> PRODUCT3 * quantity;
                    case 4 -> PRODUCT4 * quantity;
                    case 5 -> PRODUCT5 * quantity;
                    default -> 0;
                };
            } else {
                System.out.println("Invalid Product or Quantity");
            }
        }
        if (totalPrice > 0.0) {
            System.out.println("Retail Value of All Products Sold: " + totalPrice);
        } else {
            System.out.println("No Products Sold!");
        }
    }
}