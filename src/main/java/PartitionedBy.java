import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionedBy {

    static class Employee {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + " ($" + salary + ")";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", 60000),
                new Employee("Bob", 45000),
                new Employee("Charlie", 70000),
                new Employee("David", 30000)
        );

        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.salary > 50000));

        System.out.println("High earners (>50k): " + partitioned.get(true));
        System.out.println("Low earners (<=50k): " + partitioned.get(false));

        // we can do the same to get even and odd numbers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer>> booleanListMap = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Number: " + booleanListMap.get(true));
        System.out.println("Odd Number: " + booleanListMap.get(false));
    }
}

