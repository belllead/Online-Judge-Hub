import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int[] ai = new int[A];
			int[] bj = new int[B];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<A; i++) {
				ai[i] = Integer.parseInt(st.nextToken());
				

			}
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<B; i++) {
				bj[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			int max = 0;
			
			if (A <= B) {
				for (int k=0; k<=B-A; k++) {
					for (int i=0; i<A; i++) {
						sum += ai[i] * bj[i+k];
					}
					if (max < sum) max = sum;
					sum = 0;
				}
			} else {
				for (int k=0; k<=A-B; k++) {
					for (int i=0; i<B; i++) {
						sum += bj[i] * ai[i+k];
					}
					if (max < sum) max = sum;
					sum = 0;
				}
			}
			
			sb.append("#" + tc + " ").append(max).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
}