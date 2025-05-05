import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Write a program to count frequency of a character
 */
public class FrequencyCount {

    public static void main(String[] args) {
        String name = "missisippi";
        String sentence = "My name is sachin and sachin is my friends name too";
        String[] stringArray = {"My", "name", "is", "sachin", "and", "sachin", "is", "my", "friends", "name", "too"};
        List<String> stringList = List.of("My", "name", "is", "sachin", "and", "sachin", "is", "my", "friends", "name", "too");
        frequencyCalculationOfCharacters(name);
        frequencyCalculationofString(sentence);
        frequencyCalculationofArray(stringArray);
        frequencyCalculationofStringusingStreams(stringList);

    }

    public static void frequencyCalculationOfCharacters(String name) {

        // Use HashMap for non sorted insertion order while LinkedHashMap for getting in sorted way
        Map<Character, Integer> characterIntegerMap = new LinkedHashMap<>();

        for (char c : name.toCharArray()) {
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> map : characterIntegerMap.entrySet()) {
            System.out.println("Frequency of " + map.getKey() + " is " + map.getValue());
        }
    }

    public static void frequencyCalculationofString(String sentence) {

        System.out.println("---------------------------------------------------------------");
        // Use HashMap for non sorted insertion order while LinkedHashMap for getting in sorted way
        Map<String, Integer> stringIntegerLinkedHashMap = new LinkedHashMap<>();

        for (String s : sentence.split(" ")) {
            stringIntegerLinkedHashMap.put(s, stringIntegerLinkedHashMap.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> map : stringIntegerLinkedHashMap.entrySet()) {
            System.out.println("Frequency of " + map.getKey() + " is " + map.getValue());
        }
    }

    public static void frequencyCalculationofArray(String[] sentence) {

        System.out.println("---------------------------------------------------------------");
        // Use HashMap for non sorted insertion order while LinkedHashMap for getting in sorted way
        Map<String, Integer> stringIntegerLinkedHashMap = new LinkedHashMap<>();

        for (String s : sentence) {
            stringIntegerLinkedHashMap.put(s, stringIntegerLinkedHashMap.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> map : stringIntegerLinkedHashMap.entrySet()) {
            System.out.println("Frequency of " + map.getKey() + " is " + map.getValue());
        }
    }

    public static void frequencyCalculationofStringusingStreams(List<String> list) {

        System.out.println("---------------------------------------------------------------");
        // Use HashMap for non sorted insertion order while LinkedHashMap for getting in sorted way
        Map<String, Long> stringLongMap = list.stream().collect(Collectors.groupingBy(word -> word, LinkedHashMap::new, Collectors.counting()));

        stringLongMap.forEach((s, aLong) -> {

            System.out.printf("Frequency of %s is %d%n", s, aLong);
        });
    }
}
