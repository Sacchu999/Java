package interviewQuestions;

public class Program4 {

    public static void getSmallestString(String s) {
        int n = s.length();
        char minChar = s.charAt(0);
        int minIndex = 0;

        // Step 1: Find the lexicographically smallest character and its first occurrence
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < minChar) {
                minChar = s.charAt(i);
                minIndex = i;
            }
        }
        System.out.println("Smallest character: " + minChar);
        System.out.println("First occurrence at index: " + minIndex);
    }

    public static void main(String[] args) {
        String s1 = "cab";
        String s2 = "aaaba";

        getSmallestString(s2); // Print the result
    }
}
