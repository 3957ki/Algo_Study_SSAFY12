import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] arr;
    static boolean possible;
    static int win;
    static int lose;
    static int same;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i=0;i<4;i++){
            win = 0;
            same = 0;
            lose = 0;
            arr = new int[6][3];
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<6;j++){
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
                arr[j][2] = Integer.parseInt(st.nextToken());
                win += arr[j][0];
                same += arr[j][1];
                lose += arr[j][2];

            }
            possible = false;
            IsAvail(0,1);
            int answer = possible ? 1:0;
            for (int x=0;x<6;x++){
                if (arr[i][0]+arr[i][1]+arr[i][2] != 5){
                    answer = 0;
                }
            }
            if ((win + same + lose) != 30) answer = 0;

            System.out.printf(answer+" ");

        }

    }
    private static void IsAvail(int A, int B){
        if (B==6){
            A++;
            B = A+1;
        }
        if (A>=5){
            possible = true;
            return;
        }

        //A가 이길때
        if(arr[A][0]>0 && arr[B][2]>0) {
            arr[A][0]--;
            arr[B][2]--;
            IsAvail(A, B+1);
            arr[A][0]++;
            arr[B][2]++;
        }

        //B가 이길때
        if(arr[A][2]>0 && arr[B][0]>0){
            arr[A][2]--;
            arr[B][0]--;
            IsAvail(A,B+1);
            arr[A][2]++;
            arr[B][0]++;
        }

        //비길 때
        if(arr[A][1]>0 && arr[B][1]>0){
            arr[A][1]--;
            arr[B][1]--;
            IsAvail(A, B+1);
            arr[A][1]++;
            arr[B][1]++;
        }
    }

}