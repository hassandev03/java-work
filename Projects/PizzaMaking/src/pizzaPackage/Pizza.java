package pizzaPackage;

class Pizza {
	private static String[] availableTypes = { "Chicken Tikka", "Crown Crust", "Chicken Fujita" };
	private static String[] availableBases = { "Thin", "Medium", "Thick" };
	private static String[] availableSizes = { "Small", "Regular", "Large" };
	private static String[] availableToppings = { "Extra Cheese", "Black Olives", "Sausage", "Mushroom", "Pepperoni" };
	private String base;
	private int type;
	private String size;
	private int[] toppings = new int[3];
	private String pizzaID = pizzaIDGen();
	

	// constructor
	public Pizza(int type, String size, String base, int[] toppings) {
		this.base = base;
		this.type = type;
		this.size = size;
		this.toppings = toppings;
	}

	// pizza id generator
	public String pizzaIDGen() {
		pizzaID = "";
		// string generator
		for (int i = 0; i <= 3; i++) {
			pizzaID += ((char) ('A' + (int) (Math.random() * 25))) + "";
		}
		// number generator
		for (int j = 0; j <= 4; j++) {
			pizzaID += ((int) (Math.random() * 11)) + "";
		}
		return pizzaID;
	}

	// getters
	public String getBase() {
		return Character.toUpperCase(base.charAt(0)) + base.substring(1);
	}

	public String getSize() {
		return Character.toUpperCase(size.charAt(0)) + size.substring(1);
	}

	public String getToppings() {
		String toppingName = "";
		for (int toppingNum : toppings) {
			toppingName += switch (toppingNum) {
			case 1 -> "\n  " + availableToppings[0];
			case 2 -> "\n  " + availableToppings[1];
			case 3 -> "\n  " + availableToppings[2];
			case 4 -> "\n  " + availableToppings[3];
			default -> "\n  " + availableToppings[4];
			};
		}
		return toppingName;
	}

	public String getPizzaID() {
		return pizzaID;
	}

	public String getType() {
		String typeName = switch (type) {
		case 1 -> availableTypes[0];
		case 2 -> availableTypes[1];
		default -> availableTypes[2];
		};
		return typeName;
	}
	
	public static String[] getAvailableTypes() {
		return availableTypes;
	}

	public static String[] getAvailableBases() {
		return availableBases;
	}

	public static String[] getAvailableSizes() {
		return availableSizes;
	}

	public static String[] getAvailableToppings() {
		return availableToppings;
	}

	// setters
	public void setBase(String base) {
		this.base = base;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setToppings(int[] toppings) {
		this.toppings = toppings;
	}

	public int bill() {
		int totalBill = 0;

		// for base price
		totalBill += switch (base.toLowerCase()) {
		case "Thin" -> 150;
		case "Medium" -> 220;
		case "Thick" -> 300;
		default -> 0;
		};

		totalBill += switch (size.toLowerCase()) {
		case "Small" -> 200;
		case "Regular" -> 400;
		case "Large" -> 700;
		default -> 0;
		};

		totalBill += switch (type) {
		// chicken tikka
		case 1 -> 300;
		// crown crust
		case 2 -> 500;
		// chicken fujita
		case 3 -> 350;
		default -> 0;
		};

		for (int choice : toppings) {
			totalBill += switch (choice) {
			// extra cheese
			case 1 -> 150;
			// black olives
			case 2 -> 200;
			// sausage
			case 3 -> 300;
			// mushrooms
			case 4 -> 120;
			// pepperoni
			case 5 -> 300;
			default -> 0;
			};
		}
		return totalBill;
	}
}