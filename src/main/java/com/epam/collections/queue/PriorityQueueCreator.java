package com.epam.collections.queue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        PriorityQueue<String> reverseAlphabetWords = new PriorityQueue<>(Comparator.reverseOrder());
        reverseAlphabetWords.addAll(firstList);
        reverseAlphabetWords.addAll(secondList);
        return reverseAlphabetWords;
    }

    public static void main(String[] args) {
        PriorityQueueCreator main = new PriorityQueueCreator();
        PriorityQueue<String> result = main.createPriorityQueue(List.of("Java", "PriorityQueue", "class"), List.of("It", "is", "different", "from", "standard", "queues", "where", "FIFO"));
        result.forEach(System.out::println);
    }
}
