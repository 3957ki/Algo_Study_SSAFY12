import java.io.*;
import java.util.*;

public class p14469_ans {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int res =0;
        int cows[][] = new int[n][2]; // [][0] 도착, [][1] 검문시간
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows, (o1,o2) -> o1[0] - o2[0]); // 람다를 이용해 오름차순 정렬
        for(int i=0; i<n;i++){
            if(res < cows[i][0]){ // 현재 시간보다 소의 도착시간이 더 길다면 -> 앞에서 정렬했으므로 신경 쓸 일 없다
                res=cows[i][0] + cows[i][1]; // 소가 도착하는 시간에 검문시간을 더해준다
            }else{ // 이건 현재 시간이 더 길다면(앞에 소가 검문을 하는동안 그 뒤의 소가 도착한 경우)
                res+= cows[i][1]; // 검문시간만 더해준다
            }
        }
        System.out.println(res);
    }
}