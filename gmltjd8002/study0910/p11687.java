import java.io.*;
import java.util.*;
/*
10 -> 2 X 5이다.
2는 매우 많으므로 고려할 필요 없고, 0의 개수는 5가 몇번 곱해지는지에 따라 결정된다고 볼 수 있다
직접 팩토리얼을 계산하는 대신 5가 몇번 곱해져 0의 개수가 달라지는지에 대해서만 보면 된다
5의 제곱수(5,25,125,625,.. and so on) 들은 카운트가 1씩 증가하는게 아니므로 주의해서 봐야한다
right -> 5가 m번 있는 경우가 최대 범위로 잡는 경우의 수 중 최소의 범위에 속한다
 */
public class p11687 {
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        m = Integer.parseInt(br.readLine());
        long res = -1;
        long left = 1; //1부터 시작?
        
        // 10의배수를 만드려면 5의 개수가 중요한데, 최대의 경우 5를 m개 가지고 있다
        long right = 5*m; 
        while(left <= right){
            long mid = (left+right)/2;
            //mid!자리에 0 몇개있는지 알아보고 -> 여기 이상함
            long midZeroCnt = getZeroCnt(mid);
            //그게 m보다 크다면? right -> mid-1
            if(midZeroCnt >= m) {
                if(midZeroCnt == m){
                    res = mid;
                    right = mid-1; // 만족하는 값이 있어도 그 중에서 더 작은값이 나올 수 있다(ex) 6과 7은 둘다 0의개수가 1인데 6이 답이다
                }
                right = mid-1;
            }
            //아니면 m보다 작다? left -> mid+1
            else left = mid+1;
        }

        // res가 갱신이 안됐다면 그냥 -1이고 아니면 이분탐색에서 갱신됐던 값이 출력된다
        System.out.println(res);
    }
    static long getZeroCnt(long x){
        long cnt =0;
        for(long i=5;i<=x;i*=5){ // i가 5면 1씩, 25면 2씩, 125면 3씩, 625면 4씩 이런식으로 카운트에 담긴다
            cnt += x/i;
        }
        return cnt;
    }
}
