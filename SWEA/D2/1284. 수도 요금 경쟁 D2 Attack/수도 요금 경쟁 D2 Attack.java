import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		StringBuilder ans = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(in.readLine());
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int A = P * W;
			
			int B = 0;
			if (W < R) {
				B = Q;
			} else {
				B = Q + (W - R) * S;
			}
						
			int fee = (A < B) ? A : B;
			
			ans.append("#").append(tc).append(" ").append(fee).append("\n");
		}
		
		System.out.println(ans.toString());
		
		
	}
	
}