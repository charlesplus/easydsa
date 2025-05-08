package dsa.checker;

import lombok.Getter;

public class GeneralChecker implements Checker {
    @Getter
    private final static GeneralChecker instance = new GeneralChecker();
    private GeneralChecker() {
    }

    @Override
    public boolean check(Object expectedResult, Object actualResult) {
        if (expectedResult == null && actualResult == null) {
            return true;
        }
        if (expectedResult == null || actualResult == null) {
            return false;
        }
        if (expectedResult instanceof Comparable && actualResult instanceof Comparable) {
            return ((Comparable) expectedResult).compareTo(actualResult) == 0;
        }
        return expectedResult.equals(actualResult);
    }
}
