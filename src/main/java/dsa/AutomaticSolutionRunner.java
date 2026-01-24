package dsa;

import dsa.annotation.RunOnce;
import dsa.annotation.RunSolution;
import dsa.solution.Solution;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Automatic Solution Runner that scans the classpath for all Solution
 * implementations
 * and executes them based on annotations or command-line arguments.
 *
 * Command-line arguments take priority:
 * - If arguments provided: run solutions matching the names (case-insensitive,
 * partial match)
 * - Otherwise, use annotation-based execution:
 * - Solutions with @RunOnce annotation will be the only ones executed
 * - Solutions with @RunSolution(runByDefault=true) will be executed by default
 */
public class AutomaticSolutionRunner {

    /**
     * Runs solution classes based on command-line arguments or annotations
     * 
     * @param args Optional solution class names to run (case-insensitive, partial
     *             match)
     */
    public static void runSolutions(String... args) {
        // Create a Reflections instance to scan the dsa.solution package
        Reflections reflections = new Reflections("dsa.solution");

        // Get all subtypes of Solution interface
        Set<Class<? extends Solution>> solutionClasses = reflections.getSubTypesOf(Solution.class);

        // If command-line arguments are provided, run solutions matching the names
        if (args != null && args.length > 0) {
            Set<Class<? extends Solution>> classesToExecute = new HashSet<>();

            for (Class<? extends Solution> solutionClass : solutionClasses) {
                // Skip the Solution interface itself
                if (solutionClass.isInterface()) {
                    continue;
                }

                String className = solutionClass.getSimpleName();
                for (String arg : args) {
                    // Use case-insensitive partial matching
                    if (className.toLowerCase().contains(arg.toLowerCase())) {
                        classesToExecute.add(solutionClass);
                        break;
                    }
                }
            }

            System.out.println("Found " + solutionClasses.size() + " total solution classes.");
            System.out.println(
                    "Executing " + classesToExecute.size() + " solution classes based on command-line arguments: " +
                            String.join(", ", args) + ". Starting execution...\n");

            executeSolutions(classesToExecute, classesToExecute.size());
            return;
        }

        // If no command-line arguments, use annotation-based execution
        // Find classes with @RunOnce annotation
        Set<Class<? extends Solution>> runOnceClasses = new HashSet<>();
        Set<Class<? extends Solution>> runByDefaultClasses = new HashSet<>();

        for (Class<? extends Solution> solutionClass : solutionClasses) {
            // Skip the Solution interface itself
            if (solutionClass.isInterface()) {
                continue;
            }

            // Check for RunOnce annotation
            if (solutionClass.isAnnotationPresent(RunOnce.class)) {
                runOnceClasses.add(solutionClass);
            }
            // Check for RunSolution annotation
            else if (solutionClass.isAnnotationPresent(RunSolution.class)) {
                RunSolution annotation = solutionClass.getAnnotation(RunSolution.class);
                if (annotation.runByDefault()) {
                    runByDefaultClasses.add(solutionClass);
                }
            }
        }

        Set<Class<? extends Solution>> classesToExecute;
        String executionType;

        if (!runOnceClasses.isEmpty()) {
            // If any classes have @RunOnce, only execute those
            classesToExecute = runOnceClasses;
            executionType = "@RunOnce";
        } else {
            // Otherwise execute classes with @RunSolution(runByDefault=true)
            classesToExecute = runByDefaultClasses;
            executionType = "@RunSolution (runByDefault=true)";
        }

        System.out.println("Found " + solutionClasses.size() + " total solution classes.");
        System.out.println("Executing " + classesToExecute.size() + " solution classes marked with " +
                executionType + ". Starting execution...\n");

        executeSolutions(classesToExecute, classesToExecute.size());
    }

    /**
     * Helper method to execute a set of solution classes
     */
    private static void executeSolutions(Set<Class<? extends Solution>> classesToExecute, int totalCount) {
        int successCount = 0;

        for (Class<? extends Solution> solutionClass : classesToExecute) {
            try {
                // Instantiate the solution class using the no-arg constructor
                java.lang.reflect.Constructor<? extends Solution> constructor = solutionClass.getDeclaredConstructor();
                constructor.setAccessible(true);
                Solution solutionInstance = constructor.newInstance();

                // Run the test
                System.out.println("Executing: " + solutionClass.getSimpleName());
                solutionInstance.runTest();
                System.out.println("Completed: " + solutionClass.getSimpleName() + "\n");

                successCount++;

            } catch (NoSuchMethodException e) {
                System.out.println("Skipping " + solutionClass.getSimpleName() + " - no no-arg constructor found");
            } catch (Exception e) {
                System.err.println("Failed to execute " + solutionClass.getSimpleName() + ": " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println(
                "\nExecution Summary: " + successCount + "/" + totalCount + " solutions executed successfully.");
    }

    public static void main(String[] args) {
        runSolutions(args);
    }
}