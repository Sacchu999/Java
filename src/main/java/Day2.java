package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        // Performance difference
        List<Integer> arrayListList = new ArrayList<>();
        List<Integer> linkedLists = new LinkedList<>();

        for (int i = 0; i < 1000000; i++) {
            arrayListList.add(i);
            linkedLists.add(i);
        }

        // Accessing 500,000th element
        long startTimeLinked = System.nanoTime();
        linkedLists.get(500000); //Slow
        long endTimeLinked = System.nanoTime();
        long startTimeArray = System.nanoTime();
        arrayListList.get(500000); //Fast
        long endTimeArray = System.nanoTime();

        System.out.println("Time taken by Linked List -> " + (endTimeLinked - startTimeLinked + " nanosecond"));
        System.out.println("Time taken by Array List -> " + (endTimeArray - startTimeArray) + " nanosecond");

        int insertions = 10000;
        insertionAtBeginning(arrayListList, linkedLists, insertions);

    }

    public static void insertionAtBeginning(List<Integer> arrayList, List<Integer> linkedList, int insertions) {

        long startTimeLinked = System.nanoTime();
        for (int i = 0; i < insertions; i++) {
            linkedList.add(0, i); //Fast
        }
        long endTimeLinked = System.nanoTime();
        System.out.println("Linked List insertionAtBeginning -> " + (endTimeLinked - startTimeLinked + " nanosecond"));

        long startTimeArray = System.nanoTime();
        for (int i = 0; i < insertions; i++) {
            arrayList.add(0, i); //Slow
        }
        long endTimeArray = System.nanoTime();
        System.out.println("Array List for insertionAtBeginning -> " + (endTimeArray - startTimeArray + " nanosecond"));
    }
}
