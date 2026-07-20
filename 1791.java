// Find Centre of a star graph
// Approach 1: Degree count  n - 1 degree


// class Solution {  // O(N) O(N)

//     public int findCenter(int[][] edges) {

//         // Number of nodes = edges + 1
//         int n = edges.length + 1;

//         int[] degree = new int[n + 1];

//         for (int[] edge : edges) {

//             int u = edge[0];
//             int v = edge[1];

//             degree[u]++;
//             degree[v]++;
//         }

//         for (int i = 1; i <= n; i++) {

//             if (degree[i] == n - 1)
//                 return i;
//         }

//         return -1;
//     }
// }



// Approach 2: Check first two edges

class Solution {  // O(1) O(1)

    public int findCenter(int[][] edges) {

        if (edges[0][0] == edges[1][0] ||
            edges[0][0] == edges[1][1]) {

            return edges[0][0];
        }

        return edges[0][1];
    }
}