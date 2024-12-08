package com.zubala.rafal.day01;

import com.zubala.rafal.utils.Utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Day01 {
    int[] parts() {
        List<String> data = Utils.readAllLines("day01/data1");
        List<Integer> leftId = new LinkedList<>();
        List<Integer> rightId = new LinkedList<>();
        data.stream()
                .map(row -> row.split(" {3}"))
                .map(dataRow -> List.of(Integer.valueOf(dataRow[0]), Integer.valueOf(dataRow[1])))
                .forEach(valuePairs -> {
                    leftId.add(valuePairs.get(0));
                    rightId.add(valuePairs.get(1));
                });
        List<Integer> sortedLeft = leftId.stream().sorted().toList();
        List<Integer> sortedRight = rightId.stream().sorted().toList();
        AtomicInteger index = new AtomicInteger();
        int res1 =  sortedLeft.stream().reduce(0, (acc, left) -> {
            acc = acc + Math.abs(left - sortedRight.get(index.get()));
            index.getAndIncrement();
            return acc;
        });

        Map<Integer, Integer> map = new HashMap<>();
        sortedLeft.forEach(left -> map.computeIfAbsent(left, k -> sortedRight.stream().filter(x -> x.equals(k)).toList().size()));
        int res2 = sortedLeft.stream().reduce(0, (acc, key) -> {
            acc += key * map.get(key);
            return acc;
        });

        return new int[]{res1, res2};
    }
}
