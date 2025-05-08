package dsa.testcase;

import dsa.checker.Checker;
import dsa.checker.GeneralChecker;
import dsa.solution.Solution;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public interface TestCaseSet<INPUT, RESULT> {

    List<Pair<INPUT, RESULT>> getTestCases();

    default Checker getChecker() {
        return GeneralChecker.getInstance();
    }

    default INPUT getTestCase(int caseIndex) {
        return getTestCases().get(caseIndex).getLeft();
    }

    default RESULT getExpectedResult(int caseIndex) {
        return getTestCases().get(caseIndex).getRight();
    }

    default boolean check(int caseIndex, RESULT result) {
        return getChecker().check(getExpectedResult(caseIndex), result);
    }

    default Pair<Integer, Integer> check(Solution<INPUT, RESULT> solution) {
        int passed = 0;
        for (int i = 0; i < getTestCases().size(); i++) {
            INPUT testCase = getTestCase(i);
            RESULT expectedResult = getExpectedResult(i);
            RESULT result = solution.solve(testCase);
            if (check(i, result)) {
                passed++;
            } else {
                System.out.printf("%s-%d failed: input=%s, expected=%s, actual=%s%n",
                        this.getClass().getSimpleName(), i, testCase, expectedResult, result);
            }
        }
        return Pair.of(passed, getTestCases().size());
    }

}
