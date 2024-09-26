import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prob3_22981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long minute = 0;
        for(int i=1; i<N; i++){
            minute = Math.max(minute, arr[0]*i + arr[i]*(N-i));
        }

        long ans = K%minute==0 ? K/minute : K/minute+1;
        System.out.println(ans);
    }
}
