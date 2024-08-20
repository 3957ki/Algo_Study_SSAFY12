import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

       Arrays.sort(arr);
        int answer = 0;

        int start = 0;
        int end = N-1;
        while (start<end){
            answer += arr[end]*2;
            start++;
            end--;
        }
        if (N%2 == 1) answer += arr[start];
        System.out.println(answer);

    }
}
