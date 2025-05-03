import java.util.Comparator;
import java.util.List;

public class ComparatorTask {

    static class Employee {
        String name;
        int age;
        double salary;

        Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + " | Age: " + age + " | Salary: $" + salary;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", 30, 50000),
                new Employee("Bob", 25, 70000),
                new Employee("Charlie", 35, 50000),
                new Employee("David", 40, 70000)
        );


        // TODO: Sort using Comparator and print
        List<Employee> employees1 = employees.stream()
                .sorted(Comparator.comparingDouble((Employee e) -> e.salary)
                .reversed()
                .thenComparing((Employee e) -> e.age))
                .toList();

        employees1.forEach(e -> System.out.println(e.toString()));
    }
}

