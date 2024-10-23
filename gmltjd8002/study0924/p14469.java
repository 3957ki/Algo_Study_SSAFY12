import java.io.*;
import java.util.*;
/*
treeset을 이용해서 값 정렬
1.키값이 가장 작은 소가 먼저 도착하므로 그 때의 키와 값 더하기(대기 + 검문시간)
2.그 다음 작은 키와 현재 시간 비교
    2-1. 현재 시간이 더 크다면 소가 도착한 것이므로 현재 시간에 검문 시간 더하기
    2-2. 현재 시간이 더 작다면 소가 도착하는 시간인 그 때의 키값에 검문시간을 더해준다
-> 중복된 값이 있을 수 있다 -> 기각
 */
public class p14469 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int len = map.size();
        int res = 0; // 현재 시간
        for(Map.Entry<Integer,Integer> entries : map.entrySet()){ // entries에 k,v형태로 반복문 돌리기
            int arrived = entries.getKey();
            int inspection = entries.getValue();
            res = Math.max(res, arrived); // 현재 시간이나 소가 도착한 시간 중 큰 값에 검문시간을 더해준다
            res += inspection; // 검문
        }
        System.out.println(res);
        // for(int val : keys){
        //     System.out.println(val + " ");
        // }
    }
}