public class Inheritance {
    public static void main(String[] args) {
        Man person1 = new Man("Khaqan", 20);
        Woman person2 = new Woman("Laiba", 20);

        person1.displayDetails();
        person2.displayDetails();
    }
}

// hybrid inheritance

class Thing {
    boolean occupiesSpace = true;
    boolean hasMass = true;
}

// single-level inheritance
class LivingThing extends Thing {
    boolean takeBreath = true;
    boolean canDie = true;
    
    void showInfo() {
        System.out.println("This type of thing can take breath and can Die!");
    }
}

//hierarchical inheritance
class NonLivingThing extends Thing {
    boolean takeBreath = false;
    boolean canDie = false;

    void showInfo() {
        System.out.println("This type of thing can take breath and can Die!");
    }
}
// multi-level inheritance
class Human extends LivingThing{
    Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.printf("Name: %s\nAge: %d\n", this.name, this.age);
    }
    String name;
    int age;
}

class Man extends Human {
    Man(String name, int age) {
        super(name, age);
    }

    // dynamic polymorphism
    @Override
    void displayDetails() {
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n", this.name, this.age, this.gender);
    }

    String gender = "Male";
}

class Woman extends Human {
    Woman(String name, int age) {
        super(name, age);
    }

    // dynamic polymorphism
    @Override
    void displayDetails() {
        System.out.printf("Name: %s\nAge: %d\nGender: %s\n", this.name, this.age, this.gender);
    }

    String gender = "Female";
}