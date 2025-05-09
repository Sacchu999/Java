package interviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Employee1 {
    int id;
    String name;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return id == employee1.id && Objects.equals(name, employee1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    Employee1(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Program10 {
    public static void main(String[] args) {
        Employee1 e1 = new Employee1(1, "A");
        Employee1 e2 = new Employee1(1, "A");
        Employee1 e3 = new Employee1(1, "A");
        Employee1 e4 = new Employee1(1, "A");
        Employee1 e5 = new Employee1(1, "A");

        Map<Employee1, Employee1> h = new HashMap<>();
        h.put(e1, e1);
        h.put(e2, e2);
        h.put(e3, e3);
        h.put(e4, e4);
        h.put(e5, e5);

        System.out.println("HS size: " + h.size());
    }
}

