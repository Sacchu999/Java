package interviewQuestions;

import java.util.Comparator;
import java.util.List;

public class Program2 {

    // Find Highest Odd Number
    //  num = "5688248" output = "5"
    public static void main(String[] args) {

        String num = "2568824837359";
        int highest = 0;
        num.chars()
                .map(c -> c - '0')
//                .boxed()
                .filter(n -> n % 2 != 0)
                .max()
                .ifPresent(System.out::println);
//        for (int i : numbers) {
//            if (i % 2 != 0 && (i > highest)) {
//                highest = i;
//            }
//        }
//        System.out.println(highest);
    }
}
