package study0926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2817_ALPS식투표 {
    static int X, N;
    static int[] ans;
    static PriorityQueue<Integer>[] pq;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[26];
        pq = new PriorityQueue[26];
        for (int i = 0; i < 26; i++) {
            pq[i] = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }
        ans = new int[26];
        Arrays.fill(ans, -1);
        int per5 = X * 5 / 100;

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());
            if (n >= per5) {
                cnt++;
                ans[ch - 'A'] = 0;
                for (int j = 1; j <= 14; j++) {
                	//9% 테스트케이스가
                	//득표율 5% 이상인데
                	//자신의 득표율 나누기 1~14했을때 0이 들어갈수도있다.
                    pq[ch - 'A'].offer(n / j);
                }
            }
        }

        char cur;
        int max;

        // 14번 반복하면서 우선순위 큐에서 값 꺼내기
        for (int k = 1; k <= 14; k++) {
            cur = '0';
            max = -1;  // 초기값을 -1로 설정
            for (int i = 0; i < 26; i++) {
                if (!pq[i].isEmpty() && max < pq[i].peek()) {
                    max = pq[i].peek();
                    cur = (char) (i + 'A');
                }
            }
            if (cur != '0' && max > 0) {  // 유효한 값인지 확인
                ans[cur - 'A']++;
                pq[cur - 'A'].poll(); // 최댓값 제거
            }
        }
        for (int i = 0; i < 26; i++) {
            if (ans[i] >= 0 ) {
                cur = (char) (i + 'A');
                System.out.println(cur+" "+ans[i]);
            }
        }
        
        
        
        
    }
}
