import java.io.*;
import java.util.*;
/*
n 별로 안크니깐 완탐 가능할거같음 -> 슬라이딩 윈도우
 */
public class p14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] map = new int[100000];
        for(int i=0;i<b;i++){
            int val = Integer.parseInt(br.readLine())-1; //배열 시작값이 0이므로 -1
            map[val] = 1; // 고장난 부분은 1
        }

        int cnt = 0;
        // 처음 계산
        for(int i=0;i<k;i++){
            if(map[i] == 1) cnt++; //고장난 개수++
        }
        int minVal = cnt; //초기값 저장 -> 반복문 돌면서 이 값이랑 비교

        //슬라이딩 윈도우(i에서 i+k까지 신호등 상태 보기)
        for(int i=0;i+k<n;i++){
            if(map[i] == 1) cnt--; // 시작값이 1 -> 0로 바뀌는 경우
            if(map[i+k] == 1) cnt++; // 윈도우안에 고장난 게 있다면 ++
            minVal = Math.min(minVal, cnt);
        }
        System.out.println(minVal);
    }
}