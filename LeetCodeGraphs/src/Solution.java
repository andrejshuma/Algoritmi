import java.util.*;
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(rooms.get(0), 0, rooms, visited);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<Integer> keys, int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;

        for (Integer i : keys) {
            if (!visited[i]) {
                dfs(rooms.get(i), i, rooms, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int city) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(city);
        visited[city] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                if (isConnected[curr][neighbor] == 1 && !visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        int steps = 0;
        int x, y;

        while (!queue.isEmpty()) {
            steps++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+') continue;

                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1) return steps;

                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }

        }
        return -1;
    }
    public int orangesRotting(int[][] grid) {
        int minutes = 0;

        int m= grid.length;
        int n= grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
                if(grid[i][j] == 2){
                    q.add(new int [] {i,j});
                }
            }
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            boolean flag = false;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        q.add(new int[] { newRow, newCol });
                        flag = true;
                    }
                }
            }
            if (flag) {
                minutes++;
            }
        }

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(grid[i][j]==1)return -1;
            }
        }
        return minutes;
    }



}