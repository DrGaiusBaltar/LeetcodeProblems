package com.example.leetcodeProblems.algorithms.addTwoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.vavr.Function1;
import io.vavr.Function2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SolutionAddTwoNumbers {
    public List<Integer> addTwoNumbers(List<Integer> l1, List<Integer> l2) {
        return sumIntegetFromString()
                .andThen(conver())
                .apply(getStringFromArray(l1), getStringFromArray(l2));
    }

    private String getStringFromArray(List<Integer> array) {
        StringBuilder builder = new StringBuilder();
        Collections.reverse(array);
        array.forEach(builder::append);
        return builder.toString();
    }

    private Function2<String, String, String> sumIntegetFromString() {
        return (x, y) -> String.valueOf(Integer.parseInt(x) + Integer.parseInt(y));
    }

    private Function1<String, List<Integer>> conver() {
        return row -> {
            List<Integer> resultArray = new ArrayList<>();
            for (int i = 0; i < row.length(); i++) {
                resultArray.add(Integer.parseInt(String.valueOf(row.charAt(i))));
            }
            Collections.reverse(resultArray);
            return resultArray;
        };
    }
}
