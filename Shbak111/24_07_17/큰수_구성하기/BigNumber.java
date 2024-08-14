import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.*;

public class Main {
    public PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

    public void solution(int[] arr, String now, int limit, int length) {
        if (now.length() > 0 && now.length() <= length) {
            if (Integer.parseInt(now) <= limit) {
                queue.offer(Integer.parseInt(now));
            }

        }
        if (now.length() > 0 && now.length() == length) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            String tmp = now + arr[i];
            solution(arr, tmp, limit, length);
        }

    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/bignumber.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int limit = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Main bn = new Main();
        String lstring = limit + "";

        bn.solution(arr, "", limit, lstring.length());

        int answer = bn.queue.peek();
        System.out.println(answer);
    }
}
