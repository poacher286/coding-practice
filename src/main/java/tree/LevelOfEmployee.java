package tree;

import java.util.*;

public class LevelOfEmployee {
    public static List<Employee> getAllReportersInLevel(Employee e) {
        if (e == null) return Collections.emptyList();

        // Step 1: Find the root (CEO)
        Employee root = e;
        while (root.getManager() != null) {
            root = root.getManager();
        }

        // Step 2: Find depth of e
        int targetLevel = 0;
        Employee temp = e;
        while (temp.getManager() != null) {
            targetLevel++;
            temp = temp.getManager();
        }

        // Step 3: BFS to collect all employees at targetLevel
        List<Employee> result = new ArrayList<>();
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(root);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (currentLevel == targetLevel) {
                for (int i = 0; i < size; i++) {
                    result.add(queue.poll());
                }
                break; // no need to go deeper
            }

            for (int i = 0; i < size; i++) {
                Employee emp = queue.poll();
                for (Employee reporter : emp.getReporters()) {
                    queue.offer(reporter);
                }
            }

            currentLevel++;
        }

        return result;
    }
}

class Employee{
    private List<Employee> reporters;
    private Employee manager;

    public List<Employee> getReporters() {
        return reporters;
    }

    public Employee getManager() {
        return manager;
    }
}
