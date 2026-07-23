// 01 Matrix

// Approach : Multi-source BFS

import java.util.*;
class Solution { // O(rows * cols) tc and O(rows * cols) sc

    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] distance = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        // Mark all cells as unvisited
        for(int i = 0; i < rows; i++) {
            Arrays.fill(distance[i], -1);
        }

        // Add all 0's to the queue ** MULTI-SOURCE BFS **
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];

            for(int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nc < 0 ||
                   nr >= rows || nc >= cols)
                    continue;

                if(distance[nr][nc] == -1) {

                    distance[nr][nc] = distance[r][c] + 1;

                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return distance;
    }
}