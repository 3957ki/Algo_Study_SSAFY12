import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Solution {
    static int N, K;
    static char[] elems;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        elems = new char[K];
        for (int i = 0; i < K; i++) {
            elems[i] = st.nextToken().charAt(0);
        }

        System.out.println(solution());
    }

    private static int solution() {
        for (int i = N; i >= 0; i--) {
            char[] target = String.valueOf(i).toCharArray();
            boolean[] isContain = new boolean[target.length];
            for (int j = 0; j < target.length; j++) {
                for (int k = 0; k < elems.length; k++) {
                    if (target[j] == elems[k]) {

                        isContain[j] = true;
                    }
                }
            }

            boolean flag = true;
            for (int j = 0; j < isContain.length; j++) {
                if (!isContain[j]) {
                    flag = false;
                }
            }
            if (flag) {
                return i;
            }

        }
        return -1;
    }

}
