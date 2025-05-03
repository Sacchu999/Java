import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingBy {

    static class Employee {
        String name;
        String department;
        double salary;

        Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + " | " + department + " | $" + salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 60000),
                new Employee("Bob", "HR", 50000),
                new Employee("Charlie", "IT", 70000),
                new Employee("David", "Finance", 55000),
                new Employee("Eve", "HR", 48000)
        );

        // TODO: Group employees by department
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.department));

        groupedByDept.forEach((dept, emps) -> {
            System.out.println("Department: " + dept);
            emps.forEach(System.out::println);
            System.out.println();
        });


        groupedByDept.forEach((dept, emps) -> {
            System.out.println("Department: " + dept);
            emps.forEach(System.out::println);
            System.out.println();
        });

//    Can you count how many employees are in each department?

        groupedByDept.forEach((s, employees1) -> {
            System.out.println("Department: " + s + " Employees: " + employees1.size());
        });

//    Can you calculate the average salary per department?
        Map<String, Double> avarageSalary = employees.stream()
                .collect(Collectors.groupingBy((employee -> employee.department),
                        Collectors.averagingDouble(value -> value.salary)));

        avarageSalary.forEach((dept, salary) -> System.out.println("Department: " + dept + " Average Salary: " + salary));
//    Can you get the highest-paid employee per department?
//        Map<String, Optional<Employee>> highestSalary = employees.stream()
//                .collect(Collectors.groupingBy((employee -> employee.department),
//                        Collectors.maxBy(Comparator.comparingDouble((Employee e) -> e.salary))));
//        highestSalary.forEach((s, employee) -> {
//            System.out.println("Department: " + s + " Highest Salary: " + employee.orElse(null));
//
//        });
//    To remove the Optional wrapper (if you’re sure all departments have employees):
        Map<String, Employee> highestPaidUnwrapped = employees.stream()
                .collect(Collectors.toMap((
                        employee -> employee.department), Function.identity(), BinaryOperator.maxBy(Comparator.comparingDouble(employee -> employee.salary))));
        highestPaidUnwrapped.forEach((s, employee) -> {
            System.out.println("Department: " + s + " Highest Salary: " + employee.salary);

        });
    }

}

