package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class TwoSumTestCaseSet implements TestCaseSet<Pair<int[], Integer>, int[]> {
    @Getter
    public static final TwoSumTestCaseSet instance = new TwoSumTestCaseSet();
    private TwoSumTestCaseSet() {
    }

    @Override
    public List<Pair<Pair<int[], Integer>, int[]>> getTestCases() {
        return Arrays.asList(
            // Test case 1: [2,7,11,15], target=9 -> [0,1]
            Pair.of(
                Pair.of(new int[]{2, 7, 11, 15}, 9),
                new int[]{0, 1}
            ),
            // Test case 2: [3,2,4], target=6 -> [1,2]
            Pair.of(
                Pair.of(new int[]{3, 2, 4}, 6),
                new int[]{1, 2}
            ),
            // Test case 3: [3,3], target=6 -> [0,1]
            Pair.of(
                Pair.of(new int[]{3, 3}, 6),
                new int[]{0, 1}
            )
        );
    }
}