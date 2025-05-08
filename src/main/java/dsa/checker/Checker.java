package dsa.checker;

public interface Checker<T> {
    boolean check(T expectedResult, T actualResult);
}
