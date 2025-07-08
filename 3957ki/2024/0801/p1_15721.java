import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1_15721 {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int M = Integer.parseInt(br.readLine());
	    int A = Integer.parseInt(br.readLine());
	    int[] cnt = new int[2];
	    
	    int now = 0;
	    int repeat = 2;
	    Label: while(true) {
	    	for(int i = 0; i < 2; i++) {
	    		cnt[0]++;
		    	if(cnt[A] == M) break Label;
		    	now = (now+1)%N;
		    	cnt[1]++;
		    	if(cnt[A] == M) break Label;
		    	now = (now+1)%N;
	    	}
	    	for(int i = 0; i < repeat; i++) {
	    		cnt[0]++;
	    		if(cnt[A] == M) break Label;
	    		now = (now+1)%N;
	    	}
	    	for(int i = 0; i < repeat; i++) {
	    		cnt[1]++;
	    		if(cnt[A] == M) break Label;
	    		now = (now+1)%N;
	    	}
	    	repeat++;
	    }
	    System.out.println(now);
	}
}
