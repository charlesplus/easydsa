package dsa.checker;

public interface Checker<RESULT> {
    boolean check(RESULT expectedResult, RESULT actualResult);
}
