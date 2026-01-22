package dsa.testcase.leetcode;

import dsa.checker.GroupAnagramsChecker;
import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class GroupAnagramsTestCaseSet implements TestCaseSet<String[], List<List<String>>> {
    @Getter
    public static final GroupAnagramsTestCaseSet instance = new GroupAnagramsTestCaseSet();
    private GroupAnagramsTestCaseSet() {
    }

    @Override
    public List<Pair<String[], List<List<String>>>> getTestCases() {
        // Test case 1: ["eat","tea","tan","ate","nat","bat"]
        List<List<String>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList("eat", "tea", "ate"));
        expected1.add(Arrays.asList("tan", "nat"));
        expected1.add(Arrays.asList("bat"));

        // Test case 2: [""]
        List<List<String>> expected2 = new ArrayList<>();
        expected2.add(Arrays.asList(""));

        // Test case 3: ["a"]
        List<List<String>> expected3 = new ArrayList<>();
        expected3.add(Arrays.asList("a"));

        return Arrays.asList(
            Pair.of(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, expected1),
            Pair.of(new String[]{""}, expected2),
            Pair.of(new String[]{"a"}, expected3)
        );
    }

    @Override
    public GroupAnagramsChecker getChecker() {
        return GroupAnagramsChecker.getInstance();
    }
}