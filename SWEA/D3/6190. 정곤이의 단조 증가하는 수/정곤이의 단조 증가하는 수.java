import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int max;
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			A = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			max = -1;
			for (int j=N-1; j>=1; j--) {
				for (int i=j-1; i>=0; i--) {
					int temp = A[i] * A[j];
					if (max < temp) {
						if (increasingDigit(temp)) {
							max = temp;
						}					
					}
				}
			}
			sb.append("#" + tc + " " + max + "\n");			
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	public static boolean increasingDigit(int a) {
		while (a != 0) {
			int digit = a % 10;
			a /= 10;
			if (a % 10 > digit) return false;
		}
		
		return true;
	}
}