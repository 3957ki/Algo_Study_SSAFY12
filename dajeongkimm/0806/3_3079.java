import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static long mid;
    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        //N개의 심사대, M명
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] time = new long[N];
        long max_time = 0;
        for (int i=0;i<N;i++){
            time[i] = Long.parseLong(br.readLine());
            max_time = Math.max(max_time, time[i]);
        }
        //N ~ 10만, M ~ 10억
        long min = 1;
        long max = max_time*M;
        mid = 0;
        long answer = max;
        while (min<=max){
            mid = (min+max)/2;
//            System.out.println(mid);
            long could_people = 0;
            boolean flag = false;
            for (int i=0;i<N;i++){
                could_people += (mid/time[i]);
                if (could_people>=M){
                    answer = mid;
                    max = mid-1;
                    flag = true;
                    break;
                }
            }
            if (flag){
                continue;
            }
            min = mid+1;
        }
        System.out.println(answer);
    }
}