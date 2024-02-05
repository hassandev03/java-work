public class Abstraction {
    public static void main(String[] args) {
        Employee e1 = new Employee("001-mhr", "Muhammad Hassan Raza", 20);
        e1.displayDetails(e1.id);
        e1.action();
        System.out.println();

        Employee e2 = new Employee(e1);
        e2.displayDetails(e1.id);
        e2.action();
        System.out.println();

        Employer e = new Employer("001-ss", "Sam Smith", 30);
        e.displayDetails(e.id);
        e.action();
    }
}

abstract class MemberOfOrg {
	String id, name;
	int age;
    abstract void action();
    abstract void displayDetails(String id);
}

class Employee extends MemberOfOrg {

    Employee(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    Employee(Employee ee) {
        this.id = ee.id;
        this.name = ee.name;
        this.age = ee.age;
    }

    @Override
    void action() {
        System.out.println("Works for Company!");
    }

    @Override
    void displayDetails(String id) {
        System.out.printf("Employee ID: %s\nEmployee Name: %s\nEmployee Age: %d\n", this.id, this.name, this.age);
    }
}

class Employer extends MemberOfOrg {
    Employer(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    void action() {
        System.out.println("Hires Employees for Company!");
    }

    @Override
    void displayDetails(String id) {
        System.out.printf("Employer ID: %s\nEmployer Name: %s\nEmployer Age: %d\n", this.id, this.name, this.age);
    }
}