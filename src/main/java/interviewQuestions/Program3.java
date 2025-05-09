package interviewQuestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Program3 {

    /**
     * Find Nth Highest salary of Employee using Java 8 Stream.
     */

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1000);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);

        System.out.println(nthHighestSalary(5, map1));
    }

    public static Map.Entry<String, Integer> nthHighestSalary(int n, Map<String, Integer> employeeMap) {

        return employeeMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList()
                .get(n - 1);
    }
}
