import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask3 {

    public static void main(String[] args) {

        //1. Find duplicate elements in a Stream in Java?
        List<Integer> numberList = List.of(2, 17, 5, 20, 17, 30, 4, 23, 59, 23, 17, 2);

        Set<Integer> numbs = new HashSet<>();

        Set<Integer> duplicateNumbers = numberList.stream()
                .filter(n -> !numbs.add(n))
                .collect(Collectors.toSet());

        //  duplicateNumbers.forEach(System.out::println);

        String word = "missisippi";
        char c = 's';

        //Using stream
        long occurrences = word.chars().filter(c1 -> c1 == c).count();
        // Using Normal method creation
        System.out.println(occurrences);

        System.out.printf("Occurrence of %c in %s is %d", c, word, occurence(word, c));

        System.out.println(slicingList(numberList, 1, 6));

        //4. Reverse elements
        List<Integer> arrayList = Arrays.asList(2, 17, 5, 20, 17, 30, 4, 23, 59, 23, 17, 2);
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        //Write a Program to Iterate over a Stream with Indices in Java 8
        String[] array = {"a", "b", "c", "d", "e", "f"};
        addIndicesTorrayOfString(array);

        List<String> fruitsList = Arrays.asList("Apple", "banana", "GRAPES", "Pineapple", "MANGO", "Litchi", "guava", "plum", "Peach", "APRICOT");
        System.out.println(addIndicesToList(fruitsList));
    }

    public static int occurence(String word, char c) {
        //2. Count occurrence of a given character in a string using Stream API in Java.
        char[] charArray = word.toCharArray();

        int count = 0;
        for (char c1 : charArray) {
            if (c1 == c) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> slicingList(List<Integer> integerList, int startIndex, int endIndex) {
        //2. Slice the stream according to the given indexes

        return integerList.stream()
                .skip(startIndex)
                .limit(endIndex - startIndex + 1)
                .toList();
    }

    public static void addIndicesTorrayOfString(String[] word) {
        //Write a Program to Iterate over a Stream with Indices in Java 8

        IntStream.range(0, word.length).mapToObj(w -> String.format("%d -%s", w, word[w]))
                .forEach(System.out::println);
    }

    public static Map<Integer, String> addIndicesToList(List<String> words) {
        //Write a Program to map each word to its indices

        return IntStream.range(0, words.size()).boxed()
                .collect(Collectors.toMap(i -> i, words::get));
    }


}
