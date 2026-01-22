package dsa.testcase.lc;

import dsa.testcase.TestCaseSet;
import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStockTestCaseSet implements TestCaseSet<int[], Integer> {
    @Getter
    public static final BestTimeToBuyAndSellStockTestCaseSet instance = new BestTimeToBuyAndSellStockTestCaseSet();
    private BestTimeToBuyAndSellStockTestCaseSet() {
    }

    @Override
    public List<Pair<int[], Integer>> getTestCases() {
        return Arrays.asList(
            // Test case 1: [7,1,5,3,6,4] -> 5 (buy at 1, sell at 6)
            Pair.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
            // Test case 2: [7,6,4,3,1] -> 0 (no profit possible)
            Pair.of(new int[]{7, 6, 4, 3, 1}, 0),
            // Test case 3: [1,2,3,4,5] -> 4 (buy at 1, sell at 5)
            Pair.of(new int[]{1, 2, 3, 4, 5}, 4)
        );
    }
}