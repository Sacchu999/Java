package interviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program1 {

    // Write a java program to group a list of strings based on their lengths.
    public static void main(String[] args) {

        List<String> inputList = Arrays.asList("dog", "cat", "elephant", "rabbit", "fox", "giraffe", "ant", "zebra", "owl");
        Map<Integer, List<String>> map = inputList.stream().collect(Collectors.groupingBy(String::length));
        map.forEach((integer, strings) ->
                System.out.println("Number Length :" + integer + " -> " + strings.size() + " Animal names : " + strings));
    }

}
