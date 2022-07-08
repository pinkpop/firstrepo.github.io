class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    int[] deltaX = {0, 1, -1, 0};
    int[] deltaY = {1, 0, 0, -1};
     public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int max = 0;
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1 && !visited[i][j]) {
                    int area = bfs(grid, i, j, visited);
                    max = Math.max(max, area);
                }
            }
        }
        
        return max;
    }
    
    private int bfs(int[][] grid, int x, int y, boolean[][] visited) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        int area = 1;
        
        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int direction = 0; direction < 4; direction++) {
                int newX = coor.x + deltaX[direction];
                int newY = coor.y + deltaY[direction];
                if (!isVaild(grid, newX, newY, visited)) {
                    continue;
                }
                queue.offer(new Coordinate(newX, newY));
                visited[newX][newY] = true;
                area += 1;
            }
        }
        return area;
    }
    
    private boolean isVaild(int[][] grid, int x, int y, boolean[][] visited) {
        int n = grid.length, m = grid[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        return grid[x][y]==1;
    }
}