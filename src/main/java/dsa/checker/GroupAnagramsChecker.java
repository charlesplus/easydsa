package dsa.checker;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagramsChecker implements Checker {
    @Getter
    private final static GroupAnagramsChecker instance = new GroupAnagramsChecker();
    private GroupAnagramsChecker() {
    }

    @Override
    public boolean check(Object expectedResult, Object actualResult) {
        if (expectedResult == null && actualResult == null) {
            return true;
        }
        if (expectedResult == null || actualResult == null) {
            return false;
        }

        // Both should be List<List<String>>
        if (!(expectedResult instanceof List) || !(actualResult instanceof List)) {
            return false;
        }

        List<List<String>> expectedList = (List<List<String>>) expectedResult;
        List<List<String>> actualList = (List<List<String>>) actualResult;

        // Normalize both lists by sorting inner lists and then sorting outer list by first element
        List<List<String>> normalizedExpected = normalizeGroups(expectedList);
        List<List<String>> normalizedActual = normalizeGroups(actualList);

        // Convert to sets of sets to make comparison order-independent for both inner and outer lists
        Set<Set<String>> expectedSet = normalizedExpected.stream()
            .map(ArrayList::new) // Create a new ArrayList to avoid unmodifiable list issues
            .map(innerList -> new HashSet<>(innerList))
            .collect(Collectors.toSet());

        Set<Set<String>> actualSet = normalizedActual.stream()
            .map(ArrayList::new) // Create a new ArrayList to avoid unmodifiable list issues
            .map(innerList -> new HashSet<>(innerList))
            .collect(Collectors.toSet());

        return expectedSet.equals(actualSet);
    }

    private List<List<String>> normalizeGroups(List<List<String>> groups) {
        return groups.stream()
            .map(list -> list.stream().sorted().collect(Collectors.toList()))
            .collect(Collectors.toList());
    }
}