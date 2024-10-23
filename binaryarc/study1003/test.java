package study1003;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {
    static int r1, c1, r2, c2; // 장군(r1, c1), 왕(r2, c2)
    static boolean[][] visited; // 방문 여부 체크 배열
    static int[][] move = {
        {-3, -2}, {-3, 2}, {3, -2}, {3, 2},
        {-2, -3}, {-2, 3}, {2, -3}, {2, 3}
    }; // 장군의 이동 가능한 방향 정의
    static int[][] mid1 = {
        {-1, -1}, {-1, 1}, {1, -1}, {1, 1},
        {-2, 0}, {-2, 0}, {2, 0}, {2, 0}
    }; // 첫번째 중간 좌표
    static int[][] mid2 = {
        {-2, 0}, {-2, 0}, {2, 0}, {2, 0},
        {0, -2}, {0, 2}, {0, -2}, {0, 2}
    }; // 두번째 중간 좌표

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r1 = sc.nextInt(); // 장군의 시작 위치 (r1, c1)
        c1 = sc.nextInt();
        r2 = sc.nextInt(); // 왕의 위치 (r2, c2)
        c2 = sc.nextInt();
        
        visited = new boolean[10][9]; // 체스판의 크기 (10x9)
        
        int result = bfs(); // BFS 탐색을 통해 최단 경로 탐색
        System.out.println(result); // 결과 출력
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r1, c1, 0}); // 장군의 위치와 초기 이동 횟수 (0)
        visited[r1][c1] = true; // 시작 위치 방문 처리
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cur_r = cur[0];
            int cur_c = cur[1];
            int cnt = cur[2];
            
            if (cur_r == r2 && cur_c == c2) {
                return cnt; // 왕을 잡으면 이동 횟수를 반환
            }
            
            // 장군의 8방향 이동 탐색
            for (int i = 0; i < 8; i++) {
                int nr = cur_r + move[i][0];
                int nc = cur_c + move[i][1];
                int mr1 = cur_r + mid1[i][0];
                int mc1 = cur_c + mid1[i][1];
                int mr2 = cur_r + mid2[i][0];
                int mc2 = cur_c + mid2[i][1];
                
                // 체스판을 벗어나는지 확인
                if (nr < 0 || nr >= 10 || nc < 0 || nc >= 9) continue;
                
                // 중간에 왕이 있거나, 중간에 장애물이 있는지 확인
                if (visited[nr][nc] || (mr1 == r2 && mc1 == c2) || (mr2 == r2 && mc2 == c2)) continue;
                
                // 이동 가능한 위치로 이동
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, cnt + 1});
            }
        }
        
        return -1; // 왕을 잡을 수 없는 경우
    }
}
