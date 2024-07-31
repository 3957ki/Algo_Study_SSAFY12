import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        for (int i=0;i<N;i++){
            dp[i] = arr[i];
        }
        for (int i=1;i<N;i++){
            for (int j=0;j<i;j++){
                if (arr[i]<arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i]);
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}