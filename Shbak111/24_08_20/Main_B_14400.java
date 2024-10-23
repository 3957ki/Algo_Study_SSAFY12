package 알고리즘스터디저장;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *  모든 고객들의 거리의 합을 최소로 하려한다.
 *  두 위치의 거리는 |x1-x2|+|y1-y2|로 정의
 *
 *  일단 위치가 -도 있어서 클래스가 좋을듯
 */

public class Main_B_14400 {

    static int N;
    static int[] arrX;
    static int[] arrY;

    public static void main(String[] args) throws Exception{
       // System.setIn(new FileInputStream("C:\\Users\\khbak\\IdeaProjects\\test\\src\\실전코테스터디\\Algo_0820\\B_14400_편의점2\\store.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        arrX = new int[N];
        arrY = new int[N];

        for(int i = 0;i < N;i++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine().trim());
            arrX[i] = Integer.parseInt(st2.nextToken());
            arrY[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arrX);
        Arrays.sort(arrY);

        int x = arrX[N/2];
        int y = arrY[N/2];

        long disX = 0;
        long disY = 0;

        for(int i = 0;i < N;i++){
            disX += Math.abs(x - arrX[i]);
            disY += Math.abs(y - arrY[i]);
        }

        System.out.println(disX + disY);
    }
}
