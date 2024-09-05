import java.io.*;
import java.util.*;
public class p1421 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] map = new int[n];
        for(int i=0; i<n;i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);
        int maxLength = map[n-1];
        long maxVal = 0;
        for(int i=1;i<=maxLength;i++){
            long sum = 0;
            for(int j=0;j<n;j++){
                if(map[j] >= i){
                    int pieces = map[j] / i; //자른 횟수가 아닌 판자의 개수를 구해야한다
                    int cutCnt;
                    if(map[j] % i == 0){ // 딱 맞아 떨어질 때
                        cutCnt = pieces - 1;
                    } else { // 맞아 떨어지지 않을 때
                        cutCnt = pieces;
                    }
                    long profit = (long)w * i * pieces - (long)c * cutCnt;
                    if(profit > 0) {
                        sum += profit;
                    }
                }
            }
            maxVal = Math.max(sum, maxVal);
        }
        System.out.println(maxVal);
    }
}