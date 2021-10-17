// MEDIUM - https://leetcode.com/problems/course-schedule/solution/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean CourseSchedule(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> store = new HashMap<>();
        int[] indegree = new int[numCourses]; // number of incoming edges for each element
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        // first build graph
        for (int[] courses : prerequisites) {
            int to = courses[0];
            int from = courses[1];

            var list = store.getOrDefault(from, new ArrayList<>());
            list.add(to);
            store.put(from, list);
            indegree[to]++;
        }

        // implement Kahn's algorithm
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            if (store.containsKey(curr)) {
                for (int nei : store.get(curr)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        queue.add(nei);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
