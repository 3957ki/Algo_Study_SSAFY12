import java.io.*;
import java.util.*;

public class Main {
   static int N,M, cnt;
   static char[][] A;
   static char[][] B;
   public static void main(String[] args) throws IOException{
      
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st;

   st = new StringTokenizer(br.readLine());
   N = Integer.parseInt(st.nextToken());
   M = Integer.parseInt(st.nextToken());
   A = new char[N][N];
   B = new char[N][N];
   for(int i=0;i<N;i++){ // A 배열에 값 배정
      String str = br.readLine();
      for(int j=0;j<M;j++){
         A[i][j] = str.charAt(j);
      }
   }

   for(int i=0;i<N;i++){ // B 배열에 값 배정
      String str = br.readLine();
      for(int j=0;j<M;j++){
         B[i][j] = str.charAt(j);
      }
   }

   if(N < 3 || M < 3){ // 3이하의 배열이 나올 때 
      if(compare(N,M)){
         System.out.println(0);
      } else{
         System.out.println(-1);
      }return;
   }
   int cnt = 0; // 뒤집는 횟수를 저장할 변수
   for(int i =0; i<N-2;i++){
      for(int j =0; j<N-2;j++){
         if(A[i][j] != B[i][j]){
            // 배열 뒤집는 메서드 -> changeArr
            changeArr(i, j);
            cnt++;
         }
      }
   }
   if(compare(N,M)){
      cnt = -1;
   }
   System.out.println(cnt);
}

   public static void changeArr(int curX, int curY){
      for(int i=0; i<curX+3;i++){
         for(int j=0; j<curY+3;j++){
            // A[i][j] = ((A[i][j] + 1) % 2); 이건 정수형일때만
            if(A[i][j] == '1'){
               A[i][j] = '0';
            } else if(A[i][j] == '0'){
               A[i][j] = '1';
            }
         }
      }
   }
   public static boolean compare(int N, int M){ // 두 배열이 같은지 비교하는 메서드
      for(int i =0; i<N;i++){
         for(int j =0; j<M;j++){
            if(A[i][j] != B[i][j]) return false;
         }
      }
      return true;
   }
}
   /*
// 3 : 1 , 4 : 2 , 5 : 3,6 : 4
   for(int i=0;i<N*2;i+=N){ // 0행 -> 3행, 1행 -> 4행, ... and so on.
      for(int j=0;j<M;j++){ // 가로
         
      }
   }
}

   public static int[][] selectArr(int[][] arr, int y){ // 이전배열 뒤집기
      int[][] tmp = new int[3][3];
      for(int i =0; i<3;i++){
         for(int j =0; j<3;j++){
            tmp[i][j] = ((arr[i][y+j] + 1) % 2);
         }
      }
      return tmp;
   }*/
