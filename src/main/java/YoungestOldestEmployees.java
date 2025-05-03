import java.util.Comparator;
import java.util.List;

public class YoungestOldestEmployees {

    static class Employee {
        String name;
        int age;

        Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " | Age: " + age;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", 30),
                new Employee("Bob", 25),
                new Employee("Charlie", 35),
                new Employee("David", 40)
        );

        // TODO: Find youngest and oldest employee
        Employee youngest = employees.stream()
                .min(Comparator.comparingInt(e -> e.age))
                .get();

        Employee oldest = employees.stream()
                .max(Comparator.comparingInt(e -> e.age))
                .get();

        System.out.println("Youngest: " + youngest);
        System.out.println("Oldest: " + oldest);
    }
}
