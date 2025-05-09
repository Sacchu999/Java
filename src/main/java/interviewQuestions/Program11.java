package interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Employees {
    Integer employeesId;
    String name;
    double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeesId=" + employeesId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    Employees(int employeesId, String name, double salary) {
        this.employeesId = employeesId;
        this.name = name;
        this.salary = salary;
    }
}

public class Program11 {

    public static void main(String[] args) {
        List<Employees> EmployeesList = Arrays.asList(
                new Employees(101, "John", 1000),
                new Employees(102, "Jane", 2000),
                new Employees(103, "Bob", 3000),
                new Employees(104, "Alice", 4000),
                new Employees(105, "Charlie", 5000)
        );

        Optional<Employees> emp = EmployeesList.stream()
                .sorted(Comparator.comparing(Employees::getSalary).reversed())
                .skip(1)
                .findFirst();
        System.out.println(emp.get());
    }
}
