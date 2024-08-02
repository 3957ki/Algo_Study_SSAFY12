import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 과일 하나를 먹으면 길이가 1만큼 늘어납니다.
 * 2. 과일들은 지상으로부터 일정 높이를 두고 떨어져 있으며 i (1 ≤ i ≤ N) 번째 과일의 높이는 hi
 * 3. 자신의 길이보다 작거나 같은 높이에 있는 과일들을 먹을 수 있습니다.
 * 4. 처음 길이가 L일때 과일들을 먹어 늘릴 수 있는 최대 길이를 구하세요.
 *
 * 일종의 완전탐색
 */

public class Main {
    public static void main(String[] args) throws  Exception {
        //System.setIn(new FileInputStream("res/snakebird.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i = 0;i < N;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int size = L;
        for(int i = 0;i < N;i++){
            //System.out.println(Arrays.toString(arr));
            if(arr[i] == -1) continue;
            //System.out.println(size);
            if(arr[i] <= size) {
                size = size + 1;
                arr[i] = -1;
                i = -1;
            }

        }

        System.out.println(size);
    }
}
