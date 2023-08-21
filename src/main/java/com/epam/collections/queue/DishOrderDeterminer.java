package com.epam.collections.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> dishes = IntStream.rangeClosed(1, numberOfDishes).boxed().collect(Collectors.toList());
        List<Integer> order = new LinkedList<>();
        int possibleDishIndex = 0;
        int countToThree = 1;
        while (!dishes.isEmpty()) {
            possibleDishIndex++;
            if (countToThree < everyDishNumberToEat - 1) {
                countToThree++;
                continue;
            }
            if (order.contains(dishes.get(possibleDishIndex % dishes.size())))  {
                continue;
            }
            countToThree = 1;
            possibleDishIndex %= dishes.size();
            order.add(dishes.get(possibleDishIndex % dishes.size()));
            dishes.remove(possibleDishIndex % dishes.size());
        }
        return order;
    }
}
