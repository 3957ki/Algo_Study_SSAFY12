import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[][] arr;
    static boolean[][] isVisit;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int num = Integer.MAX_VALUE; // 기존의 최솟값
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine().trim());
        arr = new int[T+2][T+2]; // 외곽쪽 패딩을 위해 각각+1
        isVisit = new boolean[T+2][T+2];
        
        //값 할당
        for(int i =1; i<=T;i++){ // int 초기값 0, bool 초기값 false
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=T;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 여기 dfs + 백트래킹
        dfs(0, 0);
        System.out.println(num);
    }

    public static void dfs(int cnt, int sum){
       if(cnt == 3) {
          num = Math.min(num,  sum); // sum -> 현재 값
       }
       
       else {
          for(int i=2; i<T;i++){ // 행
               for(int j =2; j<T;j++){ // 열
                   // 넘어가지 않았을 때 사방+본인의 값을 더함
                   //방문여부 배열 갱신 -> 다음거 할때 겹치는지 이걸로 확인 -> 겹치면 continue
                   //안겹치고 세개가 생긴 경우 기존값과 비교해서 최솟값으로 값 갱신
                   if(!isVisit[i][j] && check(i,j)){
                     isVisit[i][j] = true;
                     int sumCur = sumVal(i,j);
                     dfs(cnt+1, sum+sumCur);
                     clearVal(i,j);
                     isVisit[i][j] = false;
                   }
               }
           }
       }
    }
    
    static int sumVal(int x , int y) {
       int val = arr[x][y]; // 꽃 중앙 값
       for(int i =0; i<4;i++) { // 4방향 값
          int r = x + dx[i];
          int c = y + dy[i];
          isVisit[r][c] = true;
          val += arr[r][c];
       }
       return val;
    }
    
    static boolean check(int x, int y) { // 현재위치의 4방향에 꽃잎이 뻗을 수 있는지 체크
       if(isVisit[x][y] == true) return false;   // 현재 중앙자리에 이미 꽃잎이 있는 경우
       for(int i=0; i<4;i++) {   // 4방향 합 및 가능 여부 판단
          int r = x + dx[i];
          int c = y + dy[i];
          if(isVisit[r][c]) return false;   // 뻗을 4방향에 꽃잎이 있는 경우
       }
       return true;
    }

    static void clearVal(int x, int y){ // 백트래킹을 위한 방문기록 초기화
      for(int i =0; i<4;i++){
         int r = x + dx[i];
         int c = y + dy[i];

         isVisit[r][c] = false;
      }
    }
}