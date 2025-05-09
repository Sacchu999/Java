package interviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This program finds the first occurrence of a non-repeating character in a given string.
 * Example:
 * Input  : "aabbcdec"
 * Output : 'd'
 */
public class Program5 {

    public static Character getNonRepeatingCharacter(String s) {

        char[] c = s.toCharArray();

        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (char ch : c) {
            characterIntegerMap.put(ch, characterIntegerMap.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : characterIntegerMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey(); // Found the first unique character
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "aabbcdec";
        System.out.println(getNonRepeatingCharacter(s));
    }
}
