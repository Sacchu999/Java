package interviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java 8 Stream Programs.
 * This class demonstrates various examples using Java 8 Stream API for different operations such as:
 * 1. Separate Odd and Even Numbers
 * 2. Remove duplicate elements from a list
 * 3. Frequency count of characters in a string
 * 4. Frequency of elements in an array
 * 5. Sort list in reverse order
 * 6. Join List of Strings with prefix, suffix, and delimiter
 * 7. Print multiples of 5 from a list
 * 8. Find maximum and minimum values in a list
 * 9. Merge two unsorted arrays into a single sorted array
 * 10. Anagram
 * 11. Merge two unsorted arrays into a single sorted array without duplicates
 * 12. Sum of digits of a number
 * 13. Find three max and min numbers from a list
 * 14. Find Second-largest number in an integer array
 * 15. Sort list of strings in increasing order of their length
 * 16. Find common elements between two arrays
 * 17. Sum and average of all elements in an array
 * 18. Reverse each word in a string
 * 19. Reverse an integer array
 * 20. Find the sum of the first 10 natural numbers
 * 21. Palindrome String
 * 22. Find strings which start with a number
 * 23. Find last element in an array
 * 24. Find duplicate elements from an array
 * 25. Calculate the age of a person
 * 26. Fibonacci Series
 * 27. Print the elements of an array in reverse order
 * 28. Remove all the white spaces in a string
 * 29. Prove that String objects are immutable
 * 30. Count the number of words in a string
 * 31. Reverse a string
 * 32. Remove Leading zeros
 * 33. Print first letter of each word in a string
 * 34. Given a string s, find the length of the longest substring without repeating characters
 * 35. Count each word in a String
 */
public class Program7 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 0, 1, 0, 1, 1, 0, 0, 1, 0);

        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(integer -> integer % 2 != 0));

        List<Integer> newList = new LinkedList<>();
        map.forEach((aBoolean, integerList) -> {
            newList.addAll(integerList);
        });
        System.out.println(newList);

        int[] arr = {2, 5, 4, 7};
        int[] arr1 = {9, 6, 8, 3};

        Stream.concat(Arrays.stream(arr).boxed(), Arrays.stream(arr1).boxed()).sorted().forEach(System.out::println);

        int sum = Arrays.stream(arr).reduce(0, Integer::sum);
        System.out.println(sum);

        int arr2 = Arrays.stream(arr1).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);
        System.out.println(arr2);
    }
}
