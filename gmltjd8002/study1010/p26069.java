import java.io.*;
import java.util.*;
/*
집합? 맵?
 */
public class p26069 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<String> users = new HashSet<>();
        users.add("ChongChong"); // 이미 추고있던 사람 넣기
        int n = Integer.parseInt(br.readLine().trim());
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine().trim());
            String left = st.nextToken();
            String right = st.nextToken();
            // 왼쪽이나 오른쪽에 이미 집합에 들어가있는 애가 있다면
            if(users.contains(left) || users.contains(right)){ 
                //둘다 추가(기존 값은 중복제거되므로 상관X)
                users.add(left);
                users.add(right);
            }
        }
        System.out.println(users.size());
    }
}