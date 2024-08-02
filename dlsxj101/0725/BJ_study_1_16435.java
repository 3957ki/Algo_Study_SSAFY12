import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

<<<<<<< HEAD
public class SnakeBird {
=======
public class BJ_study_1_16435 {
>>>>>>> 0c06d3e7576e0891531cf10c11e002f9327b53ca

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		
		int[] fruitHigh = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			fruitHigh[i] = Integer.parseInt(st.nextToken());
		}
		int startL = 0;
		
		while(true) {
			for(int i = 0; i < N; i++) {
				startL = L;
				if(fruitHigh[i] <= L && fruitHigh[i] != 0) {
					fruitHigh[i] = 0;
					L++;
					break;
				}
			}
			if(startL == L) break;
		}
		System.out.println(L);
	}
<<<<<<< HEAD

}
=======
}
>>>>>>> 0c06d3e7576e0891531cf10c11e002f9327b53ca
