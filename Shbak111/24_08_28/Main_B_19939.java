import java.io.FileInputStream;
import java.util.Scanner;


/**
 * 각 바구니에는 1개 이상의 공이 있어야 하고, 바구니에 담긴 공의 개수가 모두 달라야 한다.
 * 숫자만큼의 boolean 배열을 만들고 해당 배열의 가장 작은 값부터 준다?
 * 무조건 0부터 k 까지의 합은 되야함 N이 그 이하면 무조건 -1
 *
 */

public class Main_B_19939 {
    static int N;
    static int K;
    static boolean[] selected;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0828\\B_19939_박터뜨리기\\b_19939.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        selected = new boolean[N];
        arr = new int[K];

        int limit = 0;
        for(int i = 0;i < arr.length;i++){
            arr[i] = i + 1;
            limit += arr[i];
        }

        if(N < limit){
            System.out.println(-1);
        } else {
            int i = 0;
            while (true) {
                if(limit + (K * i) == N){
                    System.out.println(K-1);
                    break;
                } else if(limit + (K * i) > N) {
                    System.out.println(K);
                    break;
                }
                i++;
            }
        }


        sc.close();
    }
}