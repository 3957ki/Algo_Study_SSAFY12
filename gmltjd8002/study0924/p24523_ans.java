import java.io.*;
import java.util.*;

public class p24523_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n+1];
        int[] result = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        
        int next = -1;
        for (int i = n; i >= 1; i--) {
            result[i] = next;
            if (i > 1 && map[i] != map[i-1]) {
                next = i;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}