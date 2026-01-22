package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class SpiralMatrixTestCaseSet implements TestCaseSet<int[][], List<Integer>> {
    @Getter
    public static final SpiralMatrixTestCaseSet instance = new SpiralMatrixTestCaseSet();
    private SpiralMatrixTestCaseSet() {
    }

    @Override
    public List<Pair<int[][], List<Integer>>> getTestCases() {
        return Arrays.asList(
            // Test case 1: [[1,2,3],[4,5,6],[7,8,9]] -> [1,2,3,6,9,8,7,4,5]
            Pair.of(
                new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)
            ),
            // Test case 2: [[1,2,3,4],[5,6,7,8],[9,10,11,12]] -> [1,2,3,4,8,12,11,10,9,5,6,7]
            Pair.of(
                new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
                Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
            ),
            // Test case 3: [[1]] -> [1]
            Pair.of(
                new int[][]{{1}},
                Arrays.asList(1)
            )
        );
    }
}