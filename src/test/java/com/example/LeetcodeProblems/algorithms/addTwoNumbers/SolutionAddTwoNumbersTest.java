package com.example.leetcodeProblems.algorithms.addTwoNumbers;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.vavr.Function1;
import io.vavr.Tuple;
import io.vavr.Tuple2;

@RunWith(SpringRunner.class)
@SpringBootTest
class SolutionAddTwoNumbersTest {


    @Autowired
    private SolutionAddTwoNumbers solution;

    private Tuple2<List<Integer>, List<Integer>> setupLists(String sequense1, String sequense2) {
        Function1<String, List<Integer>> getList = row -> {
            List<Integer> array = new ArrayList<>();
            for (int i = 0; i < row.length(); i++) {
                array.add(Integer.parseInt(String.valueOf(row.charAt(i))));
            }
            return array;
        };

        return Tuple.of(getList.apply(sequense1), getList.apply(sequense2));
    }



    @Test
    void addTwoNumbersTest() {
        Tuple2<List<Integer>, List<Integer>> case1 = setupLists("243", "564");
        Tuple2<List<Integer>, List<Integer>> case2 = setupLists("0", "0");
        Tuple2<List<Integer>, List<Integer>> case3 = setupLists("9999999", "9999");
        List<Integer> expectedsList1 = List.of(7, 0, 8);
        List<Integer> expectedsList2 = List.of(0);
        List<Integer> expectedsList3 = List.of(8,9,9,9,0,0,0,1);

        List<Integer> resultCase1 = solution.addTwoNumbers(case1._1, case1._2);
        List<Integer> resultCase2 = solution.addTwoNumbers(case2._1, case2._2);
        List<Integer> resultCase3 = solution.addTwoNumbers(case3._1, case3._2);


        Assertions.assertEquals(expectedsList1, resultCase1);
        Assertions.assertEquals(expectedsList2, resultCase2);
        Assertions.assertEquals(expectedsList3, resultCase3);

    }

}