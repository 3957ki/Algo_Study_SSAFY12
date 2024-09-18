import java.io.*;
import java.util.*;

class p27466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i=n-1; i>=0; i--){
            if (sb.length() == 0) {
                if (str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U') continue;
                sb.append(str.charAt(i));
            } else if (sb.length() == 1 || sb.length() == 2) {
                if (str.charAt(i) == 'A') {
                    sb.append(str.charAt(i));
                }
            } else {
                sb.append(str.charAt(i));
            }
        }
        if (sb.length() >= m){
            System.out.println("YES");
            sb.reverse();
            System.out.println(sb.substring(sb.length()-m, sb.length()));
        } else {
            System.out.println("NO");
        }
    }
}