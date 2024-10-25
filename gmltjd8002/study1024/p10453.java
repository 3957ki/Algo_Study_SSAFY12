import java.io.*;
import java.util.*;

public class p10453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            // 길이가 다르면 변환 불가능
            if(a.length() != b.length()) {
                sb.append(-1).append("\n");
                continue;
            }

            int aCount = 0;
            int bCount = 0;
            // a와 b의 개수를 센다
            for(char c : a.toCharArray()) {
                if(c == 'a') aCount++;
                else bCount++;
            }

            // 두 문자열의 a,b 개수가 다르면 변환 불가능
            for(char c : b.toCharArray()) {
                if(c == 'a') aCount--;
                else bCount--;
            }
            if(aCount != 0 || bCount != 0) {
                sb.append(-1).append("\n");
                continue;
            }

            int ans = 0;
            int idx = 0;
            // a의 각 위치에서 b를 보면서 다른 위치의 개수를 센다
            // 중요한 점: a와 b의 상대적 순서는 유지되어야 함
            for(int j = 0; j < a.length(); j++) {
                if(a.charAt(j) == 'a') {  // a에서 'a'를 발견하면
                    while(idx < b.length() && b.charAt(idx) != 'a') {
                        idx++;  // b에서 다음 'a'를 찾을 때까지 이동
                    }
                    // 두 'a' 사이의 거리가 필요한 swap 횟수
                    ans += Math.abs(j - idx);
                    idx++;
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}