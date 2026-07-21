// Keys and Rooms

// Approach : DFS/BFS



import java.util.List;
class Solution {  // O(V + E) time complexity, O(V) space complexity

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean[] visited = new boolean[n];

        dfs(0, rooms, visited);

        for (boolean room : visited) {

            if (!room)
                return false;
        }

        return true;
    }

    private void dfs(int room,
                     List<List<Integer>> rooms,
                     boolean[] visited) {

        visited[room] = true;

        for (int key : rooms.get(room)) {

            if (!visited[key]) {

                dfs(key, rooms, visited);
            }
        }
    }
}