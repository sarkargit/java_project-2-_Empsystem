import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {  // Changed from private to public
        return id;
    }

    public abstract double calculateSalary();  // Fixed naming convention

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FulltimeEmployee extends Employee {
    private double monthlySalary;

    public FulltimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class ParttimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate; // Changed from int to double

    public ParttimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class PayRollSystem {
    private List<Employee> employeeList;

    public PayRollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {  // Fixed getId() issue
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {  // Fixed method name
        for (Employee employee : employeeList) {  // Fixed loop variable
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayRollSystem payRollSystem = new PayRollSystem();  // Fixed inconsistent variable name

        FulltimeEmployee emp1 = new FulltimeEmployee("John Doe", 101, 5000.0);
        ParttimeEmployee emp2 = new ParttimeEmployee("Jane Smith", 102, 30, 15.0);  // Fixed data type

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details:");
        payRollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        payRollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payRollSystem.displayEmployees();
    }
}
