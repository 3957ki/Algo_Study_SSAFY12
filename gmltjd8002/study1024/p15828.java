import java.io.*;
import java.util.*;
/*
큐?
n -> 버퍼 크기

 */
public class p15828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine().trim());
        Queue<Integer> q = new ArrayDeque<>();
        int input = 0;
        //EOF
        while((input = Integer.parseInt(br.readLine().trim())) != -1){

            //0이면 하나 처리했으므로 큐 하나 빼기
            if(input == 0){
                q.poll();
            }

            //큐 사이즈가 넘어간다면 해당 값 큐에 추가 X
            if(q.size() >= n) continue;


            if(input != 0){ //둘 다 아니면 큐에 오퍼
                q.offer(input);
            }
        }
        int len = q.size(); // 남은 큐의 개수
        if(len == 0) System.out.println("empty");
        for(int i : q){
            System.out.print(i + " ");
        }
    }
}
