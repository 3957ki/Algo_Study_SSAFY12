import java.io.*;
import java.util.*;

public class p13417 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine().trim());
        for(int i=0;i<t;i++){
            int len = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine().trim());
            Deque<String> deque = new ArrayDeque<>(); //데크
            deque.addFirst(st.nextToken()); //첫값
            for(int j=1;j<len;j++){
                String tmp = st.nextToken(); //기존값이랑 비교할 임시 문자열
                if(deque.getFirst().compareTo(tmp) < 0){ // 기존 맨앞값이 tmp보다 작으면 음수 반환
                    deque.addLast(tmp);
                }else{
                    deque.addFirst(tmp);
                }
            }
            for(String str : deque){
                System.out.print(str);
            }
            System.out.println();
        }
    }
}
