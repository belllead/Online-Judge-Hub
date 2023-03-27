import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {	
			int N = Integer.parseInt(br.readLine());
			int cnt2 = 0;
			int cnt3 = 0;
			int cnt5 = 0;
			int cnt7 = 0;
			int cnt11 = 0;
			
			while (N % 2 == 0) {
				N /= 2;
				cnt2++;
			}

			while (N % 3 == 0) {
				N /= 3;
				cnt3++;
			}
			
			while (N % 5 == 0) {
				N /= 5;
				cnt5++;
			}
			
			while (N % 7 == 0) {
				N /= 7;
				cnt7++;
			}
			
			while (N % 11 == 0) {
				N /= 11;
				cnt11++;
			}
			
			sb.append("#" + tc + " ").append(cnt2 + " " + cnt3 + " " + cnt5 + " " + cnt7 + " " + cnt11).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}