import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] customer = new int[N];
			
			int lastCustomer = 0;
			for (int i=0; i<N; i++) {
				customer[i] = Integer.parseInt(st.nextToken());
				lastCustomer = Math.max(lastCustomer, customer[i]);
			}

			int cookedBoongeo = 0;
			String possibility = "Possible";
			
			for (int sec=0; sec<=lastCustomer; sec++) {
				if (sec != 0 && sec % M == 0) {
					cookedBoongeo += K;
				}
                
				for (int c : customer) {
					if (sec == c) {
						cookedBoongeo -= 1;
					}
				}
				
				if (cookedBoongeo < 0) {
					possibility = "Impossible";
					break;
				} 
			}
			
			sb.append("#" + tc + " ").append(possibility).append("\n");
			
		}
		
		System.out.println(sb.toString());
	
	}	
}