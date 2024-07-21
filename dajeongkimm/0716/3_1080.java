import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int M;
    static int[][] A;
    static int[][] B;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        B = new int[N][M];
        for (int i=0;i<N;i++){
            String tmp = br.readLine();
            for (int j=0;j<M;j++){
                A[i][j] = tmp.charAt(j)-'0';
            }
        }
        for (int i=0;i<N;i++){
            String tmp = br.readLine();
            for (int j=0;j<M;j++){
                B[i][j] = tmp.charAt(j)-'0';
            }
        }
        int answer = 0;
        if (M<3 || N<3) {
            if (!IsSame(A,B)) answer = -1;
        }
        else {
            for (int i=0;i<N-2;i++){
                for (int j=0;j<M-2;j++){
                    if (A[i][j] != B[i][j]) {
                        Convert(A, i, j);
                        answer++;
                    }
                }
            }

            if (answer != -1) {
                if (!IsSame(A,B)) answer = -1;
            }
        }
        System.out.println(answer);



    }
    private static void Convert(int[][] A, int x, int y){
        for (int i=x;i<x+3;i++){
            for (int j=y;j<y+3;j++){
                A[i][j] ^= 1;
            }
        }
    }
    private static boolean IsSame(int[][] A, int[][] B){
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }
}