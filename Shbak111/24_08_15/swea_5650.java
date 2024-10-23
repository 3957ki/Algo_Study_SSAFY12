import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
 
/**
 *  N x N 크기의 핀볼 게임판에 정사각형 블록과 4가지 형태의 삼각형 블록들이 섞여 있고, 여기에 추가적으로 웜홀과 블랙홀이 존재
 *  1번 블록: 위쪽 오른쪽에서 만나면 꺾임.
 *  2번 블록: 아래쪽 오른쪽에서 오다가 만나면 꺾임.
 *  3번 블록: 왼쪽 아래쪽에서 오다가 만나면 꺾임.
 *  4번 블록: 왼쪽 위쪽에서 오다가 만나면 꺾임.
 *  5번 블록: 어디서 만나던 진행방향이 반대로 바뀜.
 *
 *  1. 일단 나의 진행 방향을 기억하고 있어야함.
 *  2. 자기 시작 위치로 돌아오면 끝임.
 *  웜홀 위치는 쌍이기 때문에 저장을 해두는 편이 깔끔할듯.
 *  그럼 어떤 자료구조를 써야할까
 *
 *
 */
 
public class Solution {
    static int[][] arr;
    static int startX;
    static int startY;
    static Map<Integer, int[]> wormhalls;
    static int max = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    // 각 dir 별 각 1~5 도형을 만났을 때 바뀌는 dx,dy의 방향 (오른쪽,왼쪽,아래,위 순서)
    static int[][] change = {{1,1,2,3,1},{3,2,0,0,0},{0,3,3,1,3},{2,0,1,2,2}};
    static int dir = 0;
 
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0815\\핀볼\\pinball.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test_case = Integer.parseInt(st.nextToken());
 
        for (int k = 1; k <= test_case; k++) {
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st2.nextToken());
            arr = new int[N][N];
            wormhalls = new HashMap<>();
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st3 = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st3.nextToken());
                    arr[i][j] = num;
                    if (num >= 6) {
                        if (wormhalls.containsKey(num)) {
                            wormhalls.put(num * -1, new int[]{i, j});
                        } else {
                            wormhalls.put(num, new int[]{i, j});
                        }
                    }
                }
            }
 
            for(int i = 0; i < N;i++){
                for(int j = 0; j < N;j++){
                    if(arr[i][j] != 0) continue;
                    startX = i;
                    startY = j;
                    //System.out.println(startX + " " + startY + " case start");
                    for(int v = 0; v < dx.length;v++){
                        dir = v;
                        int nx = i;
                        int ny = j;
                        int count = 0;
                        while(true){
                            nx += dx[dir];
                            ny += dy[dir];
 
                            //System.out.println(nx + " " + ny + " " + dir);
 
                            if (nx == startX && ny == startY){
                                max = Math.max(count,max);
                                //System.out.println(count);
                                break;
                            }
 
                            if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr.length){
                                if(arr[nx][ny] == -1) {
                                    max = Math.max(count,max);
                                    break;
                                }
 
                                if(arr[nx][ny] >= 6){
                                    int[] curr = wormhalls.get(arr[nx][ny]);
                                    //System.out.println("wormhall before: " + nx + " " + ny);
                                    if(curr[0] == nx && curr[1] == ny){
                                        curr = wormhalls.get(arr[nx][ny] * -1);
                                    }
                                    nx = curr[0];
                                    ny = curr[1];
                                    //System.out.println("wormhall after: " + nx + " " + ny);
                                    continue;
                                }
 
                                if(arr[nx][ny] == 1){
                                    dir = change[dir][0];
                                    count++;
                                } else if(arr[nx][ny] == 2){
                                    dir = change[dir][1];
                                    count++;
                                } else if(arr[nx][ny] == 3){
                                    dir = change[dir][2];
                                    count++;
                                } else if(arr[nx][ny] == 4){
                                    dir = change[dir][3];
                                    count++;
                                } else if(arr[nx][ny] == 5){
                                    dir = change[dir][4];
                                    count++;
                                }
                            } else {
                                dir = change[dir][4];
                                count++;
                            }
                        }
                    }
                }
            }
 
            System.out.println("#" + k + " " + max);
            max = 0;
        }
    }
}