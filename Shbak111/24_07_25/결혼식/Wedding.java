import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 상근이의 동기는 모두 N명이고
 * 2. 학생들의 학번은 모두 1부터 N까지
 * 3. 상근이의 학번은 1
 *  동기의 수 n  (2 ≤ n ≤ 500)
 *   리스트의 길이 m  (1 ≤ m ≤ 10000)
 *   m개 줄에는 친구 관계 ai bi가 주어진다. bi와 ai도 친구관계이다
 */

public class Main {
    static Set<Integer> set = new HashSet<>();
    public static void DFS(int[][] arr, int x,int y, int lev) {
        if(lev >= 3) return;
        if(y != 1) set.add(y);
        arr[y][x] = 0;

        for(int i = 1;i < arr.length;i++){
            if(arr[y][i] == 1){
                //System.out.println(x + " " + y);
                DFS(arr, y, i, ++lev);
                --lev;
            }
        }
        //System.out.println(Arrays.toString(set.toArray())+ " level " + lev);
    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/wedding.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st2.nextToken());

        int[][] arr = new int[N+1][N+1];

        for(int i = 0;i < M;i++){
            StringTokenizer st3 = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st3.nextToken());
            int y = Integer.parseInt(st3.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        for(int i = 1;i < N + 1;i++){
            if(arr[1][i] == 1){
                DFS(arr, 1, i, 1);
            }
        }
        System.out.println(set.size());
        //System.out.println(Arrays.toString(set.toArray()));
    }
}
