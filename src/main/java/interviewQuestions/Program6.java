package interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Program6 {

    /**
     * Find the highest and second-highest salary of employee using java 8.
     */
    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
                new Employee(101, "John", 1000),
                new Employee(102, "Jane", 2000),
                new Employee(103, "Bob", 3000),
                new Employee(104, "Alice", 4000),
                new Employee(105, "Charlie", 5000)
        );
        employeeList
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(2)
                .forEach(System.out::println);

    }
}

class Employee {

    private int id;
    private String name;
    private double salary;

    // Parameterized constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getter and Setter for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
