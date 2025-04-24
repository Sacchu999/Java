import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a program to Remove duplicates from the list
 */
public class RemovingDuplicatesInteger {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 12, 56, 73, 23, 12, 19, 73, 25, 23);
        removingDuplicates(list);
        removingDuplicates2(list);
        removingDuplicates3(list);

    }

    public static void removingDuplicates(List<Integer> integerList) {

        // Use this if order of elements is not important
        Set<Integer> set = new HashSet<>(integerList);
        List<Integer> updatedList = set.stream().toList();
        System.out.println("Updated List is : " + updatedList);
    }

    public static void removingDuplicates2(List<Integer> integerList) {

        // Use this if order of elements is important as linkedHashset preserves the order
        Set<Integer> set = new LinkedHashSet<>(integerList);
        List<Integer> updatedList = set.stream().toList();
        System.out.println("Updated List is : " + updatedList);
    }

    public static void removingDuplicates3(List<Integer> integerList) {

        // This is done directly by using stream distinct Function while keeping the order of insertion
        List<Integer> listWithNoDuplicates = integerList.stream().distinct().toList();
        System.out.println(listWithNoDuplicates);
    }
}
