import java.util.List;
import java.util.stream.Collectors;


public class Stream {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);//4 16 36

        List<Integer> integers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(m -> m * m)
                .toList();
        System.out.println(integers);


        List<Employee> employees = List.of(
                new Employee("Nitin", "IT", 60000),
                new Employee("Ravi", "IT", 70000),
                new Employee("Arun", "IT", 80000)
        );

        Boolean areAllEmployeesEarning = employees.stream()
                .filter(emp -> emp.department.equals("IT"))
                .allMatch(emp -> emp.salary >= 50000);
        System.out.println(areAllEmployeesEarning);

        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<Person> people = names.stream()
                .map(name -> new Person(name, 25)) // Convert string to Person object
                .collect(Collectors.toList());
        System.out.println(people.toString());
    }
}

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }


}
