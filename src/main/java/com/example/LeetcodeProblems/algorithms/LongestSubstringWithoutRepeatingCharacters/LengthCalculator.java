package com.example.leetcodeProblems.algorithms.LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.List;

import io.vavr.Function1;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LengthCalculator {

    public String getLength(String row) {
        return findLongSequense()
                .andThen(buildRowData())
                .andThen(getMessage())
                .apply(row);
    }

    private Function1<String, List<Character>> findLongSequense() {
        return row -> {
            char[] charArray = row.toCharArray();
            int count = 0;
            List<Character> charResultSequense = new ArrayList<>();
            while (charArray.length > count) {
                Tuple2<List<Character>, Integer> resultData = getSequense(charArray, count);
                count = resultData._2;
                if (charResultSequense.size() < resultData._1.size()) {
                    charResultSequense.clear();
                    charResultSequense.addAll(resultData._1);
                }
            }
            return charResultSequense;
        };
    }

    private Tuple2<List<Character>, Integer> getSequense(char[] array, int startPosition) {
        List<Character> sequense = new ArrayList<>();
        int endPosition = 0;
        for (int i = startPosition; i < array.length; i++) {
            char c = array[i];
            sequense.add(c);
            if ((i + 2) > array.length ||(++c) != array[i + 1]) {
                endPosition = i + 1;
                break;
            }
        }
        return Tuple.of(sequense, endPosition);
    }

    private Function1<List<Character>, Tuple2<String, Integer>> buildRowData() {
        return charArray -> {
            StringBuilder rowFromCharsequense = new StringBuilder();
            charArray.forEach(rowFromCharsequense::append);
            return Tuple.of(rowFromCharsequense.toString(), rowFromCharsequense.toString().length());
        };
    }
    private Function1<Tuple2<String, Integer>, String> getMessage() {
        return rowData ->
             String.format("The answer is \"%s\", with the length of %s.", rowData._1, rowData._2);
    }
}
