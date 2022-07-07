class Coordinate{
    int x, y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int[] deltaX = {1,0,0,-1};
    int[] deltaY = {0,1,-1,0};
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        if(grid == null || grid.length == 0){
            return 0;
        }
        if(grid[0] == null || grid[0].length == 0 ){
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfs(grid, i, j, visited);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    private void bfs(char[][] grid, int x, int y, boolean[][] visited){
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Coordinate cur = queue.poll();
            for(int direction= 0; direction < 4; direction ++){
                int newX = cur.x + deltaX[direction];
                int newY = cur.y + deltaY[direction];
                if(!isValid(grid, newX, newY, visited)){
                    continue;
                }
                queue.offer(new Coordinate(newX, newY));
                visited[newX][newY] = true;
            }
        }
    }
    private boolean isValid(char[][] grid, int x, int y, boolean[][] visited){
        int n = grid.length, m = grid[0].length;
        if(x < 0 || x >= n || y < 0 || y >= m){
            return false;
        }
        if(visited[x][y]){
            return false;
        }
        return grid[x][y] == '1';
    }
    
}