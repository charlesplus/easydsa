package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class UniquePathsTestCaseSet implements TestCaseSet<int[], Integer> {
    @Getter
    public static final UniquePathsTestCaseSet instance = new UniquePathsTestCaseSet();
    private UniquePathsTestCaseSet() {
    }

    @Override
    public List<Pair<int[], Integer>> getTestCases() {
        return Arrays.asList(
            // Test case 1: m=3, n=7 -> 28
            Pair.of(new int[]{3, 7}, 28),
            // Test case 2: m=3, n=2 -> 3
            Pair.of(new int[]{3, 2}, 3),
            // Test case 3: m=7, n=3 -> 28
            Pair.of(new int[]{7, 3}, 28),
            // Test case 4: m=3, n=3 -> 6
            Pair.of(new int[]{3, 3}, 6)
        );
    }
}