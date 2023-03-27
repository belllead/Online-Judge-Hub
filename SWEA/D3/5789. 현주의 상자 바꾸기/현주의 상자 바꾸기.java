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
			int N = Integer.parseInt(st.nextToken());
			int[] boxNum = new int[N];
			int Q = Integer.parseInt(st.nextToken());
			int[] L = new int[Q];
			int[] R = new int[Q];
			for (int i=0; i<Q; i++) {
				st = new StringTokenizer(br.readLine());
				L[i] = Integer.parseInt(st.nextToken());
				R[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#" + tc + " ");
			
			for (int i=0; i<Q; i++) {
				for (int j=L[i]-1; j<=R[i]-1; j++) {
					boxNum[j] = i+1;
				}
			}
			
			for (int i=0; i<N; i++) {
				sb.append(boxNum[i] + " ");
			}
			
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
	}
}