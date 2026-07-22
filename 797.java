// All paths from source to target
// Approach : DFS + Backtracking + DAG


import java.util.ArrayList;
import java.util.List;
class Solution {  // O(P * L) time complexity, O(P * L) space complexity

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(0, graph, path, answer);

        return answer;
    }

    private void dfs(int node,
                     int[][] graph,
                     List<Integer> path,
                     List<List<Integer>> answer) {

        // Step 1: Add current node to path
        path.add(node);

        // Step 2: Destination reached
        if (node == graph.length - 1) {

            answer.add(new ArrayList<>(path));

        } else {

            // Step 3: Explore all neighbors
            for (int neighbor : graph[node]) {

                dfs(neighbor, graph, path, answer);
            }
        }

        // Step 4: Backtrack
        path.remove(path.size() - 1);
    }
}