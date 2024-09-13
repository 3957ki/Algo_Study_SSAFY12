import java.io.*;
import java.util.*;

public class boj_10994 {
    static String[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new String[400][400];
        int maxlen = 4*(N-1)+1;

        //길이 : 1 5 9 13
        //시작점 : 0 2 4 6
        int t = 1;
        for(int i=N; i>=1; i--){ //3 2 1
            int len = 4*(i-1)+1; //9 5 1
            int start = (t-1)*2; //0 2 4
            draw(start, len);
            t++;
        }
        print(maxlen);
    }
    static void draw(int start, int len){
        for(int i=0; i<len; i++){
            board[start][start+i]
                    = board[start+i][start]
                    = board[start+len-1][start+i]
                    = board[start+i][start+len-1]
                    = "*";
        }
    }
    static void print(int len){
        for(int i=0; i<len; i++){
            if(i>0) System.out.println();
            for(int j=0; j<len; j++){
                if(board[i][j] == null) System.out.print(" ");
                else System.out.print(board[i][j]);
            }
        }
    }
}
