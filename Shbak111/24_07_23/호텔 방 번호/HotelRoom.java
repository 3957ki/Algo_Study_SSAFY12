/**
 * 1. 선영이는 838호나 1004호와 같이 한 숫자가 두 번 이상 들어있는 집에는 절대 살지 않을 것이다.
 * 2. 호텔 방 번호는 N보다 크거나 같고, M보다 작거나 같아야 한다는 조건
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int solution(int start, int end) {

        int answer = end - start + 1;
        int count = end - start + 1;

        for(int i = 0;i < count;i++){
            int[] visited = new int[10];
            String strS = start + "";
            for(int j = 0;j < strS.length();j++){
                int num = strS.charAt(j) - '0';
                if(visited[num] == 1){
                    answer--;
                    break;
                }
                else {
                    visited[num] = 1;
                }
            }
            start++;
        }
        System.out.println(answer);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/hotelroom.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(bf.ready()){
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            solution(start, end);
        }

    }
}
