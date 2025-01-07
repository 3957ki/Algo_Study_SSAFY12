import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로봇프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while ((input = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            int x = Integer.parseInt(input + "0000000");

            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine().trim());
            }

            Arrays.sort(arr);

            int indexA = 0;
            int indexB = n - 1;
            while (true) {
                if (indexA >= indexB) {
                    sb.append("danger");
                    break;
                }
                int a = arr[indexA];
                int b = arr[indexB];

                if (a + b == x) {
                    sb.append("yes ").append(a).append(" ").append(b);
                    break;
                } else if (a + b < x) {
                    indexA++;
                } else if (a + b > x) {
                    indexB--;
                }
            }
            System.out.println(sb);
        }
    }
}
