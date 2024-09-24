import java.io.*;
import java.util.*;

/*
시간초과...
 */

public class p24523 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;i++){ // n번 탐색
            boolean flag = false;
            for(int j=i+1;j<=n;j++){
                if(map[i] != map[j]){
                    flag = true;
                    sb.append(j).append(" ");
                    break;
                }
            }
            if(!flag) sb.append(-1).append(" ");
        }
        System.out.println(sb);
    }
}