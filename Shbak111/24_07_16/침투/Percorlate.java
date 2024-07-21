import java.util.*;
import java.io.FileInputStream;

public class Main {
    public boolean solution(int[][] arr) {
        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[arr.length][arr[0].length];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for(int i = 0; i < arr[0].length; i++) {
            if(arr[0][i] == 0 && visited[0][i] == 0) {
                queue.offer(new Point(0, i));
                visited[0][i] = 1;

                while(!queue.isEmpty()) {
                    Point curr = queue.poll();

                    if(curr.x == arr.length - 1) {
                        return true;
                    }

                    for(int j = 0; j < dx.length; j++) {
                        int nx = curr.x + dx[j];
                        int ny = curr.y + dy[j];

                        if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                            if(arr[nx][ny] == 0 && visited[nx][ny] == 0) {
                                queue.offer(new Point(nx, ny));
                                visited[nx][ny] = 1;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/percolate.txt"));  // 필요시 사용
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] arr = new int[N][M];

        for(int j = 0; j < N; j++) {
            String line = sc.nextLine();
            for(int k = 0; k < M; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        Main p = new Main();
        boolean result = p.solution(arr);

        if(result) System.out.println("YES");
        else System.out.println("NO");

        sc.close();
    }
}