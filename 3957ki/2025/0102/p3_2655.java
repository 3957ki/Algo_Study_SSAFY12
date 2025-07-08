import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p3_2655 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 블럭 배열
        Block[] arr = new Block[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[i] = new Block(i+1, area, height, weight);
        }

        // 밑면 면적 오름차순
        Arrays.sort(arr, (o1, o2) -> o1.area - o2.area);

        // dp[i] = 밑면이 i번째로 큰 블럭을 1층으로 했을 때 쌓을 수 있는 가장 높은 길이
        int[] dp = new int[N];

        int maxHeight = 0;
        int answer = 0;

        for(int i = 0; i < N; i++) {
            Block now = arr[i];
            dp[i] = now.height;

            // now보다 작은 밑면 블럭들 탐색
            for(int j = i-1; j >= 0; j--) {
                // now의 무게가 더 무겁고 dp[i] < dp[j] + now.height 라면 쌓기
                if(arr[j].weight <= now.weight && dp[i] < dp[j] + now.height) {
                    dp[i] = dp[j] + now.height;
                    now.tail = arr[j];
                    now.cnt = arr[j].cnt + 1;
                }
            }

            if(maxHeight < dp[i]) {
                maxHeight = dp[i];
                answer = i;
            }
        }

        sb.append(arr[answer].cnt+1).append('\n');
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[answer].num);
        Block now = arr[answer];

        while(now.tail != null){
            stack.push(now.tail.num);
            now = now.tail;
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append('\n');
        }

        System.out.println(sb);
    }

    static class Block {
        int num, area, height, weight, cnt;
        Block tail;

        public Block(int num, int area, int height, int weight) {
            this.num = num;
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
    }
}