import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Print all the odd and even numbers from the below list seperately
// [11,22,33,44,55,66,77,88,99]
public class OddAndEven {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99);
        printOddAndEven(list);
        //printOddAndEven2(list);
    }

    public static void printOddAndEven(List<Integer> integerList) {

        List<Integer> oddNumbers = integerList.stream()
                .filter(integer -> (integer % 2 != 0))
                .toList();

        System.out.println("Odd numbers in list : " + oddNumbers);
        List<Integer> evenNumbers = integerList.stream()
                .filter(integer -> (integer % 2 == 0))
                .toList();
        System.out.println("Even numbers in list : " + evenNumbers);
    }

    public static void printOddAndEven2(List<Integer> integerList) {
        Map<Boolean, List<Integer>> partitioned = integerList.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 != 0));

        List<Integer> oddNumbers = partitioned.get(true);
        List<Integer> evenNumbers = partitioned.get(false);

        System.out.println("Odd numbers in list : " + oddNumbers);
        System.out.println("Even numbers in list : " + evenNumbers);
    }
}
