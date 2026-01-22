package dsa.testcase.leetcode;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class RotateImageTestCaseSet implements TestCaseSet<int[][], Void> {
    @Getter
    public static final RotateImageTestCaseSet instance = new RotateImageTestCaseSet();
    private RotateImageTestCaseSet() {
    }

    @Override
    public List<Pair<int[][], Void>> getTestCases() {
        return Arrays.asList(
            // Test case 1: [[1,2,3],[4,5,6],[7,8,9]] -> [[7,4,1],[8,5,2],[9,6,3]]
            Pair.of(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, null),
            // Test case 2: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]] -> [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
            Pair.of(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}}, null),
            // Test case 3: [[1]] -> [[1]]
            Pair.of(new int[][]{{1}}, null)
        );
    }
}