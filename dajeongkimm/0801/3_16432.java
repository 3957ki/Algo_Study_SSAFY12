import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static boolean[][] arr;
    static int n;
    static int[] answer;
    static int[][] dp;
    static int[][] next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n+1][10];
        dp = new int[n+1][10];
        for (int i=0;i<n+1;i++){
            for (int j=0;j<10;j++){
                dp[i][j] = -1;
            }
        }
        next = new int[n+1][10];
//        memo = new boolean[n+1][10];
        for (int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            for (int j=0;j<N;j++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][tmp] = true;
            }
        }
        boolean flag = false;
        answer = new int[n];
        for (int i=1;i<=9;i++){
            if (arr[1][i]){
                if (isAvail(i, 1)){
                    flag = true;
                    int day = 1;
                    int food = i;
                    for (int j=0;j<n;j++){
                        answer[j] = food;
                        food = next[day][food];
                        day++;
                    }
                    for (int j=0;j<n;j++){
                        System.out.println(answer[j]);
                    }
                    break;

                };
            }
        }
        if (!flag){
            System.out.println(-1);
        }

    }
    private static boolean isAvail(int cur_food, int day){
        if (day == n){
            return true;
        }
        if (dp[day][cur_food] != -1){
            return dp[day][cur_food] == 1;
        }
        for (int i=1;i<=9;i++){
            if (i != cur_food && arr[day+1][i]){
                if (isAvail(i, day+1)){
                    dp[day][cur_food] = 1;
                    next[day][cur_food] = i;
                    return true;
                }
            }
        }
        dp[day][cur_food] = 0;
        return false;
    }
}