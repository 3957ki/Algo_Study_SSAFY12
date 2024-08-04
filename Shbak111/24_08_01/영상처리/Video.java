package 실전코테스터디.Algo_0801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 세로 길이가 N이고 가로 길이가 M인 화면은 총 N × M개의 픽셀로 구성
 * i,j의 픽셀은 r,g,b 의 의미를 가지고 있음.
 *  각 색상은 0이상 255이하인 값으로 표현
 * 든 픽셀에서 세 가지 색상을 평균내어 경계값 T 보다 크거나 같으면 픽셀의 값을 255로 작으면 0으로 만듦
 * 새로 만들어진 화면에서 값이 255인 픽셀은 물체로 인식한다. 값이 255인 픽셀들이 상하좌우로 인접해있다면 이 픽셀들은 같은 물체로 인식된다.
 */

public class Video {
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void BFS(int[][] arr, int x, int y, boolean[][] visited) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x,y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Point curr = queue.poll();
            for(int i = 0;i < dx.length;i++){

                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(arr[nx][ny] == 255){
                        queue.offer(new Point(nx,ny));
                        arr[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("res/video.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];


        for(int i = 0;i < arr.length;i++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            for(int j = 0;j < arr[i].length;j++){
                int sum = 0;
                for(int k = 0;k < 3;k++){
                    sum += Integer.parseInt(st2.nextToken());
                }
                arr[i][j] = sum / 3;
            }
        }
        StringTokenizer st3 = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st3.nextToken());

        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                if(arr[i][j] >= T){
                    arr[i][j] = 255;
                }else arr[i][j] = 0;
            }
        }

        Video v = new Video();
        int answer = 0;

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                if(arr[i][j] == 255){
                    arr[i][j] = 0;
                    v.BFS(arr,i,j, visited);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
