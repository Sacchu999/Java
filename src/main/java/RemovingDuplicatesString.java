import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RemovingDuplicatesString {

    //Create a Set of names. Add a few duplicates.
    // Print the set. Then create a Map<String, Integer> of student names and their marks. Print it.
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Sachin");
        names.add("Nitin");
        names.add("Sachin");
        names.add("Ayush");
        names.add("Pyush");
        names.add("Nitin");

        System.out.println(names);

        Map<String, Integer> students = new HashMap<>();
        students.put("Sachin", 96);
        students.put("Nitin", 96);
        students.put("Pyush", 96);
        students.put("Ayush", 96);
        students.put("Sachin", 96);

        System.out.println(students);

        //    Count the frequency of characters in a string using Map<Character, Integer>.

        String river = "missisippi";
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : river.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        System.out.println(frequency);

        Map<String, Integer> wordsFreqUsingTreemap = new TreeMap<>();

        String words = "apple banana apple orange banana apple";

        for (String word : words.split(" ")) {
            wordsFreqUsingTreemap.put(word, wordsFreqUsingTreemap.getOrDefault(word, 0) + 1);
        }
        // Print each word → frequency in sorted order
        for (Map.Entry<String, Integer> entry : wordsFreqUsingTreemap.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

    }

}
