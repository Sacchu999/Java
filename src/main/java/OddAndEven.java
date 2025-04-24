import java.util.Arrays;
import java.util.List;

public class OddAndEven {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99);
        printOddAndEven(list);
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
}
