import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_ {
    
    static int[][] board;
    static ArrayList<int[]> walls;
    static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1, 0};
    static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1, 0}; // 추가된 0은 제자리 이동
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        board = new int[8][8];
        walls = new ArrayList<>();
        
        for (int i = 0; i < 8; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (tmp.charAt(j) == '.') {
                    board[i][j] = 1; // 빈칸
                } else {
                    walls.add(new int[] {i, j});
                }
            }
        }
        
        int start_x = 7;
        int start_y = 0;
        
        answer = bfs(start_x, start_y);
        System.out.println(answer ? 1 : 0);
    }
    
    private static boolean bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y, 0});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean[][] visited = new boolean[8][8];
            
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int cur_x = cur[0];
                int cur_y = cur[1];
                int time = cur[2];
                
                if (cur_x == 0 && cur_y == 7) {
                    return true;
                }
                
                for (int d = 0; d < 9; d++) {
                    int nx = cur_x + dx[d];
                    int ny = cur_y + dy[d];
                    
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visited[nx][ny]) {
                        if (board[nx][ny] == 1) {
                            visited[nx][ny] = true;
                            queue.add(new int[] {nx, ny, time + 1});
                        }
                    }
                }
            }
            
            // 벽 이동
            ArrayList<int[]> newWalls = new ArrayList<>();
            for (int[] wall : walls) {
                int wall_x = wall[0];
                int wall_y = wall[1];
                board[wall_x][wall_y] = 1;
                
                if (wall_x + 1 < 8) {
                    newWalls.add(new int[] {wall_x + 1, wall_y});
                }
            }
            
            for (int[] wall : newWalls) {
                board[wall[0]][wall[1]] = 0;
            }
            walls = newWalls;
        }
        
        return false;
    }
}
