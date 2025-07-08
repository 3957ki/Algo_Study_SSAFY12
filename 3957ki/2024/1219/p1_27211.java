import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p1_27211 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        HashSet<Integer> set = new HashSet<>();
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            // 현재값에서 이전 값을 뺀 수가 set에 있는지 확인
            for(int j = 0; j < i; j++){
                if(set.contains(arr[i] - arr[j])) {
                    answer++;
                    break;
                }
            }

            // 이전값과 현재값의 합을 set에 저장
            for(int j = 0; j <= i; j++){
                set.add(arr[j]+arr[i]);
            }

        }

        System.out.println(answer);
    }

}