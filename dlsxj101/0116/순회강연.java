import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순회강연 {

    static class PD implements Comparable<PD> {
        int p;
        int d;

        public PD(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(PD o) {
            if (this.p == o.p) return Integer.compare(o.d, this.d);
            else return Integer.compare(o.p, this.p);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            System.out.println(0);
            return;
        }
        PD pdArr[] = new PD[n];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            max = Math.max(max, d);

            pdArr[i] = new PD(p, d);
        }
        boolean visited[] = new boolean[max + 1];

        Arrays.sort(pdArr);

        int total = 0;
        for (PD tmp : pdArr) {
            int price = tmp.p;
            int day = tmp.d;

            for (int i = day; i >= 1; i--) {
                if (visited[i]) continue;

                visited[i] = true;
                total += price;
                break;
            }
        }
        System.out.println(total);
    }
}