package dsa;

/**
 * Main entry point for the application.
 * This now delegates to AutomaticSolutionRunner to scan and execute solution classes based on annotations or command-line arguments.
 *
 * Command-line arguments take priority:
 * - If arguments provided: run solutions matching the names (case-insensitive, partial match)
 * - Otherwise, use annotation-based execution:
 *   - Solutions with @RunOnce annotation will be the only ones executed
 *   - Solutions with @RunSolution(runByDefault=true) will be executed by default
 *
 * Usage examples:
 * - Run all default solutions: java -cp ... dsa.Main
 * - Run specific solution: java -cp ... dsa.Main BinarySearchSolution
 * - Run solutions by partial name: java -cp ... dsa.Main Search
 * - Run multiple solutions: java -cp ... dsa.Main Binary Tree Sort
 */
public class Main {
    public static void main(String[] args) {
        // Run solutions automatically using the scanner, based on annotations or command-line args
        AutomaticSolutionRunner.runSolutions(args);
    }
}