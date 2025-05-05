import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTask2 {


    public static void main(String[] args) {
        //Q. Find the longest string in a list of strings using Java streams:
        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");

        List<String> list = strings.stream()
                .sorted(Comparator.comparing(String::length).reversed()).toList();

        Optional<String> longestString = strings
                .stream()
                .max(Comparator.comparingInt(String::length));
        System.out.println(list.getFirst());
        System.out.println(longestString.get());

        System.out.println("-----------------------------------------------------------");

        //Q. Check if a list of integers contains a prime number using Java streams:
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);


        boolean prime = numbers.stream().anyMatch(StreamTask2::isPrime);
        System.out.println("List contains as Prime Number " + prime);

        System.out.println("-----------------------------------------------------------");

        //Q. Merge two sorted lists into a single sorted list using Java streams:
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        Stream.concat(list1.stream(), list2.stream())
                .sorted().forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        //Q. Find the intersection of two lists using Java streams:
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> intersection = list3.stream()
                .filter(list4::contains)
                .toList();
        intersection.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        //Q. Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);

    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
