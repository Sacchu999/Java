package main.java;

import java.util.ArrayList;
import java.util.List;

public class Task1 {

    //Create a List of integers. Add numbers 1 to 5. Then remove 3. Finally, print the list.
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.addAll(List.of(1, 2, 3, 4, 5));
        integerList.remove(2);
        System.out.println(integerList);
    }

}
