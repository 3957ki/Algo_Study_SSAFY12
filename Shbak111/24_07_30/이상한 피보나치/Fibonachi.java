package 실전코테스터디.Algo_0730;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  f(n) = f(n-1) + f(n-3)
 */

public class Fibonachi {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/fibonachi.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[117];

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;

        for(int i = 3;i < arr.length;i++){
            arr[i] = arr[i - 1] + arr[i - 3];
        }

        System.out.println(arr[N-1]);
    }
}
