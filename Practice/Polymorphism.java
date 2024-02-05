public class Polymorphism {
    public static void main(String[] args) {
        Employee e1 = new Employee("001-mhr", "Muhammad Hassan Raza", 20);
        e1.displayDetails(e1.id);
        Employee e2 = new Employee(e1);
        e2.displayDetails(e2.name, e2.age);

    }
}

class Employee {
    String name, id;
    int age;

    Employee (String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    Employee(Employee e) {
        this.id = e.id;
        this.name = e.name;
        this.age = e.age;
    }

    // static polymorphism
    void displayDetails(String id) {
        System.out.printf("Employee ID: %s\nEmployee Name: %s\nEmployee Age: %d\n", this.id, this.name, this.age);
    }
    void displayDetails(String name,int age) {
        System.out.printf("Employee Name: %s\nEmployee Age: %d\n",this.name, this.age);
    }
}