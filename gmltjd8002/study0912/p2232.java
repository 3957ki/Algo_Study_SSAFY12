import java.io.*;
import java.util.*;

public class p2232 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n];
        for(int i=0; i<n;i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        if(map.length == 1){
            System.out.println(1);
        }else{
            if(map[0] >= map[1]){ // 맨앞
                System.out.println(1);
            }
            for(int i=1; i<n-1;i++){ // 중간
                if(map[i] >= map[i-1] && map[i] >= map[i+1]){
                    System.out.println(i+1);
                }
            }
            if(map[n-1] >= map[n-2]){
                System.out.println(n);
            }
        }
    }
}