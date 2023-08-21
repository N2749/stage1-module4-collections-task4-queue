package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> board = new ArrayDeque<>();
        board.add(firstQueue.remove());
        board.add(firstQueue.remove());
        board.add(secondQueue.remove());
        board.add(secondQueue.remove());
        while (!firstQueue.isEmpty() || !secondQueue.isEmpty()) {

            firstQueue.add(board.removeLast());
            board.add(firstQueue.remove());
            board.add(firstQueue.remove());

            secondQueue.add(board.removeLast());
            board.add(secondQueue.remove());
            board.add(secondQueue.remove());
        }
        return board;
    }

    public static void main(String[] args) {
        ArrayDequeCreator main = new ArrayDequeCreator();
        ArrayDeque<Integer> result;
        result = main.createArrayDeque(new LinkedList<>(List.of(1, 5, 7, 6)), new LinkedList<>(List.of(2, 5, 8, 3)));
        System.out.print("result: ");
        List.of(result).forEach(System.out::print);
        System.out.println();
//        result = main.createArrayDeque(new LinkedList<> (List.of(1, 3, 5, 4, 7, 9)), new LinkedList<> (List.of(4, 2, 8, 5, 8, 3)));
//        System.out.print("result: ");
//        List.of(result).forEach(System.out::print);
//        1, 3, 4, 5, 8, 7, 8, 2, 4, 3, 5, 9
    }
}
