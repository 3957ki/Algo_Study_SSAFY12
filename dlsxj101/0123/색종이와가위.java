import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이와가위 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        if (k < n + 1) {
            System.out.println("NO");
            return;
        }

        if (k == n + 1) {
            System.out.println("YES");
            return;
        }

        long low = 1;
        long high = n / 2;

        while (low <= high) {
            long mid = (low + high) / 2;

            long tmp = (mid+1) * (n-mid+1);
            if(tmp == k) {
                System.out.println("YES");
                return;
            }
            if(tmp > k) {
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        System.out.println("NO");
    }
}