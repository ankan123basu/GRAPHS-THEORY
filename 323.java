// Number of connected components in an undirected graph
// Approach : Connected components + BFS/DFS + graph construction


import java.util.ArrayList;
import java.util.List;
class Solution {  // O(V + E) time complexity, O(V + E) space complexity

    public int countComponents(int n, int[][] edges) {

        // Build adj list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int components = 0;

        for (int node = 0; node < n; node++) {

            if (!visited[node]) {

                components++;

                dfs(node, graph, visited);
            }
        }

        return components;
    }

    private void dfs(int node,
                     List<List<Integer>> graph,
                     boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {

                dfs(neighbor, graph, visited);
            }
        }
    }
}