import java.io.*;
import java.util.*;

public class p2599 {
    public static void main(String[] args) throws IOException{
        //[3][2] 배열에 남녀 각각 저장
        //A 남학생 기준으로 반복문 돌리기(B나 C)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());
        int[][] student = new int[3][2];
        StringBuilder sb = new StringBuilder();
        boolean flag = false; // 음이아닌 정수인지 확인할 boolean
        //배열에 학생 수 받기
        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                student[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] res = new int[3][2]; // 출력할 배열
        //A남 -> B남 -> C남 순으로 페어 선택
        for(int i=0;i<=student[0][0];i++){
            res[0][0] = i; // A남기준 -> A남B여
            res[0][1] = student[0][0] - i; // B에서 다 못만든 페어를 C에서 만듦
            res[1][1] = student[2][1] - res[0][1]; //C여학생 - A남C여 페어 수 -> C 여학생과 A남C여는 미리 구해놨다. res[1][0]과 바뀐이유
            res[1][0] = student[1][0] - res[1][1]; //B남 - B남C여 = B남A여
            res[2][0] = student[0][1] - res[1][0]; //A여 - B남A여 = C남A여
            res[2][1] = student[2][0] - res[2][0]; //C남 - C남A여 = C남B여
            
            if(res[0][0] >= 0 && res[0][1] >= 0 && res[0][1] >= 0 && res[1][0] >= 0 && res[1][1] >= 0 && res[2][0] >= 0 && res[2][1] >= 0){ // 다 음이아닌 정수라면 유효해
                System.out.println(1);
                System.out.println(res[0][0] + " " + res[0][1]);
                System.out.println(res[1][0] + " " + res[1][1]);
                System.out.println(res[2][0] + " " + res[2][1]);
                flag = true;
            }
        }
        if(!flag){ // 유효해가 없는경우
            System.out.println(0);
        }
    }
}


/*
A남 A여
B남 B여
C남 C여
 */
/*
출력이 1
(A남B여 페어 수) (A남C여 페어 수)
(B남A여 페어 수) (B남C여 페어 수)
(C남A여 페어 수) (C남B여 페어 수)
 */
/*
boolean flag = false;
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                if(res[i][j] < 0) flag = true;
            }
        }
        if(flag){ // 음수인 값이 있다면 그냥 0출력
            System.out.println(0);
        }
        else{
            System.out.println(1);
            for(int i=0;i<3;i++){
                for(int j=0;j<2;j++){
                    sb.append(res[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
 */