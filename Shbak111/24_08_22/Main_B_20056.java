import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;

/**
 * 방향 di로 속력 si칸 만큼 이동
 * 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
 *
 * "이동이 모두 끝난 뒤", 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다
 *
 */

public class Main_B_20056 {
    static int N;
    static int M;
    static int K;
    static int[][][] arr;
    static int[] dx = {-1,-1,0,1,1, 1, 0,-1};
    static int[] dy = { 0, 1,1,1,0,-1,-1,-1};
    static Queue<Fireball> list;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\BaekJoon_self\\B_20056_마법사상어와파이어볼\\b_20056.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayDeque<>();
        for(int i = 0;i < M;i++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            int m = Integer.parseInt(st2.nextToken());
            int s = Integer.parseInt(st2.nextToken());
            int d = Integer.parseInt(st2.nextToken());

            if(m == 0) continue;
            list.add(new Fireball(r,c,m,s,d));
        }

        int cnt = 1;
        while(cnt <= K){
            arr = new int[N+1][N+1][6];
            // 이동 시킴.
            for(int i = 0;i < list.size();i++){
                Fireball f = list.poll();
                for(int j = 0;j < f.s;j++){

                    f.r = f.r + dx[f.d];
                    if(f.r < 1){
                        f.r = N;
                    }else if (f.r > N){
                        f.r = 1;
                    }

                    f.c = f.c + dy[f.d];
                    if(f.c < 1){
                        f.c = N;
                    } else if (f.c > N){
                        f.c = 1;
                    }
                }

                list.add(f);
            }

            // 같은 칸에 있는 파이어볼 합치기.
            int size = list.size();
            for(int i = 0;i < size;i++){
                Fireball f = list.poll();
                // 질량 더하기
                arr[f.r][f.c][0] += f.m;
                // 속력 더하기
                arr[f.r][f.c][1] += f.s;
                // 방향 더하기
                arr[f.r][f.c][2] += f.d;
                // 개수 세기
                arr[f.r][f.c][3] += 1;
                //System.out.println(arr[f.r][f.c][0]);
                // 방향이 모두 짝수 인지 홀 수 인지 체크
                if(f.d % 2 == 0) arr[f.r][f.c][4] += 1;
                else arr[f.r][f.c][5] += 1;
            }
            //System.out.println(arr[f.r][f.c][4] + " " + arr[f.r][f.c][5]);
            // 파이어볼 나누기
            for(int i = 0;i < arr.length;i++){
                for(int j = 0;j < arr.length;j++){
                    if(arr[i][j][3] > 1){
                        int m = arr[i][j][0] / 5;
                        int s = arr[i][j][1] / arr[i][j][3];
                        if(m == 0) continue;
                        if(arr[i][j][4] == 0 || arr[i][j][5] == 0){
                            int[] dir = {0,2,4,6};
                            for(int v = 0;v < 4;v++){
                                list.add(new Fireball(i,j,m,s,dir[v]));
                            }
                        } else {
                            int[] dir = {1,3,5,7};
                            for(int v = 0;v < 4;v++){
                                list.add(new Fireball(i,j,m,s,dir[v]));
                            }
                        }

                    } else {
                        if(arr[i][j][0] == 0) continue;
                        list.add(new Fireball(i,j,arr[i][j][0],arr[i][j][1],arr[i][j][2]));
                    }
                }
            }

           // System.out.println(Arrays.toString(list.toArray()));
            cnt++;
        }

        int result = 0;
        int size = list.size();
        for(int i = 0;i < size;i++){
            result += list.poll().m;
        }

        System.out.println(result);
    }

    static class Fireball {
        int r;
        int c;
        int m;
        int s;
        int d;
        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "[r: " + r + ", c: " + c + ", m: " + m + ", s: " + s + ", d: " + d + "]";
        }
    }
}