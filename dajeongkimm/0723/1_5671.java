import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        while ((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(Room(N,M));

        }




    }
    private static int Room(int N, int M){
        int result = 0;
        for (int i=N;i<=M;i++){
            int tmp = i;
            HashSet<Integer> set = new HashSet<>();
            boolean flag = true;
            while (tmp>0){
                int num = tmp%10;
                if (set.contains(num)) {
                    flag = false;
                    break;
                }
                else {
                    set.add(num);
                }
                tmp /= 10;
            }
            if (flag) result++;
        }
        return result;
    }
}