import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTask1 {

    static class Employee {
        String name;
        String department;
        int age;

        Employee(String name, String department, int age) {
            this.name = name;
            this.department = department;
            this.age = age;
        }

        public String getDepartment() {
            return department;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " (" + department + ")";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 30),
                new Employee("Bob", "Engineering", 25),
                new Employee("Charlie", "HR", 35),
                new Employee("David", "Engineering", 40),
                new Employee("Eve", "Engineering", 28)
        );
        //calculate the average age
        Double age = employees.stream().collect(Collectors.averagingDouble(Employee::getAge));
        Double age1 = employees.stream().mapToInt(Employee::getAge).average().orElse(0);
        System.out.println(age);
        System.out.println(age1);
        // Group by department and count the number of employees
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((dept, employees1) -> {
                    System.out.println("Department: " + dept + " and Employees Count: " + employees1.size());
                });

        // Your code here: Group by department and calculate the average age
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getAge)))
                .forEach((dept, avg) -> {
                    System.out.println("Department: " + dept + " and Employees Average age: " + avg);
                });

        // Your code here: Group by department and find the highest-paid employee
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getAge))))
                .forEach((dept, youngest) -> {
                    System.out.println("Department: " + dept + " and Highest Age Employee: " + youngest.get());
                });

        // Your code here: Filter even numbers and find their sum
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream().filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();
        System.out.println(sum);

        // Your code here: Multiply each number by 2 and find the sum
        int multiplicationSum = numbers.stream()
                .mapToInt(n -> n * 2)
                .sum();
        System.out.println(multiplicationSum);
    }
}

