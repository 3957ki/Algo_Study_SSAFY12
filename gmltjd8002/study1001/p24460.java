package study1001;
import java.io.*;
import java.util.*;
//분할정복 + 재귀 + 정렬?

public class p24460 {
    static int n,res;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        //값 넣기
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = divide(n,0,0); // 분할정복 메서드
        System.out.println(res);
    }
    /*
    기존 분할정복 -> 하나가 나올때까지
    1,2에 같은값이 나오는데 왜일까 -> divideBy4[3] 부분에 x+half y+half인데 x/2, y/2로 적어놨음
     */
    static int divide(int n, int x, int y){ // x,y좌표를 기준으로 분할정복(n -> 현재 분할된 개수)
        if(n == 1) return map[x][y]; // 재귀를 통해 마지막에 남는 경우 저장
        else{
            int half = n/2;
            //4등분
            int[] dividedBy4 = new int[4];
            dividedBy4[0] = divide(half,x,y); // 왼쪽위
            dividedBy4[1] = divide(half,x+half, y); //왼쪽아래
            dividedBy4[2] = divide(half,x,y+half); // 오른쪽위
            dividedBy4[3] = divide(half,x+half,y+half); // 오른쪽 아래
            Arrays.sort(dividedBy4);
            return dividedBy4[1];
        }
    }
}