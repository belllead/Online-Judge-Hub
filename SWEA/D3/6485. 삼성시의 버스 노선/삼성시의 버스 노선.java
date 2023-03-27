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
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int P = Integer.parseInt(br.readLine());
			int[] C = new int[P];
			for (int i=0; i<P; i++) {
				C[i] = Integer.parseInt(br.readLine())-1;
			}
			
			int[] cnt = new int[5000];
			for (int i=0; i<N; i++) {
				for (int j=A[i]-1; j<=B[i]-1; j++)
					cnt[j]++;
			}
			
			sb.append("#" + tc + " ");
			
			for (int i=0; i<P; i++) {
				sb.append(cnt[C[i]] + " ");
			}			
			
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}
}