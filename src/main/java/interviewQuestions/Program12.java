package interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
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

        String input = "programming";

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) + 1);
        }
        characterIntegerMap.forEach((character, integer) -> {
            //   System.out.printf("Character : %c%n Number of times : %d", character, integer);
        });

        System.out.println(streamExample(input));

        List<String> list = Arrays.asList("Sachin", "Nitin", "Manesh", "Pankaj");

    }

    public static Map<Character, Long> streamExample(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //.entrySet()
        //.stream()
        //.filter(e -> e.getValue() > 1)
        //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
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

