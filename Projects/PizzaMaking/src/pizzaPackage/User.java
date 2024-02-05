package pizzaPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	private static Scanner inp = new Scanner(System.in);

	public static void main(String[] args) {
		String confirmationMessage = "Do you want to make any changes?\nEnter \'yes\' or \'no\': ", positiveCase = "yes",
				negativeCase = "no";
		System.out.println("\t==================\n" + "\t   CU Pizza Hut\n" + "\t==================");
		System.out.print("How many pizzas you want to order?: ");
		int pizzaNums = inp.nextInt();
		Pizza[] pizzas = new Pizza[pizzaNums];

		// order taking
		for (int i = 0; i < pizzas.length; i++) {
			takeOrder(pizzas, i);
		}

		// print order ids
		showOrderID(pizzas);

		// if any modifications
		if (getNextRunConfirmation(confirmationMessage, positiveCase, negativeCase)) {
			modification(pizzas);
		}

		// print the bill
		showBill(pizzas);
		inp.close();
	}

	// take order
	private static void takeOrder(Pizza[] pizzas, int pizzaIndex) {
		String base = null, size = null;
		int type = 0, pizzaCount = pizzaIndex + 1;
		int[] toppings = null;

		System.out.printf("\n\t --- For Pizza #%d ---", pizzaCount);
		// get the type
		type = takeType();

		// get the size
		size = takeSize();

		// get the base
		base = takeBase();

		// get toppings
		toppings = takeToppings();

		// Pizza object
		pizzas[pizzaIndex] = new Pizza(type, size, base, toppings);
	}

	private static int[] takeToppings() {
		displayToppings();
		int[] toppings = receiveToppings();
		return toppings;
	}

	private static String takeBase() {
		displayBases();
		while (true) {
			System.out.print("Enter Your Choice: ");
			String base = inp.nextLine().strip();
			for (String baseCheck : Pizza.getAvailableBases()) {
				if (base.equalsIgnoreCase(baseCheck)) {
					return base;
				}
			}
			System.out.println("Wrong Choice!");
		}
	}

	private static String takeSize() {
		displaySizes();
		while (true) {
			System.out.print("Enter Your Choice: ");
			String size = inp.nextLine().strip();
			for (String sizeCheck : Pizza.getAvailableSizes()) {
				if (size.equalsIgnoreCase(sizeCheck)) {
					return size;
				}
			}
			System.out.println("Wrong Choice!");
		}
	}

	private static int takeType() {
		displayTypes();
		while (true) {
			System.out.print("Enter Your Choice: ");
			int type = inp.nextInt();
			
			// buffer \n char fixing
			inp.nextLine();
			if (1 <= type && type <= Pizza.getAvailableTypes().length) {
				return type;
			} else {
				System.out.println("Wrong Choice!");
			}
		}
	}

	// receive toppings
	private static int[] receiveToppings() {
		String confirmationMessage = "Do you want to add more toppings?\nEnter \'yes\' or \'no\': ",
				positiveCase = "yes", negativeCase = "no";
		int[] toppings = new int[3];
		int topping = 0;
		System.out.println("Note: You can add only upto 3 topings");
		for (int i = 0; i < toppings.length; i++) {
			while (true) {
				System.out.print("Enter Your Choice: ");
				topping = inp.nextInt();

				// remove newLine char storage in buffer
				inp.nextLine();
				// validate topping
				if (1 <= topping && topping <= Pizza.getAvailableToppings().length) {
					toppings[i] = topping;
					break;
				} else {
					System.out.println("Wrong Choice!");
				}
			}

			if (i != (toppings.length - 1)) {
				// take confirmation
				if (getNextRunConfirmation(confirmationMessage, positiveCase, negativeCase)) {
					continue;
				} else {
					return toppings;
				}
			}
		}
		return toppings;

	}

	// for confirmation
	private static boolean getNextRunConfirmation(String confirmationMessage, String positiveCase,
			String negativeCase) {
		while (true) {
			System.out.print(confirmationMessage);
			String choice = inp.nextLine().strip();
			if (choice.equalsIgnoreCase(positiveCase)) {
				return true;
			} else if (choice.equalsIgnoreCase(negativeCase)) {
				return false;
			} else {
				System.out.println("Wrong choice!");
			}
		}
	}

	// display the bill
	private static void showBill(Pizza[] pizzas) {
		int totalBill = 0;
		for (int i = 0; i < pizzas.length; i++) {
			showPizzaDetails(pizzas[i], i);
			totalBill += pizzas[i].bill();
		}
		System.out.printf("Total Bill: %d", totalBill);
	}

	private static void showPizzaDetails(Pizza pizza, int i) {
		System.out.printf("Details for Pizza #%d:\n ID: %s\n Type: %s\n Size: %s\n Base: %s\n Toppings: %s\n Price: %d\n",
				i + 1, pizza.getPizzaID(), pizza.getType(), pizza.getSize(), pizza.getBase(), pizza.getToppings(), pizza.bill());	
	}

	// show the order id
	private static void showOrderID(Pizza[] pizzas) {
		for (int i = 0; i < pizzas.length; i++) {
			System.out.printf("Order ID for Pizza #%d: %s\n", i + 1, pizzas[i].getPizzaID());
		}
	}

	// for modifications
	private static void modification(Pizza[] pizzas) {
		ArrayList<String> pizzaIDs = takePizzaIDs(pizzas);
		for (String pizzaID : pizzaIDs) {
			// first display details
			displayDetails(pizzaID, pizzas);
			// now make changes
			makeChanges(pizzaID, pizzas);
		}
	}

	private static void displayDetails(String pizzaID, Pizza[] pizzas) {
		System.out.println("Details for Pizza are:");
		for (Pizza pizza : pizzas) {
			if (pizzaID.equalsIgnoreCase(pizza.getPizzaID())) {
				System.out.printf("ID: %s\nType: %s\nSize: %s\nBase: %s\nToppings: %s", pizza.getPizzaID(), pizza.getType(),
						pizza.getSize(), pizza.getBase(), pizza.getToppings());
				return;
			}
		}
	}

	// make the changes
	private static void makeChanges(String pizzaID, Pizza[] pizzas) {
		int[] changes = new int[4];
		int pizzaIndex = getPizzaIndex(pizzaID, pizzas);
		String confirmationMessage = "Do you want to make any other modification?\nEnter \'yes\' or \'no\':",
				changesMessage = "\nFollowing Changes can be made:\n" + " Type (Enter \'1\')\n"
						+ " Size (Enter \'2\')\n" + " Base (Enter \'3\')\n" + " Toppings (Enter \'4\')\n"
						+ "At a time you can make one change!\n",
				positiveCase = "yes", negativeCase = "no";

		for (int i = 0; i < changes.length; i++) {
			System.out.print(changesMessage);

			// take choice
			while (true) {
				System.out.print("Enter your choice: ");
				changes[i] = inp.nextInt();
				
				// buffer \n char fix
				inp.nextLine();
				if (1 <= changes[i] && changes[i] <= 4) {
					break;
				}
				System.out.println("Wrong Choice!");
			}

			// check which change to be made
			switch (changes[i]) {
			case 1 -> changeType(pizzaIndex, pizzas);
			case 2 -> changeSize(pizzaIndex, pizzas);
			case 3 -> changeBase(pizzaIndex, pizzas);
			default -> changeToppings(pizzaIndex, pizzas);
			}

			if (i != (changes.length - 1)) {
				if (getNextRunConfirmation(confirmationMessage, positiveCase, negativeCase)) {
					continue;
				} else {
					return;
				}
			}
		}
	}

	// pizza index
	private static int getPizzaIndex(String pizzaID, Pizza[] pizzas) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzaID.equalsIgnoreCase(pizzas[i].getPizzaID())) {
				return i;
			}
		}
		return -1;
	}

	// change types
	private static void changeType(int pizzaIndex, Pizza[] pizzas) {
		displayTypes();
		System.out.print("Enter Your Choice: ");
		int type = inp.nextInt();
		pizzas[pizzaIndex].setType(type);

		// handle the left \n char in buffer
		inp.nextLine();
	}

	private static void changeSize(int pizzaIndex, Pizza[] pizzas) {
		displaySizes();
		System.out.print("Enter Your Choice: ");
		String size = inp.nextLine().strip();
		pizzas[pizzaIndex].setSize(size);
	}

	private static void changeBase(int pizzaIndex, Pizza[] pizzas) {
		displayBases();
		System.out.print("Enter Your Choice: ");
		String base = inp.nextLine().strip();
		pizzas[pizzaIndex].setBase(base);
	}

	private static void changeToppings(int pizzaIndex, Pizza[] pizzas) {
		displayToppings();
		System.out.print("Enter Your Choice: ");
		int[] toppings = receiveToppings();
		pizzas[pizzaIndex].setToppings(toppings);
	}

	// take the pizza ids to be changed
	private static ArrayList<String> takePizzaIDs(Pizza[] pizzas) {
		String pizzaID = null,
				confirmationMessage = "Do you want to make modification to another Pizza?\nEnter \'yes\' or \'no\':",
				positiveCase = "yes", negativeCase = "no";
		ArrayList<String> pizzaIDs = new ArrayList<String>();
		boolean validID = false, alreadyPresent = false;
		for (int i = 0; i < pizzas.length; i++) {
			// take and check pizzaIDs
			while (true) {
				System.out.print("Enter Pizza ID: ");
				pizzaID = inp.nextLine().strip();

				// check if valid pizza ID
				validID = idValidPizzaID(pizzaID, pizzas);
				// check if previously present
				alreadyPresent = doIDExists(pizzaID, pizzaIDs);
				if (validID && !alreadyPresent) {
					pizzaIDs.add(pizzaID);
					break;
				} else {
					System.out.println("Invalid PizzaID!");
				}
			}
			if (i != (pizzas.length - 1)) {
				if (getNextRunConfirmation(confirmationMessage, positiveCase, negativeCase)) {
					continue;
				} else {
					return pizzaIDs;
				}
			}
		}
		return pizzaIDs;
	}

	// do id exists
	private static boolean doIDExists(String pizzaID, ArrayList<String> pizzaIDs) {
		for (String id : pizzaIDs) {
			if (id.equalsIgnoreCase(pizzaID)) {
				return true;
			}
		}
		return false;
	}

	// check validity of pizzaID
	private static boolean idValidPizzaID(String pizzaID, Pizza[] pizzas) {
		for (Pizza pizza : pizzas) {
			if (pizzaID.equalsIgnoreCase(pizza.getPizzaID())) {
				return true;
			}
		}
		return false;
	}

	// display methods
	private static void displayTypes() {
		String[] types = Pizza.getAvailableTypes();
		System.out.println("\nFollowing are the available Pizza Types:");
		for (int i = 0; i < types.length; i++) {
			System.out.printf("%s (Enter \'%d\')\n", types[i], i + 1);
		}
	}

	private static void displaySizes() {
		String[] sizes = Pizza.getAvailableSizes();
		System.out.println("\nFollowing are the available Pizza Sizes:");
		for (int i = 0; i < sizes.length; i++) {
			System.out.printf("%s\n", sizes[i]);
		}
	}

	private static void displayBases() {
		String[] bases = Pizza.getAvailableBases();
		System.out.println("\nFollowing are the available Pizza Bases:");
		for (int i = 0; i < bases.length; i++) {
			System.out.printf("%s\n", bases[i]);
		}
	}

	private static void displayToppings() {
		String[] toppings = Pizza.getAvailableToppings();
		System.out.println("\nFollowing are the available Pizza Toppings:");
		for (int i = 0; i < toppings.length; i++) {
			System.out.printf("%s (Enter \'%d\')\n", toppings[i], i + 1);
		}
	}
}