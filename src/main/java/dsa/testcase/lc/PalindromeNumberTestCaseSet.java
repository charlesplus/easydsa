package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class PalindromeNumberTestCaseSet implements TestCaseSet<Integer, Boolean> {
    @Getter
    public static final PalindromeNumberTestCaseSet instance = new PalindromeNumberTestCaseSet();
    private PalindromeNumberTestCaseSet() {
    }

    @Override
    public List<Pair<Integer, Boolean>> getTestCases() {
        return Arrays.asList(
            // Test case 1: 121 -> true
            Pair.of(121, true),
            // Test case 2: -121 -> false
            Pair.of(-121, false),
            // Test case 3: 10 -> false
            Pair.of(10, false),
            // Test case 4: 0 -> true
            Pair.of(0, true),
            // Test case 5: 1221 -> true
            Pair.of(1221, true)
        );
    }
}