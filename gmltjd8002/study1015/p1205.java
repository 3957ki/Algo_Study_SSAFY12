import java.io.*;
import java.util.*;

public class p1205 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        Long newScore = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        //4번테케
        if(n == 0) {
            System.out.println(1);
            System.exit(0);
        }

        st = new StringTokenizer(br.readLine().trim());
        Long[] map = new Long[n]; //Long으로 선언해서 collections 쓸수있게하기
        for(int i=0;i<n;i++){
            map[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(map,Collections.reverseOrder()); //내림차순
        
        

        //들어갈 자리가 없는 경우
        if(n == p && (newScore <= map[n-1])){
            System.out.println(-1); 
        }

        //들어갈 여지가 있는 경우
        else{
            int idx = 1; // 비집고 들어갈 배열의 인덱스+1
            for(int i=0;i<n;i++){ // 배열 탐색
                if(newScore < map[i]) idx++; // 못끼워넣으면 다음인덱스 가리키기
                else break; // 이상인경우 루프 깨기
            }

            //2번 테케(기존 -> 바로 sysout(idx), 끝값과 점수가 같으면 점수가 들어갈 수 없다)
            if(idx <= p){
                System.out.println(idx); // 인덱스+1값 출력
            }else{
                System.out.println(-1);
            }
            
        }
        
    }
}