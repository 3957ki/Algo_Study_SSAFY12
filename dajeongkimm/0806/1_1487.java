import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main{
    static int N;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N][2];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cost[i][0] = a;
            cost[i][1] = b;
        }
        Arrays.sort(cost, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return Integer.compare(o1[1],o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int max_value = 0;
        int answer = 0;
        for (int i=0;i<N;i++){
            int cur = cost[i][0];
            int cur_value = 0;
            for (int j=0;j<N;j++){
                if (cost[j][0]>=cur){
                    if ((cur-cost[j][1])>0){
                        cur_value += (cur-cost[j][1]);
                    }
                }
            }
//            System.out.println(cur_value);
            if (max_value<cur_value){
                max_value = cur_value;
                answer = cur;
            }
        }
        System.out.println(answer);
    }
}