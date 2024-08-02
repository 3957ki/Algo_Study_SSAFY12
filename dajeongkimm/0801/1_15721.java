import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int bundegi = Integer.parseInt(br.readLine());

        int total = -1;
        int cur_person=0;
        int a_count = 0;
        int b_count = 0;
        A: for (int i=2;i<10000;i++){
            for (int j=0;j<2;j++){
                a_count++;
                total++;
                if (bundegi == 0 && a_count==t){
//                    System.out.println("break A");
//                    System.out.println(total);
                    cur_person = total%a;
                    break A;
                }
                b_count++;
                total++;

                if (bundegi == 1 && b_count==t){
                    cur_person = total%a;
                    break A;
                }
            }
            for (int j=0;j<i;j++){
                a_count++;
                total++;
                if (bundegi == 0 && a_count==t){
                    cur_person = total%a;
                    break A;
                }
            }
            for (int j=0;j<i;j++){
                b_count++;
                total++;
                if (bundegi == 1 && b_count==t){
                    cur_person = total%a;
                    break A;
                }
            }

        }
        System.out.println(cur_person);
    }
}