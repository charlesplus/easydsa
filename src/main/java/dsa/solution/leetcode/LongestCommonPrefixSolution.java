package dsa.solution.leetcode;

import dsa.solution.Solution;
import dsa.testcase.TestCaseSet;
import dsa.testcase.leetcode.LongestCommonPrefixTestCaseSet;
import lombok.Getter;

/**
 * Longest Common Prefix Solution
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * - 1 <= strs.length <= 200
 * - 0 <= strs[i].length <= 200
 * - strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefixSolution implements Solution<String[], String> {
    @Getter
    private static final LongestCommonPrefixSolution instance = new LongestCommonPrefixSolution();
    private LongestCommonPrefixSolution() {
    }

    @Override
    public String solve(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    @Override
    public TestCaseSet<String[], String> getTestCaseSet() {
        return LongestCommonPrefixTestCaseSet.getInstance();
    }
}