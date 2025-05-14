package interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Program12 {

    public static void main(String[] args) {
        List<Employee2> employee2List = Arrays.asList(
                new Employee2("John", "HR", 1000),
                new Employee2("Jane", "HR", 2000),
                new Employee2("Bob", "IT", 3000),
                new Employee2("Alice", "IT", 4000),
                new Employee2("Charlie", "FINANCE", 5000),
                new Employee2("Monika", "FINANCE", 8000)

        );
        Employee2 employee2 = employee2List.stream()
                .sorted(Comparator.comparingDouble(Employee2::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(employee2);

        Map<String, Optional<Employee2>> map = employee2List.stream()
                .collect(Collectors.groupingBy(Employee2::getDepartment, Collectors
                        .collectingAndThen(Collectors.toList(), e2 -> e2
                                .stream()
                                .sorted(Comparator.comparingDouble(Employee2::getSalary)
                                        .reversed())
                                .skip(1)
                                .findFirst())));
        map.forEach((s, employee3) -> {
            System.out.println("Department : " + s + " Second highest Salary : ");
            employee3.ifPresentOrElse(emp ->
                    System.out.println(emp.getSalary()), () -> System.out.println("Not available")
            );
        });
    }
}

class Employee2 {

    private String department;
    private String name;
    private double salary;

    // Parameterized constructor
    public Employee2(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getter and Setter for salary
    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee2{department=" + department + ", name='" + name + "', salary=" + salary + "}";
    }
}

