import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int solution(int[][] arr, int[] num) {
        int answer = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                for (int k = j + 1; k < num.length; k++) {
                    // 세 가지 조합을 모두 확인해야 합니다.
                    if (arr[i][j] != 1 && arr[j][k] != 1 && arr[i][k] != 1) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/icecream.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st2.nextToken());
            int second = Integer.parseInt(st2.nextToken());

            arr[first - 1][second - 1] = 1;
            arr[second - 1][first - 1] = 1;
        }

        int result = solution(arr, num);
        System.out.println(result);
    }
}
