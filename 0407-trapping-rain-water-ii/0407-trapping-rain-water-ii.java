import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Add boundary cells
        for (int i = 0; i < m; ++i) {
            for (int j : new int[]{0, n - 1}) {
                minHeap.offer(new int[]{heightMap[i][j], i, j});
                visited[i][j] = true;
            }
        }
        for (int j = 0; j < n; ++j) {
            for (int i : new int[]{0, m - 1}) {
                if (!visited[i][j]) {
                    minHeap.offer(new int[]{heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int waterTrapped = 0;

        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int height = cell[0], x = cell[1], y = cell[2];

            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    waterTrapped += Math.max(0, height - heightMap[nx][ny]);
                    minHeap.offer(new int[]{Math.max(height, heightMap[nx][ny]), nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return waterTrapped;
    }
}