import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int len;
    static int answer;
    static int N;
    static int[] arr;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        len = String.valueOf(N).length();

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        int firstNum = String.valueOf(N).charAt(0) - '0';
        answer = 0;

//        System.out.println(firstNum);
        for (int i = 0; i < K; i++) {
            makeNum(1, arr[i]);

        }
        System.out.println(answer);


    }

    private static void makeNum(int length, int num) {
        if (num>N) return;
        answer = Math.max(answer, num) ;

        if (length == len) return;

        for (int i = 0; i < K; i++) {
            int newNum = Integer.parseInt(String.valueOf(num) + arr[i]);
            if (newNum <= N) {
                makeNum(length + 1, newNum);
            }
        }
    }
}