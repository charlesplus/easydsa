package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class WordSearchTestCaseSet implements TestCaseSet<Object[], Boolean> {
    @Getter
    public static final WordSearchTestCaseSet instance = new WordSearchTestCaseSet();
    private WordSearchTestCaseSet() {
    }

    @Override
    public List<Pair<Object[], Boolean>> getTestCases() {
        // Test case 1: board=[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word="ABCCED" -> true
        char[][] board1 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        
        // Test case 2: board=[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word="SEE" -> true
        char[][] board2 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        
        // Test case 3: board=[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word="ABCB" -> false
        char[][] board3 = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        
        return Arrays.asList(
            Pair.of(new Object[]{board1, "ABCCED"}, true),
            Pair.of(new Object[]{board2, "SEE"}, true),
            Pair.of(new Object[]{board3, "ABCB"}, false)
        );
    }
}