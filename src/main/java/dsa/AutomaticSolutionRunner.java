package dsa;

import dsa.solution.Solution;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Automatic Solution Runner that scans the classpath for all Solution implementations
 * and executes them automatically without manual addition to main method.
 */
public class AutomaticSolutionRunner {

    /**
     * Runs all solution classes that implement the Solution interface
     */
    public static void runAllSolutions() {
        // Create a Reflections instance to scan the dsa.solution package
        Reflections reflections = new Reflections("dsa.solution");

        // Get all subtypes of Solution interface
        Set<Class<? extends Solution>> solutionClasses = reflections.getSubTypesOf(Solution.class);

        System.out.println("Found " + solutionClasses.size() + " solution classes. Starting execution...\n");

        int successCount = 0;
        int totalCount = solutionClasses.size();

        for (Class<? extends Solution> solutionClass : solutionClasses) {
            // Skip the Solution interface itself
            if (solutionClass.isInterface()) {
                continue;
            }

            try {
                // Check if the class follows singleton pattern with getInstance()
                Method getInstanceMethod = solutionClass.getMethod("getInstance");

                // Get the singleton instance
                Solution solutionInstance = (Solution) getInstanceMethod.invoke(null);

                // Run the test
                System.out.println("Executing: " + solutionClass.getSimpleName());
                solutionInstance.runTest();
                System.out.println("Completed: " + solutionClass.getSimpleName() + "\n");

                successCount++;

            } catch (NoSuchMethodException e) {
                // If getInstance method doesn't exist, skip this class
                System.out.println("Skipping " + solutionClass.getSimpleName() + " - no getInstance() method");
            } catch (Exception e) {
                System.err.println("Failed to execute " + solutionClass.getSimpleName() + ": " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println("\nExecution Summary: " + successCount + "/" + totalCount + " solutions executed successfully.");
    }

    public static void main(String[] args) {
        runAllSolutions();
    }
}