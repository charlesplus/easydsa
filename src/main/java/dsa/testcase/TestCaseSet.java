package dsa.testcase;

import dsa.checker.Checker;
import dsa.checker.GeneralChecker;
import dsa.solution.Solution;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public interface TestCaseSet<T, R> {

    List<Pair<T, R>> getTestCases();

    default Checker getChecker() {
        GeneralChecker.getInstance();
    }

    default T getTestCase(int caseIndex) {
        return getTestCases().get(caseIndex).getLeft();
    }

    default R getExpectedResult(int caseIndex) {
        return getTestCases().get(caseIndex).getRight();
    }

    default boolean check(int caseIndex, R result) {
        return getChecker().check(getExpectedResult(caseIndex), result);
    }

    default Pair<Integer, Integer> check(Solution<T, R> solution) {
        int passed = 0;
        for (int i = 0; i < getTestCases().size(); i++) {
            T testCase = getTestCase(i);
            R expectedResult = getExpectedResult(i);
            R result = solution.solve(testCase);
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
