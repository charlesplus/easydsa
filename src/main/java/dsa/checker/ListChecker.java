package dsa.checker;

import lombok.Getter;

import java.util.List;

public class ListChecker implements Checker<List> {
    @Getter
    private final static ListChecker instance = new ListChecker();
    private ListChecker() {
    }

    @Override
    public boolean check(List expectedResult, List actualResult) {
        if (expectedResult == null && actualResult == null) {
            return true;
        }
        if (expectedResult == null || actualResult == null) {
            return false;
        }
        if (expectedResult.size() != actualResult.size()) {
            return false;
        }
        for (int i = 0; i < expectedResult.size(); i++) {
            if (!expectedResult.get(i).equals(actualResult.get(i))) {
                return false;
            }
        }
        return true;
    }
}
