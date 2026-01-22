package dsa.testcase.leetcode;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class ValidParenthesesTestCaseSet implements TestCaseSet<String, Boolean> {
    @Getter
    public static final ValidParenthesesTestCaseSet instance = new ValidParenthesesTestCaseSet();
    private ValidParenthesesTestCaseSet() {
    }

    @Override
    public List<Pair<String, Boolean>> getTestCases() {
        return Arrays.asList(
            // Test case 1: "()"
            Pair.of("()", true),
            // Test case 2: "()[]{}"
            Pair.of("()[]{}", true),
            // Test case 3: "(]"
            Pair.of("(]", false),
            // Test case 4: "([)]"
            Pair.of("([)]", false),
            // Test case 5: "{[]}"
            Pair.of("{[]}", true)
        );
    }
}