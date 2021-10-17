// MEDIUM - https://leetcode.com/problems/course-schedule-ii/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> store = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] indegrees = new int[numCourses];

        // build graph
        for (int[] current : prerequisites) {
            int to = current[0];
            int from = current[1];

            var list = store.getOrDefault(from, new ArrayList<>());
            list.add(to);
            store.put(from, list);
            indegrees[to]++;
        }

        // kahn's algorithm
        for (int i=0; i<numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index] = node;
            index++;
            if (store.containsKey(node)) {
                var list = store.get(node);
                for (int nei : list) {
                    indegrees[nei]--;
                    if (indegrees[nei] == 0) {
                        queue.add(nei);
                    }
                }
            }
        }

        return (index == numCourses) ? result : new int[]{};
    }

}
