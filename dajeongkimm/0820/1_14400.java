import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class Main_1 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());

        int[] arr_x = new int[N];
        int[] arr_y = new int[N];


        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr_x[i] = Integer.parseInt(st.nextToken());
            arr_y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_x);
        Arrays.sort(arr_y);
        if (N%2 == 1){
            int mid_x = arr_x[N/2];
            int mid_y = arr_y[N/2];

            long answer = 0;
            for (int i=0;i<N;i++){
                answer += Math.abs(mid_x - arr_x[i]);
                answer += Math.abs(mid_y - arr_y[i]);
            }
            System.out.println(answer);
        }
        else {
            int mid_x = arr_x[N/2];
            int mid_y = arr_y[N/2];

            long answer1 = 0;
            for (int i=0;i<N;i++){
                answer1 += Math.abs(mid_x - arr_x[i]);
                answer1 += Math.abs(mid_y - arr_y[i]);
            }

            long answer2 = 0;
            mid_x = arr_x[N/2-1];
            mid_y = arr_y[N/2-1];

            for (int i=0;i<N;i++){
                answer2 += Math.abs(mid_x - arr_x[i]);
                answer2 += Math.abs(mid_y - arr_y[i]);
            }

            long answer = Math.min(answer1,answer2);
            System.out.println(answer);
        }

    }
}
