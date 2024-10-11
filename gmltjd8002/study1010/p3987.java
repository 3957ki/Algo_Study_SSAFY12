import java.io.*;
import java.util.*;

public class p3987 {
    static int r, c;
    static int initX, initY;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[] dirs = {'U', 'R', 'D', 'L'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine().trim();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine());
        initX = Integer.parseInt(st.nextToken()) - 1; // 좌표 1씩 땡기기(패딩하면 헷갈림)
        initY = Integer.parseInt(st.nextToken()) - 1;

        int maxCnt = 0;
        char bestDir = 'U'; //일단 U로
        for (int dir = 0; dir < 4; dir++) {
            int signalCnt = go(initX, initY, dir); // 돌려보기
            if (signalCnt == Integer.MAX_VALUE) { // 무한루프 찾으면
                System.out.println(dirs[dir]);
                System.out.println("Voyager");
                return;
            }
            if (signalCnt > maxCnt) { //갱신
                maxCnt = signalCnt;
                bestDir = dirs[dir];
            }
        }
        System.out.println(bestDir); //다돌고 최종결과 출력
        System.out.println(maxCnt);
    }

    static int go(int x, int y, int dir) {
        boolean[][][] isVisit = new boolean[r][c][4];
        int cnt = 0;
        while (true) {
            if (x < 0 || x >= r || y < 0 || y >= c || map[x][y] == 'C') return cnt; // 끝나는 기저조건
            
            if (isVisit[x][y][dir]) return Integer.MAX_VALUE; // 이미 방문한곳 -> 무한루프!
            isVisit[x][y][dir] = true; // 방문처리
            
            cnt++; //카운트 추가
            
            if (map[x][y] == '/') { //방향 직접 지정
                if (dir == 0) dir = 1;
                else if (dir == 1) dir = 0;
                else if (dir == 2) dir = 3;
                else if (dir == 3) dir = 2;
            } else if (map[x][y] == '\\') {
                if (dir == 0) dir = 3;
                else if (dir == 1) dir = 2;
                else if (dir == 2) dir = 1;
                else if (dir == 3) dir = 0;
            }
            
            x += dx[dir];
            y += dy[dir];
        }
    }
}