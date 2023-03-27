import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, m1, m2, d1, d2, nthDay, mDay;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] calendar;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		calendar = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			m1 = Integer.parseInt(st.nextToken());
			d1 = Integer.parseInt(st.nextToken());
			m2 = Integer.parseInt(st.nextToken());
			d2 = Integer.parseInt(st.nextToken());
			nthDay = 0;
			mDay = 0;
			
			if (m1 == m2) {
				nthDay = d2 - d1 + 1;
			} else {
				for (int i=m1-1; i<m2-1; i++)
					mDay += calendar[i];
				nthDay = mDay -d1 + d2 + 1;	
			}

			sb.append("#" + tc + " ").append(nthDay).append("\n");			
		}
		System.out.println(sb.toString());
	}
	
}