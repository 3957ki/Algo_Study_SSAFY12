import java.io.*;
import java.util.*;

public class p10994 {
    static char[][] map;
    static int num;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        num = 1 + 4*(t-1);
        map = new char[num][num];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                map[i][j] = ' ';
            }
        }
        recursive(0,num); // 재귀하면서 char 배열의 올바른 위치에 * 대입
        for(int i=0; i<num;i++){
            for(int j=0; j<num;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void recursive(int init, int len){
        if(len <= init) return;
        //바깥쪽 부분 패딩(재귀를 돌면서 추후에 액자식으로 패딩된다)
        for(int i = init; i<len;i++){
            map[init][i] = '*'; // 맨 위
            map[len-1][i] = '*'; // 이건 맨아래
            map[i][init] = '*'; // 왼쪽?
            map[i][len-1] = '*'; // 오른쪽
        }
        recursive(init+2, len-2); // 크기가 2x2로 줄었다
    }
}

/*

*********    
*       *
* ***** *
* *   * *
* * * * *
* *   * *
* ***** *
*       *
*********
액자식 구성이므로 재귀로

 */