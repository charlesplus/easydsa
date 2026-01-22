package dsa.checker;

import lombok.Getter;

import java.util.Arrays;

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

        // Handle array comparisons
        if (expectedResult.getClass().isArray() && actualResult.getClass().isArray()) {
            if (expectedResult instanceof int[]) {
                return Arrays.equals((int[]) expectedResult, (int[]) actualResult);
            } else if (expectedResult instanceof String[]) {
                return Arrays.equals((String[]) expectedResult, (String[]) actualResult);
            } else if (expectedResult instanceof char[]) {
                return Arrays.equals((char[]) expectedResult, (char[]) actualResult);
            } else if (expectedResult instanceof double[]) {
                return Arrays.equals((double[]) expectedResult, (double[]) actualResult);
            } else if (expectedResult instanceof boolean[]) {
                return Arrays.equals((boolean[]) expectedResult, (boolean[]) actualResult);
            } else if (expectedResult instanceof byte[]) {
                return Arrays.equals((byte[]) expectedResult, (byte[]) actualResult);
            } else if (expectedResult instanceof short[]) {
                return Arrays.equals((short[]) expectedResult, (short[]) actualResult);
            } else if (expectedResult instanceof long[]) {
                return Arrays.equals((long[]) expectedResult, (long[]) actualResult);
            } else if (expectedResult instanceof float[]) {
                return Arrays.equals((float[]) expectedResult, (float[]) actualResult);
            } else {
                return Arrays.equals((Object[]) expectedResult, (Object[]) actualResult);
            }
        }

        if (expectedResult instanceof Comparable && actualResult instanceof Comparable) {
            return ((Comparable) expectedResult).compareTo(actualResult) == 0;
        }
        return expectedResult.equals(actualResult);
    }
}
