package study1203;

import java.io.*;
import java.util.*;

public class Main_27446_랩실에서잘자요 {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> papers = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            papers.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> notContain = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!papers.contains(i)) {
                notContain.add(i);
            }
        }

        if (notContain.isEmpty()) {
            System.out.println(0);
            return;
        }

        int res = 7;
        int last = notContain.get(0);

        for (int i = 1; i < notContain.size(); i++) {
            int cur = notContain.get(i);
            if(cur - last >= 4) {
            	res += 7;
            }else {
            	res += (2*(cur-last));
            }
            last = cur;
        }

        System.out.println(res);
    }
}
