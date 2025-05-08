package dsa.checker;

public class GeneralChecker implements Checker {
    // singleton
    private static GeneralChecker instance = new GeneralChecker();
    private GeneralChecker() {
    }
    public static GeneralChecker getInstance() {
        return instance;
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
