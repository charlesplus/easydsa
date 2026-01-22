package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefixTestCaseSet implements TestCaseSet<String[], String> {
    @Getter
    public static final LongestCommonPrefixTestCaseSet instance = new LongestCommonPrefixTestCaseSet();
    private LongestCommonPrefixTestCaseSet() {
    }

    @Override
    public List<Pair<String[], String>> getTestCases() {
        return Arrays.asList(
            // Test case 1: ["flower","flow","flight"] -> "fl"
            Pair.of(new String[]{"flower", "flow", "flight"}, "fl"),
            // Test case 2: ["dog","racecar","car"] -> ""
            Pair.of(new String[]{"dog", "racecar", "car"}, ""),
            // Test case 3: ["interspecies","interstellar","interstate"] -> "inters"
            Pair.of(new String[]{"interspecies", "interstellar", "interstate"}, "inters"),
            // Test case 4: [""] -> ""
            Pair.of(new String[]{""}, ""),
            // Test case 5: ["a"] -> "a"
            Pair.of(new String[]{"a"}, "a")
        );
    }
}