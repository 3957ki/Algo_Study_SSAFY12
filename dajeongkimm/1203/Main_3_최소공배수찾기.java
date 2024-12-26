import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3_�ּҰ����ã�� {
	static List<Integer> prime = new ArrayList<>();
	static long a, b, L;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		L = Long.parseLong(st.nextToken());
		
		//L������ ������ ���߿��� �Ҽ��� �� ����
		makePrime();
//		for (int i=0;i<prime.size();i++) {
//			System.out.print(prime.get(i)+" ");
//		}
		
		//a ���μ�����
		long[] aArr = makeDivide(a);
		
		//b ���μ�����
		long[] bArr = makeDivide(b);
		
		//L ���μ�����
		long[] lArr = makeDivide(L);
		
		//L�� ���� �� �ִ� c ã��
		long c = 1;
		for (int i=0;i<prime.size();i++) {
			long aCnt = aArr[i];
			long bCnt = bArr[i];
			long lCnt = lArr[i];
			
			if (aCnt < lCnt && bCnt < lCnt) {
				c *= Math.pow(prime.get(i), lCnt);
//				System.out.println(c);
			}
		}
		
		if (lArr[prime.size()] > 0) {
			c *= lArr[prime.size()];
		}
		
		System.out.println(Arrays.toString(aArr));
		System.out.println(Arrays.toString(bArr));
		System.out.println(Arrays.toString(lArr));
		
		//����
		long divide = getDivideNum(a, b);
		long test = (a * b) / divide;
		divide = getDivideNum(test, c);
		test = (test * c) / divide;
		
//		System.out.println(test);
		
		if (test == L) {
			System.out.println(c);
		}
		else {
			System.out.println(-1);
		}
		
	}
	static long getDivideNum(long a, long b) {
		while (b != 0) {
			long tmp = b;
			b = a%b;
			a = tmp;
		}
		return a;
	}
	
	static long[] makeDivide(long num) {
		long[] cntArr = new long[prime.size()+1];
		
		for (int i=0;i<prime.size();i++) {
			int curPrime = prime.get(i);
			while (num % curPrime == 0) {
				num /= curPrime;
				cntArr[i]++;
			}
			if (num == 1) break;
		}
		
		if (num > 1) {
			cntArr[prime.size()] = num;
		}
		
		return cntArr;
	}
	
	static void makePrime() {
		int limit = (int) (Math.sqrt(L) + 1);
		boolean[] isPrime = new boolean[limit+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false; //�Ҽ� �ƴ�
		
		for (int i=2;i<=limit;i++) {
			if (isPrime[i]) {
				for (int j=i+i ; j<=limit; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		//true�� ������ ���������� �Ҽ�
		for (int i=2;i<=limit;i++) {
			if (isPrime[i]) prime.add(i);
		}
	}

}
