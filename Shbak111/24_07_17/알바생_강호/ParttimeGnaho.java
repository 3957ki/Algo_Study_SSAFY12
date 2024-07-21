import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public int solution(int[] arr) {
        long answer = 0;
        int count = 0;
        Arrays.sort(arr);

        for(int i = arr.length - 1;i >= 0;i--) {
            if(arr[i] - count >= 0)
                answer += arr[i] - count;
            count++;
        }

        System.out.println(answer);
        return 0;
    }


    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("res/parttime.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int size = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];

        for(int i = 0;i < size;i++) {
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Main p = new Main();
        p.solution(arr);
    }
}
